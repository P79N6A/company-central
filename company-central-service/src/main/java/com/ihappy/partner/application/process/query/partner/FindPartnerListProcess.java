package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.PartnerListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/10/31.
 */
public class FindPartnerListProcess extends DefaultQueryProcess<PartnerListQueryReqDTO,List<PartnerInfoQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Override
    public void process(Context<PartnerListQueryReqDTO, List<PartnerInfoQueryRespDTO>> context) {
        PartnerListQueryReqDTO reqDTO = context.getParam();
        BaseinfoCompanyPartner param = getParam(reqDTO);
        List<BaseinfoCompanyPartner> partners = baseinfoCompanyPartnerMapper.selectByCondition(param);
        List<PartnerInfoQueryRespDTO> respDTOS = BaseInfoCompanyPartnerFactory.partnerList2PartnerInfoQueryRespDTOList(partners);
        context.getResult().setModule(respDTOS);
    }

    private BaseinfoCompanyPartner getParam(PartnerListQueryReqDTO reqDTO){
        BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
        param.setCompId(reqDTO.getCompId().intValue());
        param.setPartnerType(reqDTO.getPartnerType());
        param.setIsDeleted(reqDTO.getIsDeleted());
        param.setIsDefault(reqDTO.getIsDefault());
        return param;
    }
}
