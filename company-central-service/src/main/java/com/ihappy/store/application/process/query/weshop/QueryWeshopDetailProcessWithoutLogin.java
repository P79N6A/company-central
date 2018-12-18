package com.ihappy.store.application.process.query.weshop;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.item.domain.dto.request.weshop.WeshopItemGoodsCountReqDTO;
import com.ihappy.item.infrastructure.service.WeshopItemGoodsRpcService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.common.enumtype.weshop.WeshopVisitUidTypeEnum;
import com.ihappy.store.domain.bo.store.CompanyStoreListQueryByStoreIdsReqBo;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.weshop.WeshopDetailQueryReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopDetailQueryRespDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.WeshopCollectionJournalMapper;
import com.ihappy.store.infrastructure.service.WeshopVisitCollectionNumWriteService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by sunjd on 2018/7/4.
 */
public class QueryWeshopDetailProcessWithoutLogin extends DefaultQueryProcess<WeshopDetailQueryReqDTO,WeshopDetailQueryRespDTO> {
    private Logger logger = LoggerFactory.getLogger(QueryWeshopDetailProcess.class);

    @Autowired
    private BaseinfoCompanyStoreMapper companyStoreMapper;

    @Autowired
    private WeshopItemGoodsRpcService weshopItemGoodsRpcServiceClient;

