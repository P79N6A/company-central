package com.ihappy.store.application.process.write.weshop;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.common.util.DateUtil;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.store.common.enumtype.weshop.WeshopVisitUidTypeEnum;
import com.ihappy.store.domain.dbdo.weshop.WeshopVisitJournal;
import com.ihappy.store.domain.dto.request.weshop.WeshopVisitCountAddReqDTO;
import com.ihappy.store.infrastructure.repo.mybatis.mapper.weshop.WeshopVisitJournalMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-06 17:16
 */
public class AddWeshopVisitProcess extends DefaultProcess<WeshopVisitCountAddReqDTO, String> {

    @Autowired
    private WeshopVisitJournalMapper weshopVisitJournalMapper;

    @Override
    public void process(Context<WeshopVisitCountAddReqDTO, String> context) {
        WeshopVisitCountAddReqDTO param = context.getParam();
        // 1.从redis中读取该token对该商铺商品的访问是否在时间间隔内
        boolean hasVisitedDuringInterval = false;
        if (param.getLoginTokenId() != null){
            hasVisitedDuringInterval = CompanyRedisUtil.checkHasVisitDuringInterval(param.getLoginTokenId(), param.getStoreId());
        }
        if(!hasVisitedDuringInterval){
            // 2.不在时间间隔内, 记录流水
            WeshopVisitJournal record = new WeshopVisitJournal();
            if(param.getCompId() != null) {
                record.setCompId(param.getCompId().intValue());
            }
            record.setStoreId(param.getStoreId());
            if(param.getGoodsId() != null) {
                record.setGoodsId(param.getGoodsId().intValue());
            }
            record.setVisitToken(param.getLoginTokenId());
            record.setVisitUserId(param.getPersonId());
            record.setWeshopVisitId(DistributedPrimaryKeyFactory.generateWeshopVisitJournalId(param.getCompId()));
            record.setVisitTime(DateUtil.getCurrentDate());
            record.setCreatedAt(DateUtil.getCurrentDate());
            record.setCreatedPersonId(0);
            record.setUpdatedAt(DateUtil.getCurrentDate());
            record.setUpdatedPersonId(0);
            record.setUidType(param.getUidType());
            record.setUid(param.getUid());
            if (record.getUid() == null && WeshopVisitUidTypeEnum.USER_ID.getKey().equals(record.getUidType())){
                record.setUid(record.getVisitUserId() == null?"":record.getVisitUserId().toString());
            }
            if (record.getUid() == null && record.getUidType() == null && record.getVisitUserId() != null){
                record.setUid(record.getVisitUserId().toString());
                record.setUidType(WeshopVisitUidTypeEnum.USER_ID.getKey());
            }

            weshopVisitJournalMapper.insertSelective(record);
            context.setResultSuccess(true);
            context.setResultModule("记录流水, 增加访问数");
            return;
        }
        context.setResultSuccess(true);
        context.setResultModule("在间隔时间内访问, 不记录流水");
    }
}
