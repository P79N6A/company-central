package com.ihappy.company.common.enumtype;

/**
 * Created by chenying on 2018/8/27.
 */
public enum OperateErrorEnum {
    OPERATE_SUCCESS(1L, "操作成功"),
    OPERATE_FAIL(-1L, "操作失敗"),
    ADD_COLOR_SUCCESS(10000L, "添加颜色成功!"),
    ADD_SIZE_SUCCESS(10001L, "添加尺码成功!"),
    ADD_COLOR_FAIL(10003L, "添加颜色失败!"),
    ADD_SIZE_FAIL(10004L, "添加尺码失败!"),
    BATCH_DEL_COLOR_SUCCESS(10005L, "删除颜色成功!"),
    BATCH_DEL_SIZE_SUCCESS(10006L, "删除尺码成功!"),
    BATCH_DEL_SOME_COLOR_FAIL(10007L, "删除颜色成功。部分颜色已被使用，无法删除。"),
    BATCH_DEL_SOME_SIZE_FAIL(10008L, "删除尺码成功。部分尺码已被使用，无法删除。"),
    ;
    private Long errCode;
    private String errMessage;

    OperateErrorEnum(Long errCode, String errMessage){
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public Long getErrCode() {
        return errCode;
    }

    public void setErrCode(Long errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}