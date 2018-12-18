package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.util.DateUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.dto.response.companyinfo.CompanyExpireDateQueryRespDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by chenying on 2018/6/28.
 */
public class QueryCompanyExpireDateProcess extends DefaultQueryProcess<CompanyInfoByCompIdQuery,CompanyExpireDateQueryRespDTO> {

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private CompanyStoreService companyStoreService;


    @Override
    public void process(Context<CompanyInfoByCompIdQuery, CompanyExpireDateQueryRespDTO> context) {
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = context.getParam();
        //返回
        CompanyExpireDateQueryRespDTO companyExpireDateQueryRespDTO = new CompanyExpireDateQueryRespDTO();
        companyExpireDateQueryRespDTO.setStoreId(companyInfoByCompIdQuery.getStoreId());
        companyInfoByCompIdQuery.setCompId(Integer.valueOf(companyInfoByCompIdQuery.getLoginCompId().toString()));
        if (companyInfoByCompIdQuery.getLoginPersonId().longValue()== OptConstans.DEMO_ACCOUNT_1.longValue()||
            companyInfoByCompIdQuery.getLoginPersonId().longValue()==OptConstans.DEMO_ACCOUNT_2.longValue()||
            companyInfoByCompIdQuery.getLoginPersonId().longValue()== OptConstans.DEMO_ACCOUNT_3.longValue()) {
            companyExpireDateQueryRespDTO.setCompVaildDays(30);
            context.getResult().setModule(companyExpireDateQueryRespDTO);
            return;
        }
        CompanyModel companyModel = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        if (companyModel == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_NOT_EXIT.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT.getErrMsg());
        }
        BaseinfoCompany baseinfoCompany = companyModel.getDO();
        companyExpireDateQueryRespDTO.setCompId(companyInfoByCompIdQuery.getCompId());
        //公司状态 0黑名单  1普通 2白名单
        if(companyModel.getDO().getStatus().intValue() == 2){
            companyExpireDateQueryRespDTO.setCompVaildDays(300);
            context.getResult().setModule(companyExpireDateQueryRespDTO);
            return;
        }
        if(companyInfoByCompIdQuery.getStoreId() != null) {//兼容老接口
            CompanyStoreModel companyStoreModel = new CompanyStoreModel(new BaseinfoCompanyStore());
            companyStoreModel.getDO().setCompId(companyInfoByCompIdQuery.getCompId().intValue());
            companyStoreModel.getDO().setStoreId(companyInfoByCompIdQuery.getStoreId());
            //查询门店详情
            CompanyStoreModel storeInfo = companyStoreService.findByStoreIdAndCompId(companyStoreModel);
            //如果门店为空，则不存在
            if (storeInfo == null) {
                throw new CompanyException(StoreErrorCodeEnum.NO_STORE_FIND);
            }
            //数据异常的时候，返回过期
            if (storeInfo.getDO().getExpireDate() == null || storeInfo.getDO().getExpireDate().longValue() <0){
                companyExpireDateQueryRespDTO.setCompVaildDays(-1);
                context.getResult().setModule(companyExpireDateQueryRespDTO);
                return;
            }
            //历史脏数据，返回不过期
            if (storeInfo.getDO().getExpireDate().longValue() == 0 ){
                companyExpireDateQueryRespDTO.setCompVaildDays(30);
                context.getResult().setModule(companyExpireDateQueryRespDTO);
                return;
            }
            //过期时间比今天小，返回过期
            int difDate = DateUtil.getDifferentDays(new Date(),DateUtil.parseDateYMD(storeInfo.getDO().getExpireDate()+""));

            companyExpireDateQueryRespDTO.setCompVaildDays(difDate);
            companyExpireDateQueryRespDTO.setCompExpireDate(storeInfo.getDO().getExpireDate());
            context.getResult().setModule(companyExpireDateQueryRespDTO);
            return;
        }
        //数据异常的时候，返回过期
        if (baseinfoCompany.getExpireDate() == null || baseinfoCompany.getExpireDate().longValue() <0){
            companyExpireDateQueryRespDTO.setCompVaildDays(-1);
            context.getResult().setModule(companyExpireDateQueryRespDTO);
            return;
        }
        //历史脏数据，返回不过期
        if (baseinfoCompany.getExpireDate().longValue() == 0 ){
            companyExpireDateQueryRespDTO.setCompVaildDays(30);
            context.getResult().setModule(companyExpireDateQueryRespDTO);
            return;
        }
        //过期时间比今天小，返回过期
        int difDate = DateUtil.getDifferentDays(new Date(),DateUtil.parseDateYMD(baseinfoCompany.getExpireDate()+""));
        companyExpireDateQueryRespDTO.setCompVaildDays(difDate);
        companyExpireDateQueryRespDTO.setCompExpireDate(baseinfoCompany.getExpireDate());
        context.getResult().setModule(companyExpireDateQueryRespDTO);
    }
}
