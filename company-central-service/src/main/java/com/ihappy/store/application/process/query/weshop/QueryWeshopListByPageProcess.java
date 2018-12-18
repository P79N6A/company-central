package com.ihappy.store.application.process.query.weshop;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.domain.dto.request.user.PersonGestureReqDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.PersonWeshopCollectionPurchaseMapper;
import com.ihappy.store.domain.bo.store.CompanyStoreListQueryByStoreIdsReqBo;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dbdo.weshop.PersonWeshopCollectionPurchase;
import com.ihappy.store.domain.dto.request.weshop.WeshopListQueryReqDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopListQueryRespDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.store.BaseinfoCompanyStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-11 14:56
 */
public class QueryWeshopListByPageProcess extends DefaultQueryProcess<WeshopListQueryReqDTO,List<WeshopListQueryRespDTO>> {
    @Autowired
    private BaseinfoCompanyStoreMapper companyStoreMapper;

    @Autowired
    private PersonWeshopCollectionPurchaseMapper collectionPurchaseMapper;

    @Override
    public void process(Context<WeshopListQueryReqDTO, List<WeshopListQueryRespDTO>> context) {
        WeshopListQueryReqDTO weshopListQueryReqDTO = context.getParam();

        List<BaseinfoCompanyStore> baseinfoCompanyStores = null;
        List<Long> storesIds;

        //默认全部0  已购 1   收藏 2
        Integer weshopType = weshopListQueryReqDTO.getWeshopType();
        PersonGestureReqDTO personGestureReqDTO = getPersonCollectionReq(weshopListQueryReqDTO);
        Set<Long> collectedWeshopId = new HashSet<>();
        // 收藏或已购商铺
        if(null != weshopType && (weshopType == 1 || weshopType == 2)){
            List<PersonWeshopCollectionPurchase> weshopCollectionPurchases = collectionPurchaseMapper.selectPersonGestureList(personGestureReqDTO);
            storesIds = getCompanyStoresId(weshopCollectionPurchases);
            collectedWeshopId.addAll(storesIds);
            if(storesIds != null && storesIds.size()>0){
                CompanyStoreListQueryByStoreIdsReqBo storeListQueryByStoreIdsReqBo = new CompanyStoreListQueryByStoreIdsReqBo();
                storeListQueryByStoreIdsReqBo.setStoreIds(storesIds);
                // 收藏或已购的商铺即使没上线也在列表中展示出来,
                //storeListQueryByStoreIdsReqBo.setWeshopStatus(1);
                baseinfoCompanyStores = companyStoreMapper.selectCompanyStoreWeshopByIds(storeListQueryByStoreIdsReqBo);
            }
        }else {  // 全部商铺
            // 因为查询所有商铺, 每页有一些商铺是已收藏的有些是未收藏的, 所以无法判断当前页对应的收藏limit和offset是多少, 故查询所有
            personGestureReqDTO.setLimit(null);
            personGestureReqDTO.setOffset(null);
            personGestureReqDTO.setIsCollected(1);

            List<PersonWeshopCollectionPurchase> weshopCollectionPurchases = collectionPurchaseMapper.selectPersonGestureList(personGestureReqDTO);
            storesIds = getCompanyStoresId(weshopCollectionPurchases);
            collectedWeshopId.addAll(storesIds);

            CompanyStoreListQueryByStoreIdsReqBo storeListQueryByStoreIdsReqBo = new CompanyStoreListQueryByStoreIdsReqBo();
            // 全部商铺只显示发布的商铺
            storeListQueryByStoreIdsReqBo.setWeshopStatus(1);
            storeListQueryByStoreIdsReqBo.setLimit(weshopListQueryReqDTO.getLimit());
            storeListQueryByStoreIdsReqBo.setOffset(weshopListQueryReqDTO.getOffset());
            baseinfoCompanyStores = companyStoreMapper.selectCompanyStoreWeshopByIds(storeListQueryByStoreIdsReqBo);

        }
        // 转换成DTO并给所有商铺设置是否已收藏属性
        List<WeshopListQueryRespDTO> weshopListQueryRespDTOS = model2Resp(baseinfoCompanyStores, collectedWeshopId);
        context.setResultSuccess(true);
        context.setResultModule(weshopListQueryRespDTOS);
    }

