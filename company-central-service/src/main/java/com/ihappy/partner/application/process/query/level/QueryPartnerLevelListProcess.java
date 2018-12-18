package com.ihappy.partner.application.process.query.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.partner.domain.model.factory.PartnerLevelFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
public class QueryPartnerLevelListProcess extends DefaultQueryProcess<PartnerLevelListQueryReqDTO,List<PartnerLevelQueryRespDTO>> {
    @Autowired
    private PartnerLevelService partnerLevelService;
    @Override
    public void process(Context<PartnerLevelListQueryReqDTO, List<PartnerLevelQueryRespDTO>> context) {
        PartnerLevelListQueryReqDTO reqDTO = context.getParam();
        PartnerLevelModel reqModel = PartnerLevelFactory.partnerLevelListQueryReqDTOToModel(reqDTO);
        List<PartnerLevelModel> resModels = partnerLevelService.selectPartnerLevelList(reqModel);
        context.getResult().setModule(PartnerLevelFactory.modelListToPartnerLevelQueryRespDTOList(resModels));
    }
}
