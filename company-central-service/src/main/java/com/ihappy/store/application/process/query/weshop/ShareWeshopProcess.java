package com.ihappy.store.application.process.query.weshop;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.service.outside.wechat.WechatQRCodePathOutRpcService;
import com.ihappy.company.common.constans.OptConstans;
import com.ihappy.company.common.constans.UrlConstants;
import com.ihappy.item.common.enumtype.ItemErrorCodeEnum;
import com.ihappy.item.exception.ItemException;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.request.weshop.WeshopShareReqDTO;
import com.ihappy.store.domain.dto.response.weshop.WeshopShareRespDTO;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import com.ihappy.wechat.domain.dto.request.qrcode.WechatQRCodePathQueryReqDTO;
import com.ihappy.wechat.domain.dto.response.qrcode.WechatQRCodePathQueryRespDTO;
import com.yx.eweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/7/7.
 */
public class ShareWeshopProcess extends DefaultQueryProcess<WeshopShareReqDTO,WeshopShareRespDTO> {
    @Autowired
    private WechatQRCodePathOutRpcService wechatQRCodePathOutRpcService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    public void process(Context<WeshopShareReqDTO, WeshopShareRespDTO> context) {
        WeshopShareReqDTO reqDTO = context.getParam();
        WeshopShareRespDTO respDTO = new WeshopShareRespDTO();
        Long compId = reqDTO.getCompId();
        Long storeId = reqDTO.getStoreId();
        if (compId == null || storeId == null){
            throw new ItemException(ItemErrorCodeEnum.ILLGAL_ARGUMENT.getErrCode(),
                    ItemErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        String qrcodePicture = "";
        String url = UrlConstants.SHARE_WESHOP_URL+"?compId="+compId+"&storeId="+storeId;
        //获取微信二维码
        BaseinfoCompanyStore queryParam = new BaseinfoCompanyStore();
        queryParam.setStoreId(storeId);
        queryParam.setCompId(Integer.valueOf(compId.toString()));
        CompanyStoreModel store = companyStoreService.findByStoreIdAndCompId(new CompanyStoreModel(queryParam));
        if (!StringUtil.isBlank(store.getAtrributes(OptConstans.WESHOP_SHARE_QRCODE_URL_KEY))){
            qrcodePicture = store.getAtrributes(OptConstans.WESHOP_SHARE_QRCODE_URL_KEY);
        }else {
            WechatQRCodePathQueryReqDTO wechatQRCodePathQueryReqDTO = new WechatQRCodePathQueryReqDTO();
            wechatQRCodePathQueryReqDTO.setUrl(url);
            WechatQRCodePathQueryRespDTO qrCodePathQueryRespDTO = wechatQRCodePathOutRpcService.getQRCodePathByUrl(wechatQRCodePathQueryReqDTO);
            qrcodePicture = qrCodePathQueryRespDTO.getPath();
            store.addAttributes(OptConstans.WESHOP_SHARE_QRCODE_URL_KEY,qrcodePicture);
            companyStoreService.updateByIdSelective(store);
        }
        respDTO.setShareUrl(url);
        respDTO.setQrCodePictureUrl(qrcodePicture);
        respDTO.setCompId(compId);
        respDTO.setStoreId(storeId);
        context.getResult().setModule(respDTO);
    }
}
