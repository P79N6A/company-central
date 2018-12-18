package com.ihappy.partner.application.process.query.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.model.factory.PartnerLevelFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/26.
 */
public class QueryPartnerLevelProcess extends DefaultQueryProcess<PartnerLevelQueryReqDTO,PartnerLevelQueryRespDTO> {
    @Autowired
    private PartnerLevelService partnerLevelService;
    @Override
    public void process(Context<PartnerLevelQueryReqDTO, PartnerLevelQueryRespDTO> context) {
        PartnerLevelQueryReqDTO reqDTO = context.getParam();
        PartnerLevelModel model = PartnerLevelFactory.partnerLevelQueryReqDTOToDTO(reqDTO);
        PartnerLevelModel resModel = partnerLevelService.selectById(model);
        PartnerLevelQueryRespDTO res = PartnerLevelFactory.modelToPartnerLevelQueryRespDTO(resModel);
        context.getResult().setModule(res);
    }
}
