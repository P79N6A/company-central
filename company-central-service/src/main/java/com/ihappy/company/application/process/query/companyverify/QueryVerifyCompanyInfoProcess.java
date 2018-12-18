package com.ihappy.company.application.process.query.companyverify;

import com.google.common.base.Joiner;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.SysGoodsCategory;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReadReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.company.domain.model.factory.VerifyCompanyInfoFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysGoodsCategoryMapper;
import com.ihappy.company.infrastructure.service.inside.VerifyCompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonRespDTO;
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
 * Created by sunjd on 2018/6/6.
 */
public class QueryVerifyCompanyInfoProcess extends DefaultQueryProcess<CompanyInfoVerifyReadReqDTO,CompanyInfoVerifyReadRespDTO> {
    @Autowired
    private VerifyCompanyInfoService verifyCompanyInfoService;

    @Autowired
    private SysGoodsCategoryMapper sysGoodsCategoryMapper;

    @Override
    public void process(Context<CompanyInfoVerifyReadReqDTO, CompanyInfoVerifyReadRespDTO> context) {
        CompanyInfoVerifyReadReqDTO reqDTO = context.getParam();
        BaseinfoCompany param = new BaseinfoCompany();
        param.setCompId(reqDTO.getCompId());
        CompanyModel companyModel = verifyCompanyInfoService.queryVerifyCompanyInfo(new CompanyModel(param));
        CompanyInfoVerifyReadRespDTO respDTO = VerifyCompanyInfoFactory.companyModelToCompanyInfoVerifyReadRespDTO(companyModel);

        //填充经营类目名称
        String businessCategoryIds = respDTO.getBusinessCategory();
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
                    String businessCategoryStr = Joiner.on(",").join(sysGoodsCategoryStrList);
                    respDTO.setBusinessCategoryStr(businessCategoryStr);
                }
            }
        }

        //填充超级管理员账号
        if (respDTO.getAdminPersonId() != null){
            BaseinfoPersonRespDTO baseinfoPersonRespDTO = SysAndPersonRedisUtil.getUserInfoKey(respDTO.getAdminPersonId(), ConfigCenterUtil.ENV);
            if (baseinfoPersonRespDTO != null){
                respDTO.setAdminPersonAccount(baseinfoPersonRespDTO.getPersonLogin());
            }
        }

        context.getResult().setModule(respDTO);
    }
}