    @Autowired
    private WeshopCollectionJournalMapper weshopCollectionJournalMapper;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private WeshopVisitCollectionNumWriteService weshopVisitCollectionNumWriteService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<WeshopDetailQueryReqDTO, WeshopDetailQueryRespDTO> context) {
        WeshopDetailQueryReqDTO weshopDetailQueryReqDTO = context.getParam();
        CompanyStoreListQueryByStoreIdsReqBo storeListQueryByStoreIdsReqBo = new CompanyStoreListQueryByStoreIdsReqBo();
        Long reqStoreId = weshopDetailQueryReqDTO.getStoreId();
        List<Long> storeIds = new ArrayList<>();
        storeIds.add(reqStoreId);
        storeListQueryByStoreIdsReqBo.setStoreIds(storeIds);

        storeListQueryByStoreIdsReqBo.setLimit(1);
        storeListQueryByStoreIdsReqBo.setOffset(0);
        List<BaseinfoCompanyStore> baseinfoCompanyStores = companyStoreMapper.selectCompanyStoreWeshopByIds(storeListQueryByStoreIdsReqBo);
        WeshopDetailQueryRespDTO weshopDetailQueryRespDTO = model2Resp(baseinfoCompanyStores);
        // 需要查询门店是否有效
        if(null != weshopDetailQueryRespDTO){
            BaseinfoCompanyStore storeInfo = baseinfoCompanyStores.get(0);
            weshopDetailQueryRespDTO.setStoreIsValidate(true);

            // 判断请求来源, 统计访问量
            if(CompanyConstant.INCR_VISIT_FROM.contains(weshopDetailQueryReqDTO.getFrom())){
                WeshopVisitCountAddReqDTO weshopVisitCountAddReqDTO  = new WeshopVisitCountAddReqDTO();
                weshopVisitCountAddReqDTO.setLoginTokenId(weshopDetailQueryReqDTO.getLoginTokenId());
                weshopVisitCountAddReqDTO.setPersonId(weshopDetailQueryReqDTO.getLoginPersonId());
                weshopVisitCountAddReqDTO.setCompId(storeInfo.getCompId().longValue());
                weshopVisitCountAddReqDTO.setStoreId(storeInfo.getStoreId());
                weshopVisitCountAddReqDTO.setUid(weshopDetailQueryReqDTO.getRemoteIp());
                weshopVisitCountAddReqDTO.setUidType(WeshopVisitUidTypeEnum.IP.getKey());
                weshopVisitCollectionNumWriteService.addWeshopVisitCount(weshopVisitCountAddReqDTO);
            }
            try {
                // 查询微商铺商品数量
                WeshopItemGoodsCountReqDTO countReqDTO = new WeshopItemGoodsCountReqDTO();
                countReqDTO.setStoreId(storeInfo.getStoreId());
                countReqDTO.setCompId(storeInfo.getCompId().longValue());
                Result<Integer> itemCountResult = weshopItemGoodsRpcServiceClient.findWeshpItemGoodsCount(countReqDTO);
                int itemCount = itemCountResult.getModule();
                weshopDetailQueryRespDTO.setItemNum(itemCount);
            }catch (Exception e){
                logger.error("query item num error",e);
            }

            WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO = new WeshopVisitDetailListQueryReqDTO();
            weshopVisitDetailListQueryReqDTO.setCompId(weshopDetailQueryReqDTO.getCompId());
            weshopVisitDetailListQueryReqDTO.setStoreId(weshopDetailQueryReqDTO.getStoreId());
            weshopDetailQueryRespDTO.setTotalCollectionCount(getWeshopTotalCollectionCount(weshopVisitDetailListQueryReqDTO));

            context.setResultSuccess(true);
            context.setResultModule(weshopDetailQueryRespDTO);

        }else {
            context.setResultSuccess(false);
            context.setResultErr(StoreErrorCodeEnum.NO_STORE_FIND.getErrCode(), StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
        }
    }

    private WeshopDetailQueryRespDTO model2Resp(List<BaseinfoCompanyStore> baseinfoCompanyStores ){
        WeshopDetailQueryRespDTO weshopDetailQueryRespDTO = new WeshopDetailQueryRespDTO();
        if(CollectionUtil.isEmpty(baseinfoCompanyStores) || baseinfoCompanyStores.size() > 1){
            return null;
        }
        BaseinfoCompanyStore companyStore = baseinfoCompanyStores.get(0);
        weshopDetailQueryRespDTO.setStoreId(companyStore.getStoreId());
        weshopDetailQueryRespDTO.setStoreNo(companyStore.getStoreNo());
        weshopDetailQueryRespDTO.setProvince(companyStore.getProvince());
        weshopDetailQueryRespDTO.setCity(companyStore.getCity());
        weshopDetailQueryRespDTO.setZone(companyStore.getZone());
        weshopDetailQueryRespDTO.setAddress(companyStore.getAddress());
        weshopDetailQueryRespDTO.setCompId(companyStore.getCompId());
        weshopDetailQueryRespDTO.setWeshopName(companyStore.getWeshopName());
        weshopDetailQueryRespDTO.setWeshopLogoImages(companyStore.getWeshopLogoImages());
        weshopDetailQueryRespDTO.setWeshopManagerName(companyStore.getWeshopManagerName());
        weshopDetailQueryRespDTO.setWeshopManagerId(companyStore.getWeshopManagerId());
        weshopDetailQueryRespDTO.setWeshopContactType(companyStore.getWeshopContactType());
        weshopDetailQueryRespDTO.setBusinessCategory(companyStore.getBusinessCategory());
        weshopDetailQueryRespDTO.setBusinessCategoryStr(companyInfoService.getBusinessCategoryStrByIds(companyStore.getBusinessCategory()));
        weshopDetailQueryRespDTO.setWeshopStatus(companyStore.getWeshopStatus());
        weshopDetailQueryRespDTO.setWeshopImages(companyStore.getWeshopImages());
        weshopDetailQueryRespDTO.setWeshopNotice(companyStore.getWeshopNotice());
        weshopDetailQueryRespDTO.setIsOpenWeshopNotice(companyStore.getIsOpenWeshopNotice());
        weshopDetailQueryRespDTO.setWeshopAddress(companyStore.getWeshopAddress());
        weshopDetailQueryRespDTO.setWeshopProvince(companyStore.getWeshopProvince());
        weshopDetailQueryRespDTO.setWeshopCity(companyStore.getWeshopCity());
        weshopDetailQueryRespDTO.setWeshopZone(companyStore.getWeshopZone());
        //默认使用门店地址
        if (StringUtils.isBlank(weshopDetailQueryRespDTO.getWeshopAddress())){
            weshopDetailQueryRespDTO.setWeshopAddress(companyStore.getAddress());
        }
        if (StringUtils.isBlank(weshopDetailQueryRespDTO.getWeshopProvince())){
            weshopDetailQueryRespDTO.setWeshopProvince(companyStore.getProvince());
        }
        if (StringUtils.isBlank(weshopDetailQueryRespDTO.getWeshopCity())){
            weshopDetailQueryRespDTO.setWeshopCity(companyStore.getCity());
        }
        if (StringUtils.isBlank(weshopDetailQueryRespDTO.getWeshopZone())){
            weshopDetailQueryRespDTO.setWeshopZone(companyStore.getZone());
        }
        if (StringUtil.isBlank(companyStore.getWeshopName())){
            weshopDetailQueryRespDTO.setWeshopName(companyStore.getStoreName());
        }else {
            weshopDetailQueryRespDTO.setWeshopName(companyStore.getWeshopName());
        }
        //获取门店联系人信息
        if(companyStore.getAdminPersonId() != null && companyStore.getAdminPersonId() != 0){
            BaseinfoPersonCompanyOrgRespDTO orgRespDTO = SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(companyStore.getCompId(),companyStore.getAdminPersonId(), ConfigCenterUtil.ENV);
            if (orgRespDTO != null){
                weshopDetailQueryRespDTO.setWeshopManagerId(companyStore.getAdminPersonId());
                weshopDetailQueryRespDTO.setWeshopManagerName(orgRespDTO.getPersonName());
                weshopDetailQueryRespDTO.setWeshopContactType(orgRespDTO.getMobile());
            }
        }
        return weshopDetailQueryRespDTO;
    }

    /**
     *    获取店铺今日关注数
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopTotalCollectionCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTotalCollectionCountReq = new HashMap<>();
        weshopTotalCollectionCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTotalCollectionCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long collectedTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        weshopTotalCollectionCountReq.put("collectedTimeFloor", 0l);
        weshopTotalCollectionCountReq.put("collectedTimeUpper", collectedTimeUpper);

        Integer count = weshopCollectionJournalMapper.queryWeshopCollectionCountTimeRange(weshopTotalCollectionCountReq);
        return count;
    }

    /**
     *    获取店铺总收藏数
     * @return
     */
    private Integer getWeshopTotalCollectionCount(Integer compId,Long storeId) {

        Map<String, Object> weshopTotalCollectionCountReq = new HashMap<>();
        weshopTotalCollectionCountReq.put("compId",compId);
        weshopTotalCollectionCountReq.put("storeId",storeId);

        Long collectedTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        weshopTotalCollectionCountReq.put("collectedTimeFloor", 0l);
        weshopTotalCollectionCountReq.put("collectedTimeUpper", collectedTimeUpper);

        Integer count = weshopCollectionJournalMapper.queryWeshopCollectionCountTimeRange(weshopTotalCollectionCountReq);
        return count;
    }
}
