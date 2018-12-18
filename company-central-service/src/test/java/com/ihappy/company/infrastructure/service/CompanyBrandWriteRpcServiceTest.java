package com.ihappy.company.infrastructure.service;

import com.alibaba.fastjson.JSON;
import com.ihappy.BaseTest;
import com.ihappy.company.domain.dto.request.CompanyBrandAddInsideReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandAddReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandDelReqDTO;
import com.ihappy.company.domain.dto.request.CompanyBrandsDelReqDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddInsideRespDTO;
import com.ihappy.company.domain.dto.response.CompanyBrandAddRespDTO;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

import java.util.Date;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyBrandWriteRpcServiceTest extends BaseTest {
    @Test
    public void addCompanyBrandInside() throws Exception {
        CompanyBrandWriteRpcService companyBrandWriteRpcService = getBean("companyBrandWriteRpcService");
        CompanyBrandAddInsideReqDTO reqDTO = new CompanyBrandAddInsideReqDTO();
        reqDTO.setBrandLicense("品牌注册商标号");
        reqDTO.setBrandName("公司品牌");
        reqDTO.setCompId(1L);

        Result<CompanyBrandAddInsideRespDTO> res = companyBrandWriteRpcService.addCompanyBrandInside(reqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * @throws Exception
     */
    @Test
    public void addCompanyBrand() throws Exception {
        CompanyBrandWriteRpcService companyBrandWriteRpcService = getBean("companyBrandWriteRpcService");
        CompanyBrandAddReqDTO companyBrandAddReqDTO = new CompanyBrandAddReqDTO();
        companyBrandAddReqDTO.setBrandLicense("品牌注册商标号");
        companyBrandAddReqDTO.setBrandLicensePicurl("品牌证书照片");
        companyBrandAddReqDTO.setBrandMemo("品牌介绍");
        companyBrandAddReqDTO.setBrandName("公司名称");
        companyBrandAddReqDTO.setCompId(1);
        companyBrandAddReqDTO.setCreatedPersonId(1);
        companyBrandAddReqDTO.setBrandSort(1);
        companyBrandAddReqDTO.setBrandPicurl("品牌图标");
        PersonUserInfoDTO personUserInfoDTO =new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(2L);
        companyBrandAddReqDTO.setIsPerson(true);
        companyBrandAddReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<CompanyBrandAddRespDTO> res = companyBrandWriteRpcService.addCompanyBrand(companyBrandAddReqDTO);

        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    /**
     * 单元测试通过
     * 注入personUserInfoDTO失败
     * @throws Exception
     */
    @Test
    public void delCompanyBrand() throws Exception {
        CompanyBrandWriteRpcService companyBrandWriteRpcService = getBean("companyBrandWriteRpcService");
        CompanyBrandDelReqDTO companyBrandDelReqDTO = new CompanyBrandDelReqDTO();
        companyBrandDelReqDTO.setBrandId(10);
        companyBrandDelReqDTO.setUpdateTime(new Date());
        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        companyBrandDelReqDTO.setIsPerson(true);
        companyBrandDelReqDTO.setPersonUserInfoDTO(personUserInfoDTO);
        Result<String> res = companyBrandWriteRpcService.delCompanyBrand(companyBrandDelReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }

    @Test
    public void delCompanyBrands() throws Exception {
        CompanyBrandWriteRpcService companyBrandWriteRpcService = getBean("companyBrandWriteRpcService");
        CompanyBrandsDelReqDTO companyBrandsDelReqDTO = new CompanyBrandsDelReqDTO();
        companyBrandsDelReqDTO.setBrandIds("1,2,3,4,5,6,7");
        companyBrandsDelReqDTO.setBrandIds("");
        companyBrandsDelReqDTO.setUpdateTime(new Date());

        PersonUserInfoDTO personUserInfoDTO = new PersonUserInfoDTO();
        personUserInfoDTO.setPersonId(1L);
        personUserInfoDTO.setCompId(104L);
        companyBrandsDelReqDTO.setIsPerson(true);
        companyBrandsDelReqDTO.setPersonUserInfoDTO(personUserInfoDTO);

        Result<String> res = companyBrandWriteRpcService.delCompanyBrands(companyBrandsDelReqDTO);
        System.out.println(JSON.toJSONString(res.getModule()));
        System.out.println(JSON.toJSONString(res.isSuccess()));
        System.out.println(JSON.toJSONString(res.getErrCode()));
        System.out.println(JSON.toJSONString(res.getErrMsg()));
    }
}