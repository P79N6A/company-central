package com.ihappy.store.application.process.query.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.CompanyWhiteBlackEnum;
import com.ihappy.company.common.enumtype.ExpireStatusEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.store.domain.bo.store.CheckCompanyStoreUsingBO;
import com.ihappy.store.domain.dto.request.store.StoreListQueryReqDTO;
import com.ihappy.store.domain.dto.response.store.StoreListQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import com.ihappy.user.domain.dto.response.person.StoreInfoRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhangmengdan
 * @Date: 2018/9/12 13:50
 * @Version
 */
public class QueryStoreListProcess extends DefaultQueryProcess<StoreListQueryReqDTO, List<StoreListQueryRespDTO>> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<StoreListQueryReqDTO, List<StoreListQueryRespDTO>> context) {
        StoreListQueryReqDTO storeListQueryReqDTO = context.getParam();
        final long compId = storeListQueryReqDTO.getLoginCompId();
        final long personId = storeListQueryReqDTO.getLoginPersonId();
        //查询公司基本信息
        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(CompanyStoreFactory.storeListQueryReqDTOToCompanyInfoByCompIdQuery(storeListQueryReqDTO));
        if (companyInfo == null) {//判断公司是否存在
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_EMPTY);
        }
        //通过redis获取用户信息，通过公司id和登录人
        BaseinfoPersonCompanyOrgRespDTO userinfo =
                SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(compId, personId, ConfigCenterUtil.ENV);
        if (userinfo == null) {//判断用户是否存在
            throw new CompanyException(CompanyErrorCodeEnum.
                    GET_USER_INFO_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.GET_USER_INFO_ERROR.getErrMsg());
        }

        Map map = new HashMap();
        map.put("compId", compId);
        if (!storeListQueryReqDTO.getLoginPersonId().equals(companyInfo.getAdminPersonId())) {
            List<StoreInfoRespDTO> storeInfoRespDTOList = userinfo.getStoreInfoList();  //通过用户信息获取门店列表
            if (storeInfoRespDTOList != null && storeInfoRespDTOList.size() > 0) {
                List<Long> storeIdsList = storeInfoRespDTOList.stream().map(x -> x.getStoreId()).collect(Collectors.toList());
                map.put("storeIds", storeIdsList);

            }
        }
        List<CompanyStoreModel>  companyStoreModelList = companyStoreService.findStoreListByCompIdAndStoreIds(map);//通过公司id和门店id查询门店列表

        if (CollectionUtils.isEmpty(companyStoreModelList)) {
            context.getResult().setModule(new ArrayList());
            return;
        }
        List<StoreListQueryRespDTO> result = companyStoreModelList.stream().map(CompanyStoreFactory::modelListToStoreListQueryRespDTOList).collect(Collectors.toList());
        final BaseinfoCompany baseinfoCompany = companyInfo.getDO();
        result.stream().forEach(x -> {
                // case 1: 以下情况，满足其中一种，则storeStatus == 1(使用中）
                //              1.1 若在试用期之内（nowTime - createdAt < 15)，
//                              1.2 若门店已付费（expireStatus == 1） 且当前时间未超过过期时间（expireDate）
//                              1.3 公司 status = 2（白名单)
                // case 2: 其他情况为则storeStatus = 0 （待续费 ）
            CheckCompanyStoreUsingBO checkCompanyStoreUsingBO = new CheckCompanyStoreUsingBO();
            checkCompanyStoreUsingBO.setCreatedAt(x.getCreateAt());
            checkCompanyStoreUsingBO.setExpireDateLong(x.getExpireDate());
            checkCompanyStoreUsingBO.setExpireStatusEnum(ExpireStatusEnum.getTbcpNatureEnum(x.getExpireStatus()));
            checkCompanyStoreUsingBO.setCompanyWhiteBlackEnum(CompanyWhiteBlackEnum.getCompanyStatusEnum(baseinfoCompany.getStatus()));
            x.setStoreStatus(companyStoreService.isCompanyStoreUsing(checkCompanyStoreUsingBO) ? 1 : 0);
        });
        context.getResult().setModule(result);
    }
}
