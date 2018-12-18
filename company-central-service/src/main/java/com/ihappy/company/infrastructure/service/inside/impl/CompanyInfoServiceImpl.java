package com.ihappy.company.infrastructure.service.inside.impl;

import com.google.common.base.Joiner;
import com.ihappy.company.domain.bo.BaseinfoCompanyBO;
import com.ihappy.company.domain.bo.CompanyExpireStatusBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.SysCompanyType;
import com.ihappy.company.domain.dbdo.SysGoodsCategory;
import com.ihappy.company.domain.dto.request.AllCompanyInfoPageQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysCompanyTypeMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysGoodsCategoryMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private SysCompanyTypeMapper sysCompanyTypeMapper;
    @Autowired
    private SysGoodsCategoryMapper sysGoodsCategoryMapper;

    @Override
    public List<CompanyModel> queryCompanyInfoListByIds(List<Integer> compIds) {
        List<BaseinfoCompany> baseinfoCompanys = baseinfoCompanyMapper.selectCompanyInfoListByIds(compIds);
        if (CollectionUtils.isEmpty(baseinfoCompanys)) {
            return new ArrayList<>();
        }
        return BaseinfoCompanyFactory.toModelList(baseinfoCompanys);
    }

    @Override
    public int queryAllCompanyCouut() {
        return baseinfoCompanyMapper.selectAllCompanyCount();
    }

    @Override
    public List<CompanyModel> queryCompanyInfoByPage(AllCompanyInfoPageQueryReqDTO allCompanyInfoPageQueryReqDTO) {
        if(allCompanyInfoPageQueryReqDTO.getOffset() == null || allCompanyInfoPageQueryReqDTO.getLimit() == null){
            return new ArrayList<>();
        }
        List<BaseinfoCompany> baseinfoCompanys = baseinfoCompanyMapper.selectCompanyInfoByPage(allCompanyInfoPageQueryReqDTO);
        return BaseinfoCompanyFactory.toModelList(baseinfoCompanys);
    }

    @Override
    public Map<String, CompanyModel> getCompNameById(List<Integer> compIds) {
        Map<String, CompanyModel> map = new HashMap<>();
        List<CompanyModel> result = queryCompanyInfoListByIds(compIds);
        for(CompanyModel model : result){
            map.put(model.getCompId()+"",model);
        }
        return map;
    }

    @Override
    public String getCtNamesByCtIds(String ctIds) {
        String ctNames = null;
        if (!StringUtils.isEmpty(ctIds)){
            java.util.List<String> ctIdsList = java.util.Arrays.asList(ctIds.split(","));
            if (!CollectionUtils.isEmpty(ctIdsList)){
                List<Integer> ctIdsIntList = new ArrayList<Integer>();
                for(String obj : ctIdsList){
                    if (StringUtil.isNumeric(obj) && !obj.equals("")){
                        ctIdsIntList.add(Integer.valueOf(obj));
                    }
                }
                if (ctIdsIntList.size() > 0){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("ctIdsIntList",ctIdsIntList);
                    List<SysCompanyType> sysCompanyTypeList = sysCompanyTypeMapper.selectList(map);
                    List<String> ctIdsStrList = transform(sysCompanyTypeList,(obj) -> obj.getCtName());
                    ctNames = Joiner.on(",").join(ctIdsStrList);
                }
            }
        }
        return ctNames;
    }

    @Override
    public String getBusinessCategoryStrByIds(String businessCategoryIds) {
        String businessCategoryStr = null;
        if (!StringUtils.isEmpty(businessCategoryIds)){
            java.util.List<String> businessCategoryIdsList = java.util.Arrays.asList(businessCategoryIds.split(","));
            if (!CollectionUtils.isEmpty(businessCategoryIdsList)){
                List<Long> businessCategoryIdsIntList = new ArrayList<Long>();
                for(String obj : businessCategoryIdsList){
                    if (StringUtil.isNumeric(obj) && !obj.equals("")){
                        businessCategoryIdsIntList.add(Long.valueOf(obj));
                    }
                }
                if (businessCategoryIdsIntList.size() > 0){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("businessCategoryIdsIntList",businessCategoryIdsIntList);
                    List<SysGoodsCategory> sysGoodsCategoryList = sysGoodsCategoryMapper.selectList(map);
                    List<String> sysGoodsCategoryStrList = transform(sysGoodsCategoryList,(obj) -> obj.getGcName());
                    businessCategoryStr = Joiner.on(",").join(sysGoodsCategoryStrList);
                }
            }
        }
        return businessCategoryStr;
    }

    @Override
    public CompanyModel selectCompanyInfo(CompanyInfoByCompIdQuery companyInfoByCompIdQuery) {
        BaseinfoCompany baseinfoCompany = new BaseinfoCompany();
        baseinfoCompany.setCompId(companyInfoByCompIdQuery.getCompId());
        BaseinfoCompany result = baseinfoCompanyMapper.selectCompanyInfo(baseinfoCompany);
       if (result == null){
           return null;
       }
        return new CompanyModel(result);
    }

    @Override
    public CompanyModel selectCompanyInfoByCompIdAndCtIds(BaseinfoCompanyBO baseinfoCompanyBO) {
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectCompanyInfoByCompIdAndCtIds(baseinfoCompanyBO);
        return new CompanyModel(baseinfoCompany);
    }


    @Override
    public int updateCompanyExpireStatus(CompanyExpireStatusBO companyExpireStatusBO) {
        return baseinfoCompanyMapper.updateCompanyExpireStatus(companyExpireStatusBO);
    }

    @Override
    public int updateFactoryInfo(CompanyModel companyModel) {

        companyModel.factoryInfoPutRedis();

        return baseinfoCompanyMapper.updateCompanyInfoAttributes(companyModel.getBaseinfoCompany());
    }


}
