package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.partner.PartnerInfoQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/5/14.
 */
public class FindPartnerProcess extends DefaultQueryProcess<PartnerInfoQueryReqDTO,PartnerInfoQueryRespDTO> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private PartnerLevelService partnerLevelService;

    @Override
    public void process(Context<PartnerInfoQueryReqDTO, PartnerInfoQueryRespDTO> context) {
        PartnerInfoQueryReqDTO partnerInfoQueryReqDTO = context.getParam();
        BaseinfoCompanyPartner baseinfoCompanyPartner = baseinfoCompanyPartnerMapper.selectByPrimaryKey(partnerInfoQueryReqDTO.getPartnerId());
        if (baseinfoCompanyPartner == null){
            context.getResult().setModule(new PartnerInfoQueryRespDTO());
            return;
        }
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(baseinfoCompanyPartner);
        PartnerInfoQueryRespDTO partnerInfoQueryRespDTO = BaseInfoCompanyPartnerFactory.partner2PartnerInfoQueryRespDTO(baseinfoCompanyPartner);
        //填充会员等级相关信息
        Long partnerLevelId = baseinfoCompanyPartner.getPartnerLevelId();
        if (partnerLevelId != null && partnerLevelId != 0){
            BaseinfoCompanyPartnerLevel paramPartnerLevel = new BaseinfoCompanyPartnerLevel();
            paramPartnerLevel.setPartnerLevelId(partnerLevelId);
            PartnerLevelModel partnerLevelModel = partnerLevelService.selectById(new PartnerLevelModel(paramPartnerLevel));
            if (partnerLevelModel != null && partnerLevelModel.getDO() != null){
                partnerInfoQueryRespDTO.setPartnerLevel(partnerLevelModel.getDO().getPartnerLevel());
                partnerInfoQueryRespDTO.setDiscount(partnerLevelModel.getDO().getDiscount());
            }
        }
        context.getResult().setModule(partnerInfoQueryRespDTO);
    }
}
