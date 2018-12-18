package com.ihappy.partner.infrastructure.service.inside.impl;

import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.bo.level.CheckPartnerLevelBOByName;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartnerLevel;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;
import com.ihappy.partner.infrastructure.repo.mybatis.mapper.BaseinfoCompanyPartnerLevelMapper;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.partner.infrastructure.service.inside.PartnerLevelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/5/2.
 */
public class PartnerLevelServiceImpl implements PartnerLevelService {
    @Autowired
    private BaseinfoCompanyPartnerLevelMapper baseinfoCompanyPartnerLevelMapper;
    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Override
    public List<PartnerLevelModel> selectByCondition(PartnerLevelModel model) {
        if (model == null || model.getDO() == null){
            throw new CompanyException(CompanyErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        if (model.getDO().getCompId() == null){
            throw new CompanyException(PartnerErrorCodeEnum.PARTNER_LEVEL_ID_IS_NULL);
        }
        List<BaseinfoCompanyPartnerLevel> objs = baseinfoCompanyPartnerLevelMapper.selectByCondition(model.getDO());
        List<PartnerLevelModel> models = new ArrayList<PartnerLevelModel>();
        for (BaseinfoCompanyPartnerLevel obj : objs){
            models.add(new PartnerLevelModel(obj));
        }
        return models;
    }

    @Override
    public List<PartnerLevelModel> checkPartnerLevelName(CheckPartnerLevelBOByName checkPartnerLevelBOByName) {
        List<BaseinfoCompanyPartnerLevel> objs = baseinfoCompanyPartnerLevelMapper.checkPartnerLevelName(checkPartnerLevelBOByName);
        List<PartnerLevelModel> models = new ArrayList<PartnerLevelModel>();
        for (BaseinfoCompanyPartnerLevel obj : objs){
            models.add(new PartnerLevelModel(obj));
        }
        return models;
    }

    @Override
    public Long addPartnerLevel(PartnerLevelModel model) {
        Long partnerLevelId = DistributedPrimaryKeyFactory.generatePartnerLevelId(model.getDO().getCompId());
        model.getDO().setPartnerLevelId(partnerLevelId);
        Integer res = baseinfoCompanyPartnerLevelMapper.insertSelective(model.getDO());
        if(res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.ADD_PARTNER_LEVEL_ERROR);
        }
        return partnerLevelId;
    }

    @Override
    public Integer updatePartnerLevel(PartnerLevelModel model) {
        return baseinfoCompanyPartnerLevelMapper.updateByPrimaryKeySelective(model.getDO());
    }

    @Override
    public Integer delPartnerLevel(PartnerLevelModel model) {
        //查看引用计数
        BaseinfoCompanyPartnerLevel old = baseinfoCompanyPartnerLevelMapper.selectByPrimaryKey(model.getDO().getPartnerLevelId());
        if (old.getReferenceCount() > 0){
            throw new CompanyException(PartnerErrorCodeEnum.PARTNER_LEVEL_IS_USED);
        }
        if (old.getIsDefault() == 1){
            throw new CompanyException(PartnerErrorCodeEnum.PARTNER_LEVEL_IS_DEFAULT);
        }
        //查看是否被Partner使用
        Integer partnerCount = companyPartnerService.queryCountByPartnerLevelId(model.getDO().getPartnerLevelId());
        if (partnerCount != null && partnerCount > 0){
            throw new CompanyException(PartnerErrorCodeEnum.
                    PARTNER_LEVEL_IS_USED.getErrCode(),
                    PartnerErrorCodeEnum.PARTNER_LEVEL_IS_USED.getErrMsg());
        }
        Integer res = baseinfoCompanyPartnerLevelMapper.updateDelStatus(model.getDO());
        if (res != 1){
            throw new CompanyException(PartnerErrorCodeEnum.DEL_PARTNER_LEVEL_ERROR);
        }
        return res;
    }

    @Override
    public PartnerLevelModel selectById(PartnerLevelModel model) {
        BaseinfoCompanyPartnerLevel res = baseinfoCompanyPartnerLevelMapper.selectById(model.getDO());
        if (res == null){
            return new PartnerLevelModel();
        }
        return new PartnerLevelModel(res);
    }

    @Override
    public List<PartnerLevelModel> selectPartnerLevelList(PartnerLevelModel model) {
        List<BaseinfoCompanyPartnerLevel> res = baseinfoCompanyPartnerLevelMapper.selectPartnerLevelList(model.getDO());
        return transform(res,(obj) -> new PartnerLevelModel(obj));
    }

    @Override
    public Integer updateReferenceCount(Map<String, Object> paramMap) {
        if (paramMap.get("partnerLevelIds") == null){
            return 0;
        }
        return baseinfoCompanyPartnerLevelMapper.updateReferenceCount(paramMap);
    }

    @Override
    public Long addDefaultPartnerLevel(Integer compId) {
        BaseinfoCompanyPartnerLevel baseinfoCompanyPartnerLevel = new BaseinfoCompanyPartnerLevel();
        baseinfoCompanyPartnerLevel.setCompId(compId);
        baseinfoCompanyPartnerLevel.setPartnerLevel(OptConstans.DEF_PARTNER_LEVEL_NAME);
        baseinfoCompanyPartnerLevel.setDiscount(OptConstans.DEF_PARTNER_LEVEL_DISCOUNT);
        PartnerLevelModel partnerLevelModel = new PartnerLevelModel(baseinfoCompanyPartnerLevel);
        Long partnerLevelId = addPartnerLevel(partnerLevelModel);
        return partnerLevelId;
    }


}
