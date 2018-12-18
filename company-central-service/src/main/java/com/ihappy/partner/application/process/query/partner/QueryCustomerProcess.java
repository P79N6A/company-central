package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.partner.CustomerInfoQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.CustomerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/2.
 */
public class QueryCustomerProcess extends DefaultQueryProcess<CustomerInfoQueryReqDTO,CustomerInfoQueryRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private PartnerLevelService partnerLevelService;
    
    @Override
    public void process(Context<CustomerInfoQueryReqDTO, CustomerInfoQueryRespDTO> context) {
        CustomerInfoQueryReqDTO customerInfoQueryReqDTO = context.getParam();
        BaseinfoCompanyPartner baseinfoCompanyPartner = baseinfoCompanyPartnerMapper.selectByPrimaryKey(customerInfoQueryReqDTO.getPartnerId());
        if (baseinfoCompanyPartner == null || (baseinfoCompanyPartner.getPartnerType() != CompanyPartnerTypeEnum.CUSTOMER.getKey())){
            context.getResult().setModule(new CustomerInfoQueryRespDTO());
            return;
        }
        //客户/零售会员，没有partnerLinkman 则设为 partnerName
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(baseinfoCompanyPartner);
        CustomerInfoQueryRespDTO customerInfoQueryRespDTO = BaseInfoCompanyPartnerFactory.modelToCustomerInfoQueryRespDTO(baseinfoCompanyPartner);
        //填充会员等级相关信息
        Long partnerLevelId = baseinfoCompanyPartner.getPartnerLevelId();
        if (partnerLevelId != null && partnerLevelId != 0){
            BaseinfoCompanyPartnerLevel paramPartnerLevel = new BaseinfoCompanyPartnerLevel();
            paramPartnerLevel.setPartnerLevelId(partnerLevelId);
            PartnerLevelModel partnerLevelModel = partnerLevelService.selectById(new PartnerLevelModel(paramPartnerLevel));
            if (partnerLevelModel != null && partnerLevelModel.getDO() != null){
                customerInfoQueryRespDTO.setPartnerLevel(partnerLevelModel.getDO().getPartnerLevel());
                customerInfoQueryRespDTO.setDiscount(partnerLevelModel.getDO().getDiscount());
            }
        }
        context.getResult().setModule(customerInfoQueryRespDTO);
    }
}
