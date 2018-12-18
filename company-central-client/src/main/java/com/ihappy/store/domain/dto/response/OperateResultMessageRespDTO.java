package com.ihappy.store.domain.dto.response;

import com.ihappy.common.domain.dto.BaseRespDTO;
import com.ihappy.company.common.enumtype.OperateErrorEnum;

import java.io.Serializable;

/**
 * Created by chenying on 2018/8/27.
 */
public class OperateResultMessageRespDTO extends BaseRespDTO implements Serializable {
    private static final long serialVersionUID = -2501697896388711431L;
    /**
     * 错误码
     */
    private Long errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    private boolean success=true;

    public Long getErrCode() {
        return errCode;
    }

    public void setErrCode(Long errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static OperateResultMessageRespDTO successResult(){
        OperateResultMessageRespDTO result = new OperateResultMessageRespDTO(OperateErrorEnum.OPERATE_SUCCESS);
        result.setSuccess(true);
        return result;
    }

    public static OperateResultMessageRespDTO failResult(OperateErrorEnum operateErrorEnum){
        OperateResultMessageRespDTO result = new OperateResultMessageRespDTO(operateErrorEnum);
        result.setSuccess(false);
        return result;
    }

    public OperateResultMessageRespDTO() {
    }

    public OperateResultMessageRespDTO(OperateErrorEnum operateErrorEnum){
        this.errCode = operateErrorEnum.getErrCode();
        this.errMsg = operateErrorEnum.getErrMessage();
    }

    public OperateResultMessageRespDTO(Long errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;

    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

}
