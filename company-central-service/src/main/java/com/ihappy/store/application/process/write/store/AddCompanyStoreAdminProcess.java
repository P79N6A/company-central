package com.ihappy.store.application.process.write.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.enumtype.OperateErrorEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.item.exception.ItemException;
import com.ihappy.stock.domain.dto.request.stock.StockAddReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockAddRespDTO;
import com.ihappy.stock.infrastructure.service.StockWriteRpcService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.store.CheckStoreNameBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreAdminAddReqDTO;
import com.ihappy.store.domain.dto.response.OperateResultMessageRespDTO;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.common.util.AttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenying on 2018/8/27.
 */
public class AddCompanyStoreAdminProcess extends DefaultProcess<CompanyStoreAdminAddReqDTO, OperateResultMessageRespDTO> {

    @Autowired
    private TransactionTemplate compTransactionTemplate;

    @Autowired
    private StockWriteRpcService stockWriteRpcService;
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<CompanyStoreAdminAddReqDTO, OperateResultMessageRespDTO> context) {
        CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO = context.getParam();

        //新增门店入参
        BaseinfoCompanyStore baseinfoCompanyStore = getDTO(companyStoreAdminAddReqDTO);
        CheckStoreNameBO checkStoreNameBO = new CheckStoreNameBO();
        checkStoreNameBO.setDeleteFlag(0);
        checkStoreNameBO.setStoreId(baseinfoCompanyStore.getStoreId());
        checkStoreNameBO.setCompId(baseinfoCompanyStore.getCompId());
        checkStoreNameBO.setStoreName(baseinfoCompanyStore.getStoreName());

        List<BaseinfoCompanyStore> storeList = companyStoreService.checkStoreNameIsExist(checkStoreNameBO);
        if (!CollectionUtil.isEmpty(storeList)) {
            throw new CompanyException(StoreErrorCodeEnum.
                    STORE_NAME_IS_EXIST.getErrCode(),
                    StoreErrorCodeEnum.STORE_NAME_IS_EXIST.getErrMsg());
        }

        int row = compTransactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus status) {
                int addStoreCount = 0;
                addStoreCount = companyStoreService.addStore(baseinfoCompanyStore);
                if (addStoreCount == 0) {
                    throw new ItemException(StoreErrorCodeEnum.
                            ADD_COMPANY_STORE_ERROR.getErrCode(),
                            StoreErrorCodeEnum.ADD_COMPANY_STORE_ERROR.getErrMsg());
                }
                StockAddReqDTO stockAddReqDTO = getStockAddReqDTO(baseinfoCompanyStore);
                stockAddReqDTO.setLoginCompId(companyStoreAdminAddReqDTO.getLoginCompId());
                stockAddReqDTO.setLoginPersonId(companyStoreAdminAddReqDTO.getLoginPersonId());
                Result<StockAddRespDTO> stockIdResult = stockWriteRpcService.addStock(stockAddReqDTO);
                if (!stockIdResult.isSuccess()) {
                    throw new ItemException(StoreErrorCodeEnum.
                            ADD_COMPANY_STORE_ERROR.getErrCode(),
                            StoreErrorCodeEnum.ADD_COMPANY_STORE_ERROR.getErrMsg());
                }
                return addStoreCount;
            }
        });
        if (row == 0) {
            context.setResultModule(OperateResultMessageRespDTO.failResult(OperateErrorEnum.OPERATE_FAIL));
            return;
        }
        context.getResult().setModule(OperateResultMessageRespDTO.successResult());
    }

    private BaseinfoCompanyStore getDTO(CompanyStoreAdminAddReqDTO companyStoreAdminAddReqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        long storeId = DistributedPrimaryKeyFactory.generateCompanyStoreId(companyStoreAdminAddReqDTO.getLoginCompId());
        baseinfoCompanyStore.setStoreId(storeId);
        baseinfoCompanyStore.setStoreName(companyStoreAdminAddReqDTO.getStoreName());
        baseinfoCompanyStore.setAddress(companyStoreAdminAddReqDTO.getAddress());
        baseinfoCompanyStore.setStoreAcreage(companyStoreAdminAddReqDTO.getStoreAcreage());
        baseinfoCompanyStore.setStoreContact(companyStoreAdminAddReqDTO.getStoreContact());
        baseinfoCompanyStore.setStorePhone(companyStoreAdminAddReqDTO.getStorePhone());
        baseinfoCompanyStore.setAdminPersonId(companyStoreAdminAddReqDTO.getStoreContactId());
        baseinfoCompanyStore.setCompId(Integer.valueOf(companyStoreAdminAddReqDTO.getLoginCompId().toString()));
        baseinfoCompanyStore.setCreatedAt(CompanyDateUtil.getDate14Long(new Date()));
        baseinfoCompanyStore.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        baseinfoCompanyStore.setCreatedPersonId(companyStoreAdminAddReqDTO.getLoginPersonId());
        baseinfoCompanyStore.setUpdatedPersonId(companyStoreAdminAddReqDTO.getLoginPersonId());
        baseinfoCompanyStore.setStoreTel(companyStoreAdminAddReqDTO.getStoreTel());
        baseinfoCompanyStore.setAlipayAccountName(companyStoreAdminAddReqDTO.getAlipayAccountName());
        baseinfoCompanyStore.setAlipayReceiptQrcode(companyStoreAdminAddReqDTO.getAlipayReceiptQrcode());
        baseinfoCompanyStore.setAlipayReceiptQrcodeContent(companyStoreAdminAddReqDTO.getAlipayReceiptQrcodeContent());
        baseinfoCompanyStore.setWechatAccountName(companyStoreAdminAddReqDTO.getWechatAccountName());
        baseinfoCompanyStore.setWechatAccountQrcode(companyStoreAdminAddReqDTO.getWechatAccountQrcode());
        baseinfoCompanyStore.setWechatAccountQrcodeContent(companyStoreAdminAddReqDTO.getWechatAccountQrcodeContent());
        baseinfoCompanyStore.setWechatReceiptQrcode(companyStoreAdminAddReqDTO.getWechatReceiptQrcode());
        baseinfoCompanyStore.setWechatReceiptQrcodeContent(companyStoreAdminAddReqDTO.getWechatReceiptQrcodeContent());
        Map<String, String> map = new HashMap<>();
        //将银行信息以map键值对形式存储
        map.put("bankInfo", companyStoreAdminAddReqDTO.getBankInfo());
        baseinfoCompanyStore.setAttributes(AttributeUtil.toString(map));
        baseinfoCompanyStore.setProvince(companyStoreAdminAddReqDTO.getProvince());
        baseinfoCompanyStore.setCity(companyStoreAdminAddReqDTO.getCity());
        baseinfoCompanyStore.setZone(companyStoreAdminAddReqDTO.getZone());
        baseinfoCompanyStore.setExpireDate(CompanyDateUtil.addDateToLong(CompanyDateUtil.getTodayStartDate14Long(),
                OptConstans.DEFAULT_COMPANY_SERVICE_TIME));
        return baseinfoCompanyStore;
    }

    public StockAddReqDTO getStockAddReqDTO(BaseinfoCompanyStore baseinfoCompanyStore) {
        StockAddReqDTO stockAddReqDTO = new StockAddReqDTO();
        if (baseinfoCompanyStore != null) {
            stockAddReqDTO.setStockName(baseinfoCompanyStore.getStoreName() + "默认仓库");
            stockAddReqDTO.setStockAcreage(baseinfoCompanyStore.getStoreAcreage());
            stockAddReqDTO.setAddress(baseinfoCompanyStore.getAddress());
            stockAddReqDTO.setStoreId(baseinfoCompanyStore.getStoreId());
            stockAddReqDTO.setCompId(baseinfoCompanyStore.getCompId());
            stockAddReqDTO.setIsDefault(1);
            stockAddReqDTO.setIsPerson(true);
        }
        return stockAddReqDTO;
    }
}
