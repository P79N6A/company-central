package com.ihappy.communal.infrastructure.service.outside.wechat.impl;

import com.ihappy.communal.infrastructure.service.outside.wechat.WechatQRCodePathOutRpcService;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.wechat.domain.dto.request.qrcode.WechatQRCodePathQueryReqDTO;
import com.ihappy.wechat.domain.dto.response.qrcode.WechatQRCodePathQueryRespDTO;
import com.ihappy.wechat.infrastructure.service.WechatQRCodePathRpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/7/7.
 */
public class WechatQRCodePathOutRpcServiceImpl implements WechatQRCodePathOutRpcService {

    @Autowired
    private WechatQRCodePathRpcService wechatQRCodePathRpcServiceClient;

    @Override
    public WechatQRCodePathQueryRespDTO getQRCodePathByUrl(WechatQRCodePathQueryReqDTO wechatQRCodePathQueryReqDTO) {
        Result<WechatQRCodePathQueryRespDTO> wechatResult = wechatQRCodePathRpcServiceClient.getQRCodePathByUrl(wechatQRCodePathQueryReqDTO);
        if(wechatResult == null || !wechatResult.isSuccess() || wechatResult.getModule() == null){
            throw new CompanyException(CompanyErrorCodeEnum.NETWORK_IDEMPOTENT_INVOKE);
        }
        return wechatResult.getModule();
    }
}