package com.ihappy.company.domain.dto.response.sys;

import com.konglong.dubbo.annotation.FieldComment;

import java.io.Serializable;

/**
 * Created by sunjd on 2018/12/3.
 */
public class UpdateStatusRespDTO implements Serializable {
    @FieldComment(value = "更新状态  0-无需更新 1-App Store 更新  2-热更新")
    private Integer updateStatus;
    @FieldComment(value = "更新地址")
    private String url;
    @FieldComment(value = "更新说明")
    private String updateNotes;

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdateNotes() {
        return updateNotes;
    }

    public void setUpdateNotes(String updateNotes) {
        this.updateNotes = updateNotes;
    }
}
