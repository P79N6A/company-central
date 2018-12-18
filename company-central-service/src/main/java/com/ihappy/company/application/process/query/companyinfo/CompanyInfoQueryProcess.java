package com.ihappy.company.application.process.query.companyinfo;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.companyinfo.BaseInfoCompanyInfoQueryRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.item.infrastructure.service.SysGoodsCategoryRpcService;
import com.ihappy.store.domain.bo.store.StoreInfoBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/12 10:34
 * *@content管理-公司信息查询
 **/
public class CompanyInfoQueryProcess extends DefaultQueryProcess<CompanyInfoQueryReqDTO, BaseInfoCompanyInfoQueryRespDTO> {
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private SysGoodsCategoryRpcService sysGoodsCategoryRpcService;

    @Override
    public void process(Context<CompanyInfoQueryReqDTO, BaseInfoCompanyInfoQueryRespDTO> context) {
        CompanyInfoQueryReqDTO companyInfoQueryReqDTO = context.getParam();

        //查询公司信息
        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(BaseinfoCompanyFactory.companyInfoQueryReqDTOToCompanyInfoByCompIdQuery(companyInfoQueryReqDTO));
        //判断公司是否存在
        if (companyInfo == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_NOT_EXIT);
        }
        BaseInfoCompanyInfoQueryRespDTO respDTO = BaseinfoCompanyFactory.modelToResp(companyInfo);
        //填充经营类目名称
        respDTO.setBusinessCategoryStr(companyInfoService.getBusinessCategoryStrByIds(respDTO.getBusinessCategory()));

        //通过公司id查询门店名称
        List<BaseinfoCompanyStore> storeNames = companyStoreService.storeNames(BaseinfoCompanyFactory.reqToStoreInfoBO(companyInfoQueryReqDTO));
        String storeName=null;
        List<String> storeNameList =new ArrayList<>();
        for (BaseinfoCompanyStore s : storeNames) {
            //查询单个门店名称
            storeName= s.getStoreName();
            //将门店名称放入List<String>
            storeNameList.add(storeName);
        }
        //将List转换成string，并用逗号分开
        storeName =  listToString(storeNameList,",");
        respDTO.setStoreName(storeName);
        context.getResult().setModule(respDTO);
    }
    //将list转换成string，并分隔
    public static String listToString(List list,String separator){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i)).append(separator);
        }
        return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
    }
}
