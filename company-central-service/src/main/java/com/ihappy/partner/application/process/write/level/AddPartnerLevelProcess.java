package com.ihappy.partner.application.process.write.level;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.bo.level.CheckPartnerLevelBOByName;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.partner.domain.model.factory.PartnerLevelFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerLevelMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
public class AddPartnerLevelProcess extends DefaultProcess<PartnerLevelAddReqDTO, PartnerLevelAddRespDTO> {
    @Autowired
    private PartnerLevelService partnerLevelService;

    @Autowired
    private BaseinfoCompanyPartnerLevelMapper baseinfoCompanyPartnerLevelMapper;

    @Override
    public void process(Context<PartnerLevelAddReqDTO, PartnerLevelAddRespDTO> context) {
        PartnerLevelAddReqDTO reqDTO = context.getParam();
        PartnerLevelModel model = PartnerLevelFactory.partnerLevelAddReqDTOToModel(reqDTO);

        BaseinfoCompanyPartnerLevel reqModel = new BaseinfoCompanyPartnerLevel();
        reqModel.setCompId(Integer.parseInt(reqDTO.getLoginCompId()+""));
        List<BaseinfoCompanyPartnerLevel> resModels = baseinfoCompanyPartnerLevelMapper.selectPartnerLevelList(reqModel);
        if(!CollectionUtil.isEmpty(resModels) && resModels.size() > 9){
            throw new CompanyException(PartnerErrorCodeEnum.ADD_PARTNER_LEVEL_OVER_ERROR);
        }
        CheckPartnerLevelBOByName checkPartnerLevelBOByName = new CheckPartnerLevelBOByName();
        checkPartnerLevelBOByName.setCompId(reqDTO.getLoginCompId());
        checkPartnerLevelBOByName.setIsDeleted(0);
        checkPartnerLevelBOByName.setPartnerLevel(reqDTO.getPartnerLevel());
        List<PartnerLevelModel> list =  partnerLevelService.checkPartnerLevelName(checkPartnerLevelBOByName);

        if(!CollectionUtil.isEmpty(list)){
            throw new CompanyException(PartnerErrorCodeEnum.ADD_PARTNER_LEVEL_NAME_ERROR);
        }

        Long partnerLevelId = partnerLevelService.addPartnerLevel(model);
        PartnerLevelAddRespDTO respDTO = new PartnerLevelAddRespDTO();
        respDTO.setPartnerLevelId(partnerLevelId);
        context.getResult().setModule(respDTO);
    }
}
