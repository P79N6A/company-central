package com.ihappy.partner.application.process.write.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.bo.level.CheckPartnerLevelBOByName;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.model.factory.PartnerLevelFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
public class UpdatePartnerLevelProcess extends DefaultProcess<PartnerLevelUpdateReqDTO, String> {
    @Autowired
    private PartnerLevelService partnerLevelService;
    @Override
    public void process(Context<PartnerLevelUpdateReqDTO, String> context) {
        PartnerLevelUpdateReqDTO reqDTO = context.getParam();
        CheckPartnerLevelBOByName checkPartnerLevelBOByName = new CheckPartnerLevelBOByName();
        checkPartnerLevelBOByName.setPartnerLevelId(reqDTO.getPartnerLevelId());
        checkPartnerLevelBOByName.setCompId(reqDTO.getLoginCompId());
        checkPartnerLevelBOByName.setIsDeleted(0);
        checkPartnerLevelBOByName.setPartnerLevel(reqDTO.getPartnerLevel());
        List<PartnerLevelModel> list =  partnerLevelService.checkPartnerLevelName(checkPartnerLevelBOByName);
        if(!CollectionUtil.isEmpty(list)){
            throw new CompanyException(PartnerErrorCodeEnum.ADD_PARTNER_LEVEL_NAME_ERROR);
        }
        PartnerLevelModel model = PartnerLevelFactory.partnerLevelUpdateReqDTOToModel(reqDTO);
        Integer res = partnerLevelService.updatePartnerLevel(model);
        if (res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.UPDATE_PARTNER_LEVEL_ERROR.getErrCode(),PartnerErrorCodeEnum.UPDATE_PARTNER_LEVEL_ERROR.getErrMsg());
        }
        context.getResult().setModule("修改成功");
    }
}
