package com.ihappy.store.application.process.write.store;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.utils.AttributeUtil;
import com.ihappy.item.exception.ItemException;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.bo.store.CheckStoreNameBO;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.store.CompanyStoreAdminUpdateReqDTO;
import com.ihappy.store.domain.dto.response.OperateResultMessageRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenying on 2018/8/28.
 */
public class UpdateCompanyStoreAdminProcess extends DefaultProcess<CompanyStoreAdminUpdateReqDTO, OperateResultMessageRespDTO> {

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<CompanyStoreAdminUpdateReqDTO, OperateResultMessageRespDTO> context) {
        CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO = context.getParam();
        if (companyStoreAdminUpdateReqDTO.getStoreAcreage() == null) {
            companyStoreAdminUpdateReqDTO.setStoreAcreage(0);
        }
        CompanyStoreModel companyStoreModel = getDTO(companyStoreAdminUpdateReqDTO);
        if (StringUtil.isBlank(companyStoreModel.getDO().getStoreName())) {
            CheckStoreNameBO checkStoreNameBO = new CheckStoreNameBO();
            checkStoreNameBO.setDeleteFlag(0);
            checkStoreNameBO.setStoreId(companyStoreModel.getStoreId());
            checkStoreNameBO.setCompId(companyStoreModel.getDO().getCompId());
            checkStoreNameBO.setStoreName(companyStoreModel.getDO().getStoreName());
            List<BaseinfoCompanyStore> storeList = companyStoreService.checkStoreNameIsExist(checkStoreNameBO);
            if (!CollectionUtil.isEmpty(storeList)) {
                throw new ItemException(StoreErrorCodeEnum.
                        STORE_NAME_IS_EXIST.getErrCode(),
                        StoreErrorCodeEnum.STORE_NAME_IS_EXIST.getErrMsg());
            }
        }
        companyStoreService.updateByIdSelective(companyStoreModel);
        context.getResult().setModule(OperateResultMessageRespDTO.successResult());
    }

    private CompanyStoreModel getDTO(CompanyStoreAdminUpdateReqDTO companyStoreAdminUpdateReqDTO) {
        BaseinfoCompanyStore baseinfoCompanyStore = new BaseinfoCompanyStore();
        baseinfoCompanyStore.setStoreId(companyStoreAdminUpdateReqDTO.getStoreId());
        baseinfoCompanyStore.setCompId(companyStoreAdminUpdateReqDTO.getLoginCompId().intValue());
        baseinfoCompanyStore.setStoreName(companyStoreAdminUpdateReqDTO.getStoreName());
        baseinfoCompanyStore.setAddress(companyStoreAdminUpdateReqDTO.getAddress());
        baseinfoCompanyStore.setStoreAcreage(companyStoreAdminUpdateReqDTO.getStoreAcreage());

        baseinfoCompanyStore.setStoreContact(companyStoreAdminUpdateReqDTO.getStoreContact());
        baseinfoCompanyStore.setStorePhone(companyStoreAdminUpdateReqDTO.getStorePhone());
        baseinfoCompanyStore.setAdminPersonId(companyStoreAdminUpdateReqDTO.getStoreContactId());

        baseinfoCompanyStore.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
        baseinfoCompanyStore.setUpdatedPersonId(companyStoreAdminUpdateReqDTO.getLoginPersonId());
        baseinfoCompanyStore.setStoreTel(companyStoreAdminUpdateReqDTO.getStoreTel());
      //  baseinfoCompanyStore.setArea(companyStoreAdminUpdateReqDTO.getProvince()+companyStoreAdminUpdateReqDTO.getCity()+companyStoreAdminUpdateReqDTO.getZone());
        baseinfoCompanyStore.setProvince(companyStoreAdminUpdateReqDTO.getProvince());
        baseinfoCompanyStore.setCity(companyStoreAdminUpdateReqDTO.getCity());
        baseinfoCompanyStore.setZone(companyStoreAdminUpdateReqDTO.getZone());
        baseinfoCompanyStore.setAlipayAccountName(companyStoreAdminUpdateReqDTO.getAlipayAccountName());
        baseinfoCompanyStore.setAlipayReceiptQrcode(companyStoreAdminUpdateReqDTO.getAlipayReceiptQrcode());
        baseinfoCompanyStore.setAlipayReceiptQrcodeContent(companyStoreAdminUpdateReqDTO.getAlipayReceiptQrcodeContent());
        baseinfoCompanyStore.setWechatAccountName(companyStoreAdminUpdateReqDTO.getWechatAccountName());
        baseinfoCompanyStore.setWechatAccountQrcode(companyStoreAdminUpdateReqDTO.getWechatAccountQrcode());
        baseinfoCompanyStore.setWechatAccountQrcodeContent(companyStoreAdminUpdateReqDTO.getWechatAccountQrcodeContent());
        baseinfoCompanyStore.setWechatReceiptQrcode(companyStoreAdminUpdateReqDTO.getWechatReceiptQrcode());
        baseinfoCompanyStore.setWechatReceiptQrcodeContent(companyStoreAdminUpdateReqDTO.getWechatReceiptQrcodeContent());
        baseinfoCompanyStore.setLogoUrl(companyStoreAdminUpdateReqDTO.getLogoUrl());
        //新建map集合，把得到的银行信息放入map集合里，以bankInfo表示
        Map<String,String> map=new HashMap<>();
        map.put("bankInfo",companyStoreAdminUpdateReqDTO.getBankInfo());
        //将map集合转换成字符串形式
        baseinfoCompanyStore.setAttributes(AttributeUtil.toString(map));
        return new CompanyStoreModel(baseinfoCompanyStore);
    }
}
