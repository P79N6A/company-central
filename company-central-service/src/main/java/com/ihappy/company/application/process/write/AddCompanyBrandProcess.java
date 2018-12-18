package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyBrand;
import com.ihappy.company.domain.dto.request.CompanyBrandAddReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.company.domain.model.factory.CompanyBrandFactory;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/4/3.
 */
public class AddCompanyBrandProcess extends DefaultProcess<CompanyBrandAddReqDTO, CompanyBrandAddRespDTO> {
    @Autowired
    private BaseinfoCompanyBrandMapper baseinfoCompanyBrandMapper;

    @Override
    public void process(Context<CompanyBrandAddReqDTO, CompanyBrandAddRespDTO> context) {
        CompanyBrandAddReqDTO companyBrandAddReqDTO = context.getParam();
        CompanyBrandModel companyBrandModel = CompanyBrandFactory.companyBrandAddReqDTODTOToModel(companyBrandAddReqDTO);
        //检查品牌名称是否重复
        List<BaseinfoCompanyBrand> baseinfoCompanyBrands = baseinfoCompanyBrandMapper.selectByBrandName(companyBrandModel.getDO());
        if(baseinfoCompanyBrands != null && baseinfoCompanyBrands.size() > 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    BRAND_NAME_REPEAT.getErrCode(),
                    CompanyErrorCodeEnum.BRAND_NAME_REPEAT.getErrMsg());
        }
        //  Mybatis执行完插入语句后，自动将自增长值赋值给传入对象的属性（keyProperty 指定）
        baseinfoCompanyBrandMapper.insertSelective(companyBrandModel.getDO());
        CompanyBrandAddRespDTO companyBrandAddRespDTO = new CompanyBrandAddRespDTO();
        companyBrandAddRespDTO.setBrandId(companyBrandModel.getDO().getBrandId());
        context.getResult().setModule(companyBrandAddRespDTO);
    }
}
