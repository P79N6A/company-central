package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.partner.CustomerInfoListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CustomerInfoListQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/2.
 */
public class QueryCustomerListProcess extends DefaultQueryProcess<CustomerInfoListQueryReqDTO,List<CustomerInfoListQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private PartnerLevelService partnerLevelService;

    @Override
    public void process(Context<CustomerInfoListQueryReqDTO, List<CustomerInfoListQueryRespDTO>> context) {
        CustomerInfoListQueryReqDTO customerInfoListQueryReqDTO = context.getParam();
        List<BaseinfoCompanyPartner> list = baseinfoCompanyPartnerMapper.selectListByCustomerInfoQueryRespDTO(BaseInfoCompanyPartnerFactory.customerInfoListQueryReqDTOToModel(customerInfoListQueryReqDTO));
        if(customerInfoListQueryReqDTO.getOverstriking() != null && customerInfoListQueryReqDTO.getOverstriking() && customerInfoListQueryReqDTO.getSearchStr() != null && !customerInfoListQueryReqDTO.getSearchStr().equals("") ){
            for(BaseinfoCompanyPartner obj : list){
                obj.setPartnerName(obj.getPartnerName().replace(customerInfoListQueryReqDTO.getSearchStr(),"<b>"+customerInfoListQueryReqDTO.getSearchStr()+"</b>"));
                obj.setMobile(obj.getMobile().replace(customerInfoListQueryReqDTO.getSearchStr(),"<b>"+customerInfoListQueryReqDTO.getSearchStr()+"</b>"));
            }
        }
        //客户/零售会员，没有partnerLinkman 则设为 partnerName
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(list);
        List<CustomerInfoListQueryRespDTO> res = BaseInfoCompanyPartnerFactory.modelListToCustomerInfoQueryRespDTOList(list);

        for (CustomerInfoListQueryRespDTO obj : res){
            //填充会员等级相关信息
            Long partnerLevelId = obj.getPartnerLevelId();
            if (partnerLevelId != null && partnerLevelId != 0){
                BaseinfoCompanyPartnerLevel paramPartnerLevel = new BaseinfoCompanyPartnerLevel();
                paramPartnerLevel.setPartnerLevelId(partnerLevelId);
                PartnerLevelModel partnerLevelModel = partnerLevelService.selectById(new PartnerLevelModel(paramPartnerLevel));
                if (partnerLevelModel.getDO() != null){
                    obj.setPartnerLevel(partnerLevelModel.getDO().getPartnerLevel());
                    obj.setDiscount(partnerLevelModel.getDO().getDiscount());
                }
            }
        }
        context.getResult().setModule(res);
    }
}
