package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoListQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoListQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/3/31.
 */
public class QueryPartnerListProcess extends DefaultQueryProcess<ProviderInfoListQueryReqDTO,List<ProviderInfoListQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Override
    public void process(Context<ProviderInfoListQueryReqDTO, List<ProviderInfoListQueryRespDTO>> context) {
        ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO = context.getParam();
        List<BaseinfoCompanyPartner> list = baseinfoCompanyPartnerMapper.selectListByProviderInfoQueryRespDTO(BaseInfoCompanyPartnerFactory.providerInfoListQueryReqDTOToModel(providerInfoListQueryReqDTO));
        if(providerInfoListQueryReqDTO.getOverstriking() != null && providerInfoListQueryReqDTO.getOverstriking() && providerInfoListQueryReqDTO.getSearchStr() != null && !providerInfoListQueryReqDTO.getSearchStr().equals("") ){
            for(BaseinfoCompanyPartner obj : list){
                obj.setPartnerName(obj.getPartnerName().replace(providerInfoListQueryReqDTO.getSearchStr(),"<b>"+providerInfoListQueryReqDTO.getSearchStr()+"</b>"));
                obj.setMobile(obj.getMobile().replace(providerInfoListQueryReqDTO.getSearchStr(),"<b>"+providerInfoListQueryReqDTO.getSearchStr()+"</b>"));
            }
        }
        context.getResult().setModule(BaseInfoCompanyPartnerFactory.modelListToProviderInfoQueryRespDTOList(list));
    }
}
