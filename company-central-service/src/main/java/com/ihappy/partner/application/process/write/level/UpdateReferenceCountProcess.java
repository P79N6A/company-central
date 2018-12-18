package com.ihappy.partner.application.process.write.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelReferenceCountReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelReferenceCountRespDTO;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunjd on 2018/5/3.
 */
public class UpdateReferenceCountProcess extends DefaultProcess<PartnerLevelReferenceCountReqDTO, PartnerLevelReferenceCountRespDTO> {
    @Autowired
    private PartnerLevelService partnerLevelService;
    @Override
    public void process(Context<PartnerLevelReferenceCountReqDTO, PartnerLevelReferenceCountRespDTO> context) {
        PartnerLevelReferenceCountReqDTO reqDTO = context.getParam();
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("partnerLevelIds",reqDTO.getPartnerLevelIds());
        paramMap.put("operation",reqDTO.getOperation());
        Integer updateCount = partnerLevelService.updateReferenceCount(paramMap);
        if (updateCount == null || updateCount ==0){
            throw new CompanyException(PartnerErrorCodeEnum.UPDATE_PARTNER_LEVEL_REFERENCE_COUNT_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_PARTNER_LEVEL_REFERENCE_COUNT_ERROR.getErrMsg());
        }
        PartnerLevelReferenceCountRespDTO respDTO = new PartnerLevelReferenceCountRespDTO();
        respDTO.setSuccess(true);
        context.getResult().setModule(respDTO);
    }
}
