package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoAddRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.factory.PartnerArrearsOrderFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/3.
 */
public class AddProviderProcess extends DefaultProcess<ProviderInfoAddReqDTO, ProviderInfoAddRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private PartnerArrearsOrderService partnerArrearsOrderService;

    @Override
    public void process(Context<ProviderInfoAddReqDTO, ProviderInfoAddRespDTO> context) {
        ProviderInfoAddReqDTO providerInfoAddReqDTO = context.getParam();
        CompanyPartnerModel companyPartnerModel = BaseInfoCompanyPartnerFactory.providerInfoAddReqDTOToModel(providerInfoAddReqDTO);
        Long partnerArrears = companyPartnerModel.getDO().getPartnerArrears();
        companyPartnerModel.getDO().setPartnerArrears(null);
        Integer res = baseinfoCompanyPartnerMapper.insertSelective(companyPartnerModel.getDO());
        //初始化欠款
        companyPartnerModel.getDO().setPartnerArrears(partnerArrears);
        if(companyPartnerModel.getDO().getPartnerArrears() != null && companyPartnerModel.getDO().getPartnerArrears() != 0){
            PartnerArrearsOrderModel order = PartnerArrearsOrderFactory.baseinfoCompanyPartnerToModel(companyPartnerModel.getDO());
            partnerArrearsOrderService.addPartnerArrearsOrder(order);
        }
        ProviderInfoAddRespDTO providerInfoAddRespDTO = new ProviderInfoAddRespDTO();
        providerInfoAddRespDTO.setPartnerId(companyPartnerModel.getDO().getPartnerId());
        context.getResult().setModule(providerInfoAddRespDTO);
    }
}
