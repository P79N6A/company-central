package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dto.request.partner.PartnerLastContactTimeReqDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/20.
 */
public class UpdatePartnerLastContactTimeProcess extends DefaultProcess<PartnerLastContactTimeReqDTO, String> {
    @Autowired
    BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Override
    public void process(Context<PartnerLastContactTimeReqDTO, String> context) {
        PartnerLastContactTimeReqDTO reqDTO = context.getParam();
        CompanyPartnerModel reqModel = BaseInfoCompanyPartnerFactory.partnerLastContactTimeReqDTOToModel(reqDTO);
        Integer res = baseinfoCompanyPartnerMapper.updateLastContactTime(reqModel.getDO());
        if(res <= 0){
            throw new CompanyException(PartnerErrorCodeEnum.
                    UPDATE_PARTNER_LAST_CONTACT_TIME_ERROR.getErrCode(),
                    PartnerErrorCodeEnum.UPDATE_PARTNER_LAST_CONTACT_TIME_ERROR.getErrMsg());
        }
        context.getResult().setModule("更新成功");
    }
}
