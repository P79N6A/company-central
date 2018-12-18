package com.ihappy.company.application.process.write;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyBrand;
import com.ihappy.company.domain.dto.request.CompanyBrandAddInsideReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.model.factory.CompanyBrandFactory;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/5/9.
 */
public class AddCompanyBrandInsideProcess extends DefaultProcess<CompanyBrandAddInsideReqDTO, CompanyBrandAddInsideRespDTO> {
    @Autowired
    private BaseinfoCompanyBrandMapper baseinfoCompanyBrandMapper;
    @Override
    public void process(Context<CompanyBrandAddInsideReqDTO, CompanyBrandAddInsideRespDTO> context) {
        CompanyBrandAddInsideReqDTO reqDTO = context.getParam();
        CompanyBrandAddInsideRespDTO respDTO = new CompanyBrandAddInsideRespDTO();
        CompanyBrandModel companyBrandModel = CompanyBrandFactory.companyBrandAddInsideReqDTODTOToModel(reqDTO);
        //检查品牌名称是否重复
        List<BaseinfoCompanyBrand> baseinfoCompanyBrands = baseinfoCompanyBrandMapper.selectByBrandName(companyBrandModel.getDO());
        if(baseinfoCompanyBrands != null && baseinfoCompanyBrands.size() > 0){
            respDTO.setBrandId(baseinfoCompanyBrands.get(0).getBrandId());
            respDTO.setExist(true);
            context.getResult().setModule(respDTO);
            return;
        }
        //  Mybatis执行完插入语句后，自动将自增长值赋值给传入对象的属性（keyProperty 指定）
        baseinfoCompanyBrandMapper.insertSelective(companyBrandModel.getDO());
        respDTO.setBrandId(companyBrandModel.getDO().getBrandId());
        respDTO.setExist(false);
        context.getResult().setModule(respDTO);
    }
}
