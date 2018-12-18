package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.partner.domain.dto.request.partner.PartnerArrearsOrderAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerArrearsOrderAddRespDTO;
import com.ihappy.partner.domain.model.factory.PartnerArrearsOrderFactory;
import com.ihappy.partner.domain.model.model.PartnerArrearsOrderModel;
import com.ihappy.partner.infrastructure.service.inside.PartnerArrearsOrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/18.
 */
public class AddPartnerArrearsOrderProcess extends DefaultProcess<PartnerArrearsOrderAddReqDTO, PartnerArrearsOrderAddRespDTO> {
    @Autowired
    private PartnerArrearsOrderService partnerArrearsOrderService;
    @Override
    public void process(Context<PartnerArrearsOrderAddReqDTO, PartnerArrearsOrderAddRespDTO> context) {
        PartnerArrearsOrderAddReqDTO reqDTO = context.getParam();
        PartnerArrearsOrderModel reqModel = PartnerArrearsOrderFactory.addReqDTOToModel(reqDTO);
        Long res = partnerArrearsOrderService.addPartnerArrearsOrder(reqModel);
        PartnerArrearsOrderAddRespDTO respDTO = new PartnerArrearsOrderAddRespDTO();
        respDTO.setOrderId(res);
        context.getResult().setModule(respDTO);
    }
}