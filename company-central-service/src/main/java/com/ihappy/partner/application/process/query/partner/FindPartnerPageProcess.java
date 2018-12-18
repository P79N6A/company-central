package com.ihappy.partner.application.process.query.partner;

import com.ihappy.common.domain.Page;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.util.AmountUtils;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.PartnerPageReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/8/10.
 */
public class FindPartnerPageProcess extends DefaultQueryProcess<PartnerPageReqDTO,Page<PartnerInfoQueryRespDTO>> {
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<PartnerPageReqDTO, Page<PartnerInfoQueryRespDTO>> context) {
        PartnerPageReqDTO reqDTO = context.getParam();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("compId",Integer.valueOf(reqDTO.getLoginCompId().toString()));
        map.put("partnerType",reqDTO.getPartnerType());
        map.put("limit",reqDTO.getLimit());
        map.put("offset",reqDTO.getOffset());
        map.put("sort",reqDTO.getSort());
        map.put("order",reqDTO.getOrder());
        map.put("searchStr",reqDTO.getSearchStr());
        Integer total = companyPartnerService.findPartnerCheckCount(map);
        List<PartnerInfoQueryRespDTO> list = new ArrayList<PartnerInfoQueryRespDTO>();
        if (total == 0){
            Page<PartnerInfoQueryRespDTO> res = new Page(1, 1, total, list);
            context.setResultModule(res);
            return;
        }
        List<BaseinfoCompanyPartner> partnerList = companyPartnerService.findPartnerCheckPage(map);
        PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(partnerList);
        list = BaseInfoCompanyPartnerFactory.partnerList2PartnerInfoQueryRespDTOList(partnerList);
        list.forEach((obj) -> {
            obj.setPrepaidDepositY(AmountUtils.changeF2Y(obj.getPrepaidDeposit()));
            obj.setPartnerArrearsY(AmountUtils.changeF2Y(obj.getPartnerArrears()));
            obj.setDueAmountY(AmountUtils.changeF2Y(obj.getDueAmount()));
        });
        Page<PartnerInfoQueryRespDTO> res = new Page(1, 1, total, list);
        context.setResultModule(res);
    }
}
