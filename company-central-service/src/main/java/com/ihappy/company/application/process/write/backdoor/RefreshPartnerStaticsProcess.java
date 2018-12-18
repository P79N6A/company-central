package com.ihappy.company.application.process.write.backdoor;

import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.domain.dto.request.AllCompanyInfoPageQueryReqDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.partner.common.enumtype.Partner.CompanyPartnerTypeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/8/11.
 */
public class RefreshPartnerStaticsProcess extends DefaultProcess<BaseReqDTO, String> {
    private final static Logger logger = CompanyLoggerUtil.getLogger();
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<BaseReqDTO, String> context) {
        int companyCount  = companyInfoService.queryAllCompanyCouut();
        // 每次处理50个公司
        int limit = 50;
        for(int offset = 0; offset < companyCount; offset += limit){
            AllCompanyInfoPageQueryReqDTO allCompanyInfoPageQueryReqDTO = new AllCompanyInfoPageQueryReqDTO();
            allCompanyInfoPageQueryReqDTO.setOffset(offset);
            allCompanyInfoPageQueryReqDTO.setLimit(limit);
            allCompanyInfoPageQueryReqDTO.setSort("comp_id");
            allCompanyInfoPageQueryReqDTO.setOrder("asc");
            List<CompanyModel> companyModels = companyInfoService.queryCompanyInfoByPage(allCompanyInfoPageQueryReqDTO);
            for(CompanyModel companyModel : companyModels){
                BaseinfoCompanyPartner param = new BaseinfoCompanyPartner();
                param.setCompId(companyModel.getDO().getCompId());
                List<BaseinfoCompanyPartner> partnerList = baseinfoCompanyPartnerMapper.selectSelective(param);
                for (BaseinfoCompanyPartner obj : partnerList){
                    Integer orderType = 0;
                    if (obj.getPartnerType() == CompanyPartnerTypeEnum.PROVIDER.getKey()){
                        orderType = 1;
                    }else if (obj.getPartnerType() == CompanyPartnerTypeEnum.CUSTOMER.getKey()){
                        orderType = 3;
                    }else if (obj.getPartnerType() == CompanyPartnerTypeEnum.RETAIL_CUSTOMER.getKey()){
                        orderType = 500;
                    }

                    companyPartnerService.updatePartnerStatistics(obj.getPartnerId(), orderType, Long.valueOf(obj.getCompId()));
                }
            }
        }
        context.setResultSuccess(true);
        context.setResultModule("刷新Partner 统计数据成功");
    }
}
