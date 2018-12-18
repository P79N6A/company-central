package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.service.outside.CompanyBaseInfoGrantService;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.CompanyInfoAddReqDTO;
import com.ihappy.company.domain.dto.response.CompanyInfoAddRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.item.domain.dto.request.DefaultInfoGrantReqDTO;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/4/2.
 */
public class AddCompanyInfoProcess extends DefaultProcess<CompanyInfoAddReqDTO, CompanyInfoAddRespDTO> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Autowired
    private CompanyBaseInfoGrantService companyBaseInfoGrantService;

    @Autowired
    private PartnerLevelService partnerLevelService;
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompanyInfoAddReqDTO, CompanyInfoAddRespDTO> context) {
        CompanyInfoAddReqDTO companyInfoAddReqDTO = context.getParam();
        CompanyModel companyModel = BaseinfoCompanyFactory.companyInfoAddReqDTOToModel(companyInfoAddReqDTO);
        //填充公司业务分类名称
        companyModel.getDO().setCtNames(companyInfoService.getCtNamesByCtIds(companyModel.getDO().getCtIds()));
        //插入公司
        Integer res = baseinfoCompanyMapper.insertSelective(companyModel.getDO());
        if(res == null || res != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    INSERT_COMPANY_FAILED.getErrCode(),
                    CompanyErrorCodeEnum.INSERT_COMPANY_FAILED.getErrMsg());
        }

        //添加默认企业VIP
        BaseinfoCompanyPartnerLevel baseinfoCompanyPartnerLevel = new BaseinfoCompanyPartnerLevel();
        baseinfoCompanyPartnerLevel.setCompId(companyModel.getDO().getCompId());
        if(companyInfoAddReqDTO.getCtIds().equals("3")){
            baseinfoCompanyPartnerLevel.setPartnerLevel(OptConstans.DEF_PARTNER_LEVEL_NAME);
        }else {
            baseinfoCompanyPartnerLevel.setPartnerLevel(OptConstans.DEF_PARTNER_COM_LEVEL_NAME);
        }

        baseinfoCompanyPartnerLevel.setDiscount(OptConstans.DEF_PARTNER_LEVEL_DISCOUNT);
        baseinfoCompanyPartnerLevel.setCreatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getCreateTime()));
        baseinfoCompanyPartnerLevel.setUpdatedAt(CompanyDateUtil.getDate14Long(companyInfoAddReqDTO.getUpdateTime()));
        baseinfoCompanyPartnerLevel.setCreatedPersonId(companyInfoAddReqDTO.getLoginPersonId());
        baseinfoCompanyPartnerLevel.setUpdatedPersonId(companyInfoAddReqDTO.getLoginPersonId());
        baseinfoCompanyPartnerLevel.setIsDefault(1);
        PartnerLevelModel partnerLevelModel = new PartnerLevelModel(baseinfoCompanyPartnerLevel);
        Long partnerLevelId = partnerLevelService.addPartnerLevel(partnerLevelModel);

        //复制角色组
        /*List<CompanyRoleBO> companyRoleBOs = sysCompanyRoleService.findAllSysRoleListByCtIds(companyModel.getDO().getCtIds());
        List<BaseinfoCompanyRole> sysCompanyRoles = CompanyRoleFactory.companyRoleBOListToBaseinfoCompanyRoleList(companyRoleBOs,companyModel.getDO().getCompId());
        Integer insertNum = companyRoleService.addRoleListSameCompId(sysCompanyRoles);*/

        CompanyInfoAddRespDTO companyInfoAddRespDTO = new CompanyInfoAddRespDTO();
        companyInfoAddRespDTO.setCompId(companyModel.getDO().getCompId());
        context.getResult().setModule(companyInfoAddRespDTO);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //添加默认门店，同时添加默认仓库
                BaseinfoCompanyStore store = new BaseinfoCompanyStore();
                store.setCompId(companyModel.getDO().getCompId());
                store.setAdminPersonId(companyModel.getDO().getAdminPersonId());
                // 初始化微商铺信息
                store.setWeshopAddress(companyModel.getDO().getCompAddress());
                store.setWeshopProvince(companyModel.getDO().getProvince());
                store.setWeshopCity(companyModel.getDO().getCity());
                store.setWeshopZone(companyModel.getDO().getZone());
                store.setBusinessCategory(companyModel.getDO().getBusinessCategory());
                store.setWeshopContactType(companyModel.getDO().getAdminPersonMobile());
                store.setWeshopManagerId(companyModel.getDO().getAdminPersonId());
                store.setWeshopManagerName(companyModel.getDO().getAdminPersonName());
                Boolean addStroeFlag = companyStoreService.addPublicStoreAndStock(new CompanyStoreModel(store));
                if (!addStroeFlag){
                    throw new CompanyException(StoreErrorCodeEnum.
                            ADD_DEF_STORE_ERROR.getErrCode(),
                            StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
                }

                // 添加默认供应商和客户
                companyPartnerService.addDefaultPartner(companyModel);

                //调用远程rpc
                DefaultInfoGrantReqDTO defaultInfoGrantReqDTO = new DefaultInfoGrantReqDTO();
                defaultInfoGrantReqDTO.setCompanyId(Long.parseLong(companyModel.getDO().getCompId().toString()));
                defaultInfoGrantReqDTO.setCtIds(companyModel.getDO().getBusinessCategory());
                companyBaseInfoGrantService.defaultInfoGrant(defaultInfoGrantReqDTO);
            }
        };
        new Thread(runnable, "ADD_COMPANY_ROLE_GRANT_" + companyModel.getDO().getCompId()).start();
    }

}