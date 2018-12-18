package com.ihappy.store.application.process.query.weshop;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.store.CompanyStoreListQueryByStoreIdsReqBo;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitDetailListQueryReqDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopIndexDetailQueryRespDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.WeshopCollectionJournalMapper;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.WeshopVisitJournalMapper;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * @program: company-central
 * @description: 商铺访问信息查询
 * @author: 汪正
 * @create: 2018-05-18 18:07
 **/
public class QueryWeshopVisitDetailListProcess extends DefaultQueryProcess<WeshopVisitDetailListQueryReqDTO, WeshopIndexDetailQueryRespDTO> {

    @Autowired
    private WeshopVisitJournalMapper weshopVisitJournalMapper;

    @Autowired
    private WeshopCollectionJournalMapper weshopCollectionJournalMapper;

    @Autowired
    private BaseinfoCompanyStoreMapper companyStoreMapper;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public void process(Context<WeshopVisitDetailListQueryReqDTO, WeshopIndexDetailQueryRespDTO> context) {
        WeshopVisitDetailListQueryReqDTO weshopVisitDetailListQueryReqDTO = context.getParam();

        CompanyStoreListQueryByStoreIdsReqBo storeListQueryByStoreIdsReqBo = new CompanyStoreListQueryByStoreIdsReqBo();
        Long reqStoreId = weshopVisitDetailListQueryReqDTO.getStoreId();
        List<Long> storeIds = new ArrayList<>();
        storeIds.add(reqStoreId);
        storeListQueryByStoreIdsReqBo.setStoreIds(storeIds);

        storeListQueryByStoreIdsReqBo.setLimit(1);
        storeListQueryByStoreIdsReqBo.setOffset(0);

        //storeListQueryByStoreIdsReqBo.setWeshopStatus(WeshopStatusEnum.ONLINE.getKey());
        List<BaseinfoCompanyStore> baseinfoCompanyStores = companyStoreMapper.selectCompanyStoreWeshopByIds(storeListQueryByStoreIdsReqBo);

        if (!CollectionUtil.isEmpty(baseinfoCompanyStores)) {
            // 判断是否需要初始化微商铺信息
            BaseinfoCompanyStore storeInfo = baseinfoCompanyStores.get(0);
            if(Integer.valueOf(0).equals(storeInfo.getIsHasWeshop())){
                // 初始化微商铺信息
                storeInfo = initWeshopInfo(storeInfo);
            }
            WeshopIndexDetailQueryRespDTO weshopIndexDetailQueryRespDTO = new WeshopIndexDetailQueryRespDTO();
            weshopIndexDetailQueryRespDTO.setStoreId(storeInfo.getStoreId());
            weshopIndexDetailQueryRespDTO.setStoreName(storeInfo.getStoreName());
            weshopIndexDetailQueryRespDTO.setCompId(storeInfo.getCompId());
            weshopIndexDetailQueryRespDTO.setWeshopName(storeInfo.getWeshopName());
            weshopIndexDetailQueryRespDTO.setWeshopLogoImages(storeInfo.getWeshopLogoImages());
            weshopIndexDetailQueryRespDTO.setWeshopImages(storeInfo.getWeshopImages());
            weshopIndexDetailQueryRespDTO.setWeshopNotice(storeInfo.getWeshopNotice());
            weshopIndexDetailQueryRespDTO.setIsOpenWeshopNotice(storeInfo.getIsOpenWeshopNotice());
            weshopIndexDetailQueryRespDTO.setStoreIsValidate(true);
            weshopIndexDetailQueryRespDTO.setTodayVisitCount(getWeshopTodayVisitCount(weshopVisitDetailListQueryReqDTO));
            weshopIndexDetailQueryRespDTO.setTodayVisitUserCount(getWeshopTodayVisitUserCount(weshopVisitDetailListQueryReqDTO));
            weshopIndexDetailQueryRespDTO.setTotalVisitCount(getWeshopVisitCount(weshopVisitDetailListQueryReqDTO));
            weshopIndexDetailQueryRespDTO.setTotalVisitUserCount(getWeshopVisitUserCount(weshopVisitDetailListQueryReqDTO));
            weshopIndexDetailQueryRespDTO.setTotalCollectionCount(getWeshopTotalCollectionCount(weshopVisitDetailListQueryReqDTO));
            weshopIndexDetailQueryRespDTO.setTodayCollectionCount(getWeshopTodayCollectionCount(weshopVisitDetailListQueryReqDTO));

            context.setResultSuccess(true);
            context.getResult().setModule(weshopIndexDetailQueryRespDTO);
        }else {
            context.setResultSuccess(false);
            context.setResultErr(StoreErrorCodeEnum.NO_STORE_FIND.getErrCode(), StoreErrorCodeEnum.NO_STORE_FIND.getErrMsg());
        }

    }

