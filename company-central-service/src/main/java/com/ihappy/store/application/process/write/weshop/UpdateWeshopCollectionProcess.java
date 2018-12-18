package com.ihappy.store.application.process.write.weshop;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.domain.dto.request.user.PersonGestureReqDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.PersonWeshopCollectionPurchaseMapper;
import com.ihappy.store.domain.dbdo.weshop.PersonWeshopCollectionPurchase;
import com.ihappy.store.domain.dbdo.weshop.WeshopCollectionJournal;
import com.ihappy.store.domain.dto.request.weshop.CompanyWeshopCollectionReqDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.WeshopCollectionJournalMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: company-central
 * @description: 用户收藏店铺信息更新
 * @author: 汪正
 * @create: 2018-05-21 17:23
 **/
public class UpdateWeshopCollectionProcess extends DefaultProcess<CompanyWeshopCollectionReqDTO, Boolean> {

    @Autowired
    private PersonWeshopCollectionPurchaseMapper collectionPurchaseMapper;

    @Autowired
    private WeshopCollectionJournalMapper weshopCollectionJournalMapper;

    @Override
    public void process(Context<CompanyWeshopCollectionReqDTO, Boolean> context) {
        CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO = context.getParam();

        boolean userHasCollection = userHasCollectionStore(companyWeshopCollectionReqDTO);
        //已经存在则更新，否则新增一条记录
        if (userHasCollection) {
            int num = updatePersonCollectionStatus(companyWeshopCollectionReqDTO);
            if (num <= 0) {
                context.getResult().setModule(false);
                context.setResultSuccess(false);
                return;
            }
        } else {
            //插入一条记录
            int id = insertPersonCollectionStatus(companyWeshopCollectionReqDTO);
            if (id <= 0) {
                context.getResult().setModule(false);
                context.setResultSuccess(false);
                return;
            }
        }

        Integer operaetype = companyWeshopCollectionReqDTO.getOperateType();
        //为收藏时增加一条收藏流水
        if (null != operaetype && operaetype == 1) {
            //此处插入一条流水
            int id = insertWeshopCollectionJournal(companyWeshopCollectionReqDTO);
            if (id <= 0) {
                context.getResult().setModule(false);
                context.setResultSuccess(false);
                return;
            }
        }
        context.getResult().setModule(true);
        context.setResultSuccess(false);
    }

    /**
     * person_weshop_collection_purchase 表中是否有对象的收藏记录
     *
     * @param companyWeshopCollectionReqDTO
     * @return
     */
    private boolean userHasCollectionStore(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {

        PersonGestureReqDTO personGestureReqDTO = new PersonGestureReqDTO();
        personGestureReqDTO.setPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());
        Long storeId = companyWeshopCollectionReqDTO.getStoreId();
        List<Long> storeIds = new ArrayList<>();
        storeIds.add(storeId);
        personGestureReqDTO.setWeshopIds(storeIds);
        List<PersonWeshopCollectionPurchase> personWeshopCollectionPurchases = collectionPurchaseMapper.selectPersonGestureList(personGestureReqDTO);
        if (null == personWeshopCollectionPurchases || personWeshopCollectionPurchases.size() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private int updatePersonCollectionStatus(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {
        PersonWeshopCollectionPurchase personWeshopCollectionPurchase = new PersonWeshopCollectionPurchase();
        personWeshopCollectionPurchase.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        personWeshopCollectionPurchase.setUpdatedPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());

        personWeshopCollectionPurchase.setPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());
        personWeshopCollectionPurchase.setWeshopId(companyWeshopCollectionReqDTO.getStoreId());

        Integer operaetype = companyWeshopCollectionReqDTO.getOperateType();
        if (null != operaetype && operaetype == 1) {
            personWeshopCollectionPurchase.setIsCollected(true);
        } else {
            personWeshopCollectionPurchase.setIsCollected(false);
        }
        return collectionPurchaseMapper.updatePersonCollectionStatus(personWeshopCollectionPurchase);
    }

    /**
     * 插入一条用户对商铺的收藏记录
     *
     * @param companyWeshopCollectionReqDTO
     * @return
     */
    private int insertPersonCollectionStatus(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {
        PersonWeshopCollectionPurchase personWeshopCollectionPurchase = new PersonWeshopCollectionPurchase();

        long id = DistributedPrimaryKeyFactory.generatePersonWeshopCollectionPurchaseId(companyWeshopCollectionReqDTO.getLoginPersonId());
        personWeshopCollectionPurchase.setPersonWeshopCollectionPurchaseId(id);
        personWeshopCollectionPurchase.setPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());
        personWeshopCollectionPurchase.setWeshopId(companyWeshopCollectionReqDTO.getStoreId());

        personWeshopCollectionPurchase.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        personWeshopCollectionPurchase.setCreatedPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());

        Integer operaetype = companyWeshopCollectionReqDTO.getOperateType();
        if (null != operaetype && operaetype == 1) {
            personWeshopCollectionPurchase.setIsCollected(true);
        } else {
            personWeshopCollectionPurchase.setIsCollected(false);
        }
        return collectionPurchaseMapper.insertSelective(personWeshopCollectionPurchase);

    }

    private int insertWeshopCollectionJournal(CompanyWeshopCollectionReqDTO companyWeshopCollectionReqDTO) {

        WeshopCollectionJournal weshopCollectionJournal = new WeshopCollectionJournal();
        long id = DistributedPrimaryKeyFactory.generateWeshopCollectionJournalId(companyWeshopCollectionReqDTO.getCompId());
        weshopCollectionJournal.setWeshopCollectionJournalId(id);
        weshopCollectionJournal.setVisitUserId(companyWeshopCollectionReqDTO.getLoginPersonId());
        //还未添加
        weshopCollectionJournal.setVisitToken(companyWeshopCollectionReqDTO.getLoginTokenId());
        weshopCollectionJournal.setStoreId(companyWeshopCollectionReqDTO.getStoreId());
        weshopCollectionJournal.setCompId(companyWeshopCollectionReqDTO.getCompId());
        weshopCollectionJournal.setCollectedTime(CompanyDateUtil.getDate14Long(new Date()));
        weshopCollectionJournal.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        weshopCollectionJournal.setCreatedPersonId(companyWeshopCollectionReqDTO.getLoginPersonId());

        return weshopCollectionJournalMapper.insertSelective(weshopCollectionJournal);
    }

}
