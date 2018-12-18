package com.ihappy.store.application.process.write.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.service.outside.item.ItemGoodsStockOutSideService;
import com.ihappy.communal.infrastructure.service.outside.user.UserInfoOutSideService;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.OperateErrorEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.item.domain.dto.request.goodsstock.ItemStoreGoodsStockQuery;
import com.ihappy.item.domain.dto.response.goodsstock.ItemStoreGoodsStockInfoRespDTO;
import com.ihappy.stock.domain.bo.stock.DeleteStoreById;
import com.ihappy.stock.infrastructure.repo.mybatis.mapper.BaseinfoCompanyStockMapper;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreAdminDeleteReqDTO;
import com.ihappy.store.domain.dto.response.OperateResultMessageRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.user.domain.dto.response.person.CompStoreInfoRespDTO;
import com.ihappy.user.domain.query.person.CompStoreQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by chenying on 2018/8/28.
 */
public class DeleteCompanyStoreAdminProcess extends DefaultProcess<CompanyStoreAdminDeleteReqDTO, OperateResultMessageRespDTO> {

    @Autowired
    private TransactionTemplate compTransactionTemplate;

    @Autowired
    private UserInfoOutSideService userInfoOutSideService;

    @Autowired
    private ItemGoodsStockOutSideService itemGoodsStockOutSideService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private BaseinfoCompanyStockMapper baseinfoCompanyStockMapper;

    @Override
    public void process(Context<CompanyStoreAdminDeleteReqDTO, OperateResultMessageRespDTO> context) {
        CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO = context.getParam();

        //先判断门店是不是总仓，是1=总仓则抛出异常总仓不能删除
        BaseinfoCompanyStore baseinfoCompanyStore = getDTO(companyStoreAdminDeleteReqDTO);
        CompanyStoreModel companyStoreModel = companyStoreService.findByStoreIdAndCompId(new CompanyStoreModel(baseinfoCompanyStore));
        if (companyStoreModel.getDO().getIsPublic().intValue() == 1) {
            throw new CompanyException(StoreErrorCodeEnum.
                    CAN_NOT_PUBLIC_STORE_DELETE.getErrCode(),
                    StoreErrorCodeEnum.CAN_NOT_PUBLIC_STORE_DELETE.getErrMsg());
        }
        //不是总仓则调用户中心查这个门店是否被用户使用已被使用则抛出异常：该门店已被使用，无法删除
        CompStoreQuery compStoreQuery = new CompStoreQuery();
        compStoreQuery.setStoreId(companyStoreAdminDeleteReqDTO.getStoreId());
        compStoreQuery.setLoginCompId(companyStoreAdminDeleteReqDTO.getLoginCompId());
        compStoreQuery.setLoginPersonId(companyStoreAdminDeleteReqDTO.getLoginPersonId());
        List<CompStoreInfoRespDTO> userStoreList = userInfoOutSideService.queryCompStoreInfo(compStoreQuery, true);
        if (!CollectionUtil.isEmpty(userStoreList)) {
            throw new CompanyException(StoreErrorCodeEnum.
                    CAN_NOT_STORE_DELETEE.getErrCode(),
                    StoreErrorCodeEnum.CAN_NOT_STORE_DELETEE.getErrMsg());
        }
        //用户没有占用则调商品中心查门店下是否存在库存信息
        ItemStoreGoodsStockQuery itemStoreGoodsStockQuery = new ItemStoreGoodsStockQuery();
        itemStoreGoodsStockQuery.setStoreId(companyStoreAdminDeleteReqDTO.getStoreId());
        itemStoreGoodsStockQuery.setLoginPersonId(companyStoreAdminDeleteReqDTO.getLoginPersonId());
        itemStoreGoodsStockQuery.setLoginCompId(companyStoreAdminDeleteReqDTO.getLoginCompId());
        List<ItemStoreGoodsStockInfoRespDTO> goodsStockStoreList = itemGoodsStockOutSideService.queryItemStoreGoodsStock(itemStoreGoodsStockQuery, true);
        if (!CollectionUtil.isEmpty(goodsStockStoreList)) {
            throw new CompanyException(StoreErrorCodeEnum.
                    CAN_NOT_STORE_DELETEE.getErrCode(),
                    StoreErrorCodeEnum.CAN_NOT_STORE_DELETEE.getErrMsg());
        }

        int row = compTransactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                int deleteStoreCount = 0;

                DeleteStoreById deleteStoreById = new DeleteStoreById();
                deleteStoreById.setCompId(baseinfoCompanyStore.getCompId());
                deleteStoreById.setStoreId(baseinfoCompanyStore.getStoreId());
                deleteStoreById.setUpdatedPersonId(baseinfoCompanyStore.getUpdatedPersonId());
                deleteStoreById.setUpdatedAt(baseinfoCompanyStore.getUpdatedAt());

                int deleteStock = baseinfoCompanyStockMapper.deleteStockByStoreId(deleteStoreById);
                if (deleteStock < 1) {
                  throw new CompanyException(CompanyErrorCodeEnum.DELETE_FAILED.getErrCode(),
                          CompanyErrorCodeEnum.DELETE_FAILED.getErrMsg());
                }
                //删除门店
                deleteStoreCount = companyStoreService.deleteCompanyStore(baseinfoCompanyStore);
                return deleteStoreCount;
            }
        });
        if (row == 0) {
            context.setResultModule(OperateResultMessageRespDTO.failResult(OperateErrorEnum.OPERATE_FAIL));
            return;
        }
        context.getResult().setModule(OperateResultMessageRespDTO.successResult());
    }

    public BaseinfoCompanyStore getDTO(CompanyStoreAdminDeleteReqDTO companyStoreAdminDeleteReqDTO) {
        if (companyStoreAdminDeleteReqDTO == null) {
            return null;
        }
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        baseinfoCompanyStore.setUpdatedPersonId(companyStoreAdminDeleteReqDTO.getLoginPersonId());
        baseinfoCompanyStore.setStoreId(companyStoreAdminDeleteReqDTO.getStoreId());
        baseinfoCompanyStore.setCompId(Integer.valueOf(companyStoreAdminDeleteReqDTO.getLoginCompId().toString()));
        return baseinfoCompanyStore;
    }
}
