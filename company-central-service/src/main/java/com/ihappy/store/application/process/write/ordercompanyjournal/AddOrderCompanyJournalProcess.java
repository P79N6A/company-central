package com.ihappy.store.application.process.write.ordercompanyjournal;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.company.domain.bo.OrderCompanyJournalByCompIdBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.OrderCompanyJournal;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoWithoutLoginQueryReqDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.factory.OrderCompanyJournalFactory;
import com.ihappy.company.domain.model.model.OrderCompanyJournalModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.OrderCompanyJournalService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.ordercompanyjournal.OrderCompanyJournalReqDTO;
import com.ihappy.store.domain.dto.response.ordercompanyjournal.OrderCompanyJournalRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhc on 2018/6/28.
 */
public class AddOrderCompanyJournalProcess extends DefaultProcess<OrderCompanyJournalReqDTO, OrderCompanyJournalRespDTO> {

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private OrderCompanyJournalService orderCompanyJournalService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<OrderCompanyJournalReqDTO, OrderCompanyJournalRespDTO> context) {

        OrderCompanyJournalReqDTO reqDTO = context.getParam();

        //判断外部订单号是否重复
        if(!StringUtil.isBlank(reqDTO.getSourceOrderNo())){
            //作废过的单子，外部订单号还可以继续使用
            List<Integer> cancelList = new ArrayList<>();
            OrderCompanyJournalByCompIdBO orderCompanyJournalByCompIdBO = new OrderCompanyJournalByCompIdBO();
            orderCompanyJournalByCompIdBO.setSourceOrderNo(reqDTO.getSourceOrderNo());
            cancelList.add(0);
            cancelList.add(2);
            orderCompanyJournalByCompIdBO.setCancelList(cancelList);
            List<OrderCompanyJournalModel> checkList = orderCompanyJournalService.getOrderCompanyJournalDetailByCompId(orderCompanyJournalByCompIdBO);
            if(!CollectionUtil.isEmpty(checkList)){
                throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ORDER_JOURNAL_SOURCE_NO_ERROR);
            }
        }
        //获取公司信息
        CompanyInfoWithoutLoginQueryReqDTO companyInfo = new CompanyInfoWithoutLoginQueryReqDTO();
        companyInfo.setCompId(Integer.parseInt(reqDTO.getCompId()+""));
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoWithoutLoginQueryReqDTOTOBaseinfoCompany(companyInfo));
        if(baseinfoCompany == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ISEXIST);
        }
        CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
        companyStoreModel.getDO().setCompId(reqDTO.getCompId().intValue());
        companyStoreModel.getDO().setStoreId(reqDTO.getStoreId());
        //查询门店详情
        CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
        //如果门店为空，则不存在
        if (storeInfo == null) {
            throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
        }

        //获取do
        OrderCompanyJournal orderCompanyJournal = OrderCompanyJournalFactory.orderCompanyJournalReqDTOToDO(reqDTO);

        orderCompanyJournal.setRegisterPersonId(baseinfoCompany.getAdminPersonId());
        orderCompanyJournal.setRegisterPersonMobile(baseinfoCompany.getAdminPersonMobile());
        orderCompanyJournal.setCtId(Integer.parseInt(baseinfoCompany.getCtIds()));
        orderCompanyJournal.setRegisterTime(baseinfoCompany.getCreatedAt());
        orderCompanyJournal.setOrderNo(CompanyRedisUtil.getOrderNo());
        //调用户中心接口 获取老板信息
        BaseinfoPersonRespDTO baseinfoPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(baseinfoCompany.getAdminPersonId(), ConfigCenterUtil.ENV);
       if(baseinfoPersonRespDTO != null){
           orderCompanyJournal.setRegisterPersonId(baseinfoPersonRespDTO.getPersonId());//注册人id
           orderCompanyJournal.setRegisterPersonMobile(baseinfoPersonRespDTO.getMobile());//注册人手机号
           //获取邀请人信息
           if(baseinfoPersonRespDTO.getpPersonId() !=0L){
               BaseinfoPersonRespDTO invitePerson = SysAndPersonRedisUtil.getUserInfoKey(baseinfoPersonRespDTO.getpPersonId(), ConfigCenterUtil.ENV);
               if(invitePerson != null){
                   orderCompanyJournal.setInvitePersonMobile(invitePerson.getMobile());//邀请人手机号
                   orderCompanyJournal.setInvitePersonId(invitePerson.getPersonId());//邀请人id
               }
           }
       }

       //获取运营人员信息
       BaseinfoPersonRespDTO sysPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(reqDTO.getLoginPersonId(), ConfigCenterUtil.ENV);
       if(sysPersonRespDTO != null){
           orderCompanyJournal.setMemoPersonName(sysPersonRespDTO.getPersonName());
       }
       //待审核
        orderCompanyJournal.setIsCancel(0);
        // 数据入库
        orderCompanyJournalService.addOrderCompanyJournal(orderCompanyJournal);

        OrderCompanyJournalRespDTO orderCompanyJournalRespDTO = new OrderCompanyJournalRespDTO();
        orderCompanyJournalRespDTO.setMessage("添加成功");
        orderCompanyJournalRespDTO.setOrderId(orderCompanyJournal.getOrderId());
        context.getResult().setModule(orderCompanyJournalRespDTO);
    }

}
