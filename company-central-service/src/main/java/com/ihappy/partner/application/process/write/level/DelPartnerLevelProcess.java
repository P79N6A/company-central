package com.ihappy.partner.application.process.write.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.model.factory.PartnerLevelFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/26.
 */
public class DelPartnerLevelProcess extends DefaultProcess<PartnerLevelDelReqDTO, String> {
    @Autowired
    private PartnerLevelService partnerLevelService;
    @Override
    public void process(Context<PartnerLevelDelReqDTO, String> context) {
        PartnerLevelDelReqDTO reqDTO = context.getParam();
        PartnerLevelModel model = PartnerLevelFactory.partnerLevelDelReqDTOToModel(reqDTO);
        Integer res = partnerLevelService.delPartnerLevel(model);
        if (res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.
                    DEL_PARTNER_LEVEL_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.DEL_PARTNER_LEVEL_ERROR.getErrMsg());
        }
        context.getResult().setModule("删除成功");
    }
}
