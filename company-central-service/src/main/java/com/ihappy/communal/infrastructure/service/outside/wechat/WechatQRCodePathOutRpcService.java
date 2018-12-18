package com.ihappy.communal.infrastructure.service.outside.wechat;

import com.ihappy.wechat.domain.dto.request.qrcode.WechatQRCodePathQueryReqDTO;
import com.ihappy.wechat.domain.dto.response.qrcode.WechatQRCodePathQueryRespDTO;

/**
 * Created by sunjd on 2018/7/7.
 */
public interface WechatQRCodePathOutRpcService {
    /**
     * 获取url
     * @param wechatQRCodePathQueryReqDTO
     * @return
     */
    WechatQRCodePathQueryRespDTO getQRCodePathByUrl(WechatQRCodePathQueryReqDTO wechatQRCodePathQueryReqDTO);
}
