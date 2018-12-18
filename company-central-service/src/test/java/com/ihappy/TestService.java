package com.ihappy;

import com.alibaba.fastjson.JSON;
import com.ihappy.common.domain.Page;
import com.ihappy.company.domain.dto.request.BaseinfoCompanyReqDTO;
import com.ihappy.company.domain.dto.request.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.request.CompanyInfoUpdateReqDTO;
import com.ihappy.company.domain.dto.request.CompanyStatusReqDTO;
import com.ihappy.company.domain.dto.response.BaseinfoCompanyRespDTO;
import com.ihappy.company.infrastructure.service.CompanyReadRpcService;
import com.ihappy.company.infrastructure.service.CompanyWriteRpcService;
import com.ihappy.myredis.MyRedis;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoListQueryReqDTO;
import com.ihappy.partner.infrastructure.service.PartnerReadRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Test;

/**
 * Created by renyueliang on 2018/3/8.
 */
public class TestService extends BaseTest{
    @Test
    public void baseInfoCompanyQuery(){

        CompanyReadRpcService companyRpcService = getBean("ompanyReadRpcService");
        BaseinfoCompanyReqDTO baseinfoCompanyReqDTO = new BaseinfoCompanyReqDTO();
        baseinfoCompanyReqDTO.setStatus(1);
        Result<Page<BaseinfoCompanyRespDTO>> list = companyRpcService.findBaseinfoCompanyPage(baseinfoCompanyReqDTO);

        System.out.println("list --> "+ list.getModule());

    }

    @Test
    public void updateCompanyStatus(){

        CompanyWriteRpcService companyRpcService = getBean("companycWriteRpcService");
        CompanyStatusReqDTO companyStatusReqDTO = new CompanyStatusReqDTO();
        companyStatusReqDTO.setCompId(1);
        companyStatusReqDTO.setStatus(0);
        companyRpcService.updateCompanyStatus(companyStatusReqDTO);
    }

    @Test
    public void selectCompanyInfo(){

        CompanyReadRpcService companyRpcService = getBean("ompanyReadRpcService");
        CompanyInfoQueryReqDTO companyInfoQueryReqDTO = new CompanyInfoQueryReqDTO();
        companyInfoQueryReqDTO.setCompId(1);
        System.out.println(JSON.toJSONString(companyRpcService.findCompanyInfo(companyInfoQueryReqDTO).getModule()));
    }

    @Test
    public void updateCompanyInfo(){

        CompanyWriteRpcService companyRpcService = getBean("companycWriteRpcService");
        CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO = new CompanyInfoUpdateReqDTO();
        companyInfoUpdateReqDTO.setCompId(1);
        companyInfoUpdateReqDTO.setCtIds("1");
        companyInfoUpdateReqDTO.setNature(1);
        companyInfoUpdateReqDTO.setCompShortName("海贝");
        companyInfoUpdateReqDTO.setBusinessCategory("dssdd");
        companyInfoUpdateReqDTO.setCity("杭州");

        System.out.println(JSON.toJSONString(companyRpcService.updateCompanyInfo(companyInfoUpdateReqDTO).getModule()));
    }

    @Test
    public void queryPartner(){

        PartnerReadRpcService partnerRpcService = getBean("partnerReadRpcService");
        ProviderInfoListQueryReqDTO providerInfoListQueryReqDTO = new ProviderInfoListQueryReqDTO();
        providerInfoListQueryReqDTO.setLoginCompId(1L);
        providerInfoListQueryReqDTO.setSearchStr("");
        System.out.println(JSON.toJSONString(partnerRpcService.findProviderList(providerInfoListQueryReqDTO).getModule()));
    }


    @Test
    public void redisTest(){
        MyRedis myRedisClusterForHessian = getBean("myRedisClusterForHessian");
        myRedisClusterForHessian.putForStr("name","renyl love you ! for str ");
        myRedisClusterForHessian.put("name","renyl love you ! for object ");



       String val = myRedisClusterForHessian.getForStr("name");
       System.out.println(val);

        String valobj =  myRedisClusterForHessian.get("name",String.class);
        System.out.println(valobj);
    }
}
