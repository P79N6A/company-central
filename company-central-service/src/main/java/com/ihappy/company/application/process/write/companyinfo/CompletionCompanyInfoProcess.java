package com.ihappy.company.application.process.write.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.service.outside.CompanyBaseInfoGrantService;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyCompletionInfoReqDTO;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.item.common.util.ToolConver;
import com.ihappy.item.domain.dto.request.DefaultInfoGrantReqDTO;
import com.yx.eweb.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sunjd on 2018/6/25.
 */
public class CompletionCompanyInfoProcess extends DefaultProcess<CompanyCompletionInfoReqDTO, String> {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;
    @Autowired
    private CompanyBaseInfoGrantService companyBaseInfoGrantService;

    @Override
    public void process(Context<CompanyCompletionInfoReqDTO, String> context) {
        CompanyCompletionInfoReqDTO reqDTO = context.getParam();
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(reqDTO.getCompId());
        String businessCategory = company.getBusinessCategory();
        List<Integer> businessCategoryList = new ArrayList<>();
        List<Integer> newBusinessCategoryList = new ArrayList<>();
        if (!StringUtil.isBlank(businessCategory)){
            businessCategoryList = ToolConver.stringParseInteger(businessCategory);
        }
        if (!StringUtil.isBlank(reqDTO.getBusinessCategory())){
            newBusinessCategoryList = ToolConver.stringParseInteger(reqDTO.getBusinessCategory());
            businessCategoryList.addAll(newBusinessCategoryList);
        }
        Set<Integer> businessCategorySet = new HashSet<Integer>();
        for (Integer obj : businessCategoryList){
            businessCategorySet.add(obj);
        }
        String businessCategoryStr = StringUtils.join(businessCategorySet, ",");
        BaseinfoCompany updateBaseinfoCompany = new BaseinfoCompany();
        updateBaseinfoCompany.setCompId(reqDTO.getCompId());
        updateBaseinfoCompany.setBusinessCategory(businessCategoryStr);
        baseinfoCompanyMapper.updateByPrimaryKeySelective(updateBaseinfoCompany);

        if(!CollectionUtils.isEmpty(newBusinessCategoryList)){
            businessCategoryStr = StringUtils.join(newBusinessCategoryList, ",");
        }

        DefaultInfoGrantReqDTO defaultInfoGrantReqDTO = new DefaultInfoGrantReqDTO();
        defaultInfoGrantReqDTO.setCompanyId(Long.parseLong(reqDTO.getCompId().toString()));
        defaultInfoGrantReqDTO.setCtIds(businessCategoryStr);
        defaultInfoGrantReqDTO.setFlag(1);
        companyBaseInfoGrantService.defaultInfoGrant(defaultInfoGrantReqDTO);
        context.getResult().setModule("成功!");
    }
}