    private BaseinfoCompanyStore initWeshopInfo(BaseinfoCompanyStore storeInfo) {
        BaseinfoCompany companyInfo = baseinfoCompanyMapper.selectByPrimaryKey(storeInfo.getCompId());
        storeInfo.setBusinessCategory(companyInfo.getBusinessCategory());
        if(Integer.valueOf(1).equals(storeInfo.getIsDefault())){
            storeInfo.setWeshopName(CompanyConstant.DEFAULT_STORE_NAME);
        }else{
            storeInfo.setWeshopName(storeInfo.getStoreName());
        }

        storeInfo.setIsHasWeshop(1);
        storeInfo.setWeshopStatus(2);
        // 省
        if(StringUtil.isNotBlank(storeInfo.getProvince())){
            storeInfo.setWeshopProvince(storeInfo.getProvince());
        }else{
            storeInfo.setWeshopProvince(companyInfo.getProvince());
        }
        // 市
        if(StringUtil.isNotBlank(storeInfo.getCity())){
            storeInfo.setWeshopCity(storeInfo.getCity());
        }else{
            storeInfo.setWeshopCity(companyInfo.getCity());
        }
        // 区
        if(StringUtil.isNotBlank(storeInfo.getZone())){
            storeInfo.setWeshopZone(storeInfo.getZone());
        }else{
            storeInfo.setWeshopZone(companyInfo.getZone());
        }
        // 地址
        if(StringUtil.isNotBlank(storeInfo.getAddress())){
            storeInfo.setWeshopAddress(storeInfo.getAddress());
        }else{
            storeInfo.setWeshopAddress(companyInfo.getCompAddress());
        }
        // 管理员
        if(StringUtil.isNotBlank(storeInfo.getStoreContact())){
            storeInfo.setWeshopManagerName(storeInfo.getStoreContact());
        }else{
            storeInfo.setWeshopManagerName(companyInfo.getCompLinkman());
        }
        // 联系方式
        if(StringUtil.isNotBlank(storeInfo.getStorePhone())){
            storeInfo.setWeshopContactType(storeInfo.getStorePhone());
        }else{
            storeInfo.setWeshopContactType(companyInfo.getCompLinkmanTel());
        }
        // 更新数据库
        companyStoreMapper.updateByPrimaryKeySelective(storeInfo);
        // 更新返回值
        return storeInfo;
    }

    /**
     *   获取今日访问量
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopTodayVisitCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTodayVisitCountReq = new HashMap<>();
        weshopTodayVisitCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTodayVisitCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long visitTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long visitTimeFloor = CompanyDateUtil.getDate14Long(calendar.getTime());

        weshopTodayVisitCountReq.put("visitTimeUpper", visitTimeUpper);
        weshopTodayVisitCountReq.put("visitTimeFloor", visitTimeFloor);

        Integer count = weshopVisitJournalMapper.queryWeshopVisitCountTimeRange(weshopTodayVisitCountReq);
        return count;
    }

    /**
     *  获取累计访问量
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopVisitCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTotalVisitCountReq = new HashMap<>();
        weshopTotalVisitCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTotalVisitCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long visitTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        weshopTotalVisitCountReq.put("visitTimeUpper", visitTimeUpper);
        weshopTotalVisitCountReq.put("visitTimeFloor", 0l);

        Integer count = weshopVisitJournalMapper.queryWeshopVisitCountTimeRange(weshopTotalVisitCountReq);
        return count;
    }

    /**
     *    获取累计访问用户数量
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopVisitUserCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTotalVisitUserCountReq = new HashMap<>();
        weshopTotalVisitUserCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTotalVisitUserCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long visitTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        weshopTotalVisitUserCountReq.put("visitTimeUpper", visitTimeUpper);
        weshopTotalVisitUserCountReq.put("visitTimeFloor", 0l);

        Integer count = weshopVisitJournalMapper.queryWeshopVisitUserCountTimeRange(weshopTotalVisitUserCountReq);
        return count;
    }

    /**
     *      获取店铺今日访问用户数
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopTodayVisitUserCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTodayVisitUserCountReq = new HashMap<>();
        weshopTodayVisitUserCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTodayVisitUserCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long visitTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long visitTimeFloor = CompanyDateUtil.getDate14Long(calendar.getTime());

        weshopTodayVisitUserCountReq.put("visitTimeUpper", visitTimeUpper);
        weshopTodayVisitUserCountReq.put("visitTimeFloor", visitTimeFloor);

        Integer count = weshopVisitJournalMapper.queryWeshopVisitUserCountTimeRange(weshopTodayVisitUserCountReq);
        return count;
    }
    /**
     *    获取店铺今日关注数
     * @param visitDetailListQueryReqDTO
     * @return
     */
    private Integer getWeshopTodayCollectionCount(WeshopVisitDetailListQueryReqDTO visitDetailListQueryReqDTO) {

        Map<String, Object> weshopTodayCollectionCountReq = new HashMap<>();
        weshopTodayCollectionCountReq.put("compId", visitDetailListQueryReqDTO.getCompId());
        weshopTodayCollectionCountReq.put("storeId", visitDetailListQueryReqDTO.getStoreId());

        Long collectedTimeUpper = CompanyDateUtil.getDate14Long(new Date());

        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long collectedTimeFloor = CompanyDateUtil.getDate14Long(calendar.getTime());

        weshopTodayCollectionCountReq.put("collectedTimeFloor", collectedTimeFloor);
        weshopTodayCollectionCountReq.put("collectedTimeUpper", collectedTimeUpper);

        Integer count = weshopCollectionJournalMapper.queryWeshopCollectionCountTimeRange(weshopTodayCollectionCountReq);
        return count;
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

}
