package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideAddReqDTO;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideQueryReqDTO;
import com.ihappy.partner.domain.dto.response.partner.ProviderInfoInsideAddRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import com.ihappy.partner.infrastructure.util.PartnerUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/7.
 */
public class AddOrQueryProviderInsideProcess extends DefaultProcess<ProviderInfoInsideAddReqDTO, ProviderInfoInsideAddRespDTO> {

    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private PartnerLevelService partnerLevelService;

    @Autowired
    private BaseinfoCompanyPartnerMapper baseinfoCompanyPartnerMapper;

    @Override
    public void process(Context<ProviderInfoInsideAddReqDTO, ProviderInfoInsideAddRespDTO> context) {

        ProviderInfoInsideAddRespDTO respDTO = new ProviderInfoInsideAddRespDTO();

        ProviderInfoInsideAddReqDTO providerInfoInsideAddReqDTO = context.getParam();

        ProviderInfoInsideQueryReqDTO reqDTO = new ProviderInfoInsideQueryReqDTO();
        reqDTO.setCompId(providerInfoInsideAddReqDTO.getBuyerCompId());
        reqDTO.setPartnerCompId(providerInfoInsideAddReqDTO.getPartnerCompId());
        reqDTO.setPartnerType(providerInfoInsideAddReqDTO.getPartnerType());
        CompanyPartnerModel companyPartnerModel = companyPartnerService.getProviderInfoInsideQuery(reqDTO);
        if(companyPartnerModel == null){
            BaseinfoCompany companyQuery = new BaseinfoCompany();
            companyQuery.setCompId(providerInfoInsideAddReqDTO.getBuyerCompId());
            BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfo(companyQuery);
            BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
            baseinfoCompanyPartner.setPartnerType(providerInfoInsideAddReqDTO.getPartnerType());
            baseinfoCompanyPartner.setPartnerName(providerInfoInsideAddReqDTO.getPartnerName());
            baseinfoCompanyPartner.setPartnerCompId(providerInfoInsideAddReqDTO.getPartnerCompId());
            if(baseinfoCompany != null){
                baseinfoCompanyPartner.setCompName(baseinfoCompany.getCompName());
                if (StringUtils.isBlank(providerInfoInsideAddReqDTO.getPartnerName())){
                    baseinfoCompanyPartner.setPartnerName(baseinfoCompany.getCompShortName());
                }
            }
            baseinfoCompanyPartner.setCompId(providerInfoInsideAddReqDTO.getBuyerCompId());
            baseinfoCompanyPartner.setPartnerId(DistributedPrimaryKeyFactory.generateCompanyPartnerId( providerInfoInsideAddReqDTO.getBuyerCompId()));
            baseinfoCompanyPartner.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
            baseinfoCompanyPartner.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
            baseinfoCompanyPartner.setCreatedPersonId(providerInfoInsideAddReqDTO.getCreatedPersonId());
            baseinfoCompanyPartner.setUpdatedPersonId(providerInfoInsideAddReqDTO.getCreatedPersonId());
            baseinfoCompanyPartner.setPartnerLinkman(providerInfoInsideAddReqDTO.getPartnerLinkman());
            if (providerInfoInsideAddReqDTO.getMobile() == null && baseinfoCompany != null){
                baseinfoCompanyPartner.setMobile(baseinfoCompany.getAdminPersonMobile());
            }else {
                baseinfoCompanyPartner.setMobile(providerInfoInsideAddReqDTO.getMobile());
            }
            //零售会员，没有partnerLinkman 则设为 partnerName
            PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(baseinfoCompanyPartner);
            baseinfoCompanyPartnerMapper.insertSelective(baseinfoCompanyPartner);
            respDTO = BaseInfoCompanyPartnerFactory.toProviderInfoInsideAddRespDTO(baseinfoCompanyPartner);
        }else {
            //零售会员，没有partnerLinkman 则设为 partnerName
            PartnerUtil.fillCustomerPartnerOrPartnerLinkMan(companyPartnerModel.getDO());
            respDTO = BaseInfoCompanyPartnerFactory.toProviderInfoInsideAddRespDTO(companyPartnerModel.getDO());
            if(providerInfoInsideAddReqDTO.getPartnerType() != 0 && companyPartnerModel.getDO().getPartnerLevelId().longValue() !=0L){
                BaseinfoCompanyPartnerLevel paramPartnerLevel = new BaseinfoCompanyPartnerLevel();
                paramPartnerLevel.setPartnerLevelId(companyPartnerModel.getDO().getPartnerLevelId());
                PartnerLevelModel partnerLevelModel = partnerLevelService.selectById(new PartnerLevelModel(paramPartnerLevel));
                if (partnerLevelModel.getDO() != null){
                    respDTO.setPartnerDiscount(partnerLevelModel.getDO().getDiscount());
                    respDTO.setPartnerLevelName(partnerLevelModel.getDO().getPartnerLevel() == null?"":partnerLevelModel.getDO().getPartnerLevel());
                }
            }
        }
        context.getResult().setModule(respDTO);
    }
}