    private PersonGestureReqDTO getPersonCollectionReq(WeshopListQueryReqDTO companyStoreListQueryReqDTO){
        PersonGestureReqDTO personGestureReqDTO = new PersonGestureReqDTO();

        personGestureReqDTO.setPersonId(companyStoreListQueryReqDTO.getLoginPersonId());
        personGestureReqDTO.setLimit(companyStoreListQueryReqDTO.getLimit());
        personGestureReqDTO.setOffset(companyStoreListQueryReqDTO.getOffset());

        Integer type = companyStoreListQueryReqDTO.getWeshopType();
        if(null != type ){
            if(type.equals(1)){
                personGestureReqDTO.setIsPurchased(1);
            }else if(type.equals(2)){
                personGestureReqDTO.setIsCollected(1);
            }
        }
        return personGestureReqDTO;
    }
    /**
     *   根据用户关注的信息获取关注店铺id;
     * @param weshopCollectionPurchases
     * @return
     */
    private List<Long> getCompanyStoresId(List<PersonWeshopCollectionPurchase> weshopCollectionPurchases){
        List<Long> storesIds = new ArrayList<>();
        for(PersonWeshopCollectionPurchase personWeshopCollectionPurchase : weshopCollectionPurchases){
            Long storeId = personWeshopCollectionPurchase.getWeshopId();
            if( null !=  storeId){
                storesIds.add(storeId);
            }
        }
        return storesIds;
    }

    private List<WeshopListQueryRespDTO> model2Resp(List<BaseinfoCompanyStore> baseinfoCompanyStores, Set<Long> collectedWeshopId){
        List<WeshopListQueryRespDTO> weshopListQueryRepDTOs = new ArrayList<>();
        if(CollectionUtil.isEmpty(baseinfoCompanyStores)){
            return weshopListQueryRepDTOs;
        }
        for(BaseinfoCompanyStore companyStore : baseinfoCompanyStores){
            WeshopListQueryRespDTO weshopListQueryRespDTO = new WeshopListQueryRespDTO();
            weshopListQueryRespDTO.setStoreId(companyStore.getStoreId());
            weshopListQueryRespDTO.setStoreNo(companyStore.getStoreNo());
            weshopListQueryRespDTO.setProvince(companyStore.getWeshopProvince());
            weshopListQueryRespDTO.setCity(companyStore.getWeshopCity());
            weshopListQueryRespDTO.setZone(companyStore.getWeshopZone());
            weshopListQueryRespDTO.setAddress(companyStore.getWeshopAddress());
            weshopListQueryRespDTO.setCompId(companyStore.getCompId());
            weshopListQueryRespDTO.setWeshopName(companyStore.getWeshopName());
            weshopListQueryRespDTO.setWeshopLogoImages(companyStore.getWeshopLogoImages());
            weshopListQueryRespDTO.setWeshopManagerName(companyStore.getWeshopManagerName());
            weshopListQueryRespDTO.setWeshopManagerId(companyStore.getWeshopManagerId());
            weshopListQueryRespDTO.setWeshopContactType(companyStore.getWeshopContactType());
            weshopListQueryRespDTO.setWeshopStatus(companyStore.getWeshopStatus());
            if(collectedWeshopId.contains(weshopListQueryRespDTO.getStoreId())){
                weshopListQueryRespDTO.setIsCollected(true);
            }else {
                weshopListQueryRespDTO.setIsCollected(false);
            }
            weshopListQueryRepDTOs.add(weshopListQueryRespDTO);
        }
        return weshopListQueryRepDTOs;
    }

}
