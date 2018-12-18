package com.ihappy.partner.application.process.query.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.company.IsDefaultEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.PartnerDefQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by sunjd on 2018/8/23.
 */
public class FindDefaultPartnerProcess extends DefaultProcess<PartnerDefQueryReqDTO,PartnerInfoQueryRespDTO> {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<PartnerDefQueryReqDTO, PartnerInfoQueryRespDTO> context) {
        PartnerDefQueryReqDTO reqDTO = context.getParam();
        PartnerInfoQueryRespDTO respDTO = new PartnerInfoQueryRespDTO();
        BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
        param.setCompId(Integer.valueOf(reqDTO.getLoginCompId().toString()));
        param.setPartnerType(reqDTO.getPartnerType());
        param.setIsDefault(IsDefaultEnum.DEFAULT.getKey());
        List<BaseinfoCompanyPartner> partnerList = companyPartnerService.selectByCondition(param);
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(partnerList);
        if (CollectionUtils.isEmpty(partnerList)){
            throw new CompanyException(PartnerErrorCodeEnum.
                    NO_DEFAULT_PARTNER.getErrCode(),
                    PartnerErrorCodeEnum.NO_DEFAULT_PARTNER.getErrMsg());
        }
        respDTO = BaseInfoCompanyPartnerFactory.partner2PartnerInfoQueryRespDTO(partnerList.get(0));
        if (reqDTO.hideDebtAndPrepaidDeposit()){
            respDTO.removeDebtAndPrepaidDeposit();
        }
        context.getResult().setModule(respDTO);
    }
}
