package com.ihappy.company.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.constans.SysParamConstans;
import com.ihappy.company.domain.dto.request.sys.UpdateStatusReqDTO;
import com.ihappy.company.domain.dto.response.sys.UpdateStatusRespDTO;
import com.ihappy.company.domain.model.model.SysParamModel;
import com.ihappy.company.infrastructure.service.inside.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunjd on 2018/12/3.
 */
public class QuereyUpdateStatusProcess  extends DefaultProcess<UpdateStatusReqDTO,UpdateStatusRespDTO> {
    @Autowired
    private SysParamService sysParamService;
    @Override
    public void process(Context<UpdateStatusReqDTO, UpdateStatusRespDTO> context) {
        UpdateStatusReqDTO reqDTO = context.getParam();
        UpdateStatusRespDTO respDTO = new UpdateStatusRespDTO();
        respDTO.setUpdateStatus(SysParamConstans.NO_UPDATE_STATUS);
        context.getResult().setModule(respDTO);
        //App Store版本
        SysParamModel lastAppStoreVersion = sysParamService.selectByKey(getAppStoreVersionKey(reqDTO));
        if (lastAppStoreVersion == null || lastAppStoreVersion.getDO().getParamValue() == null){
            return;
        }
        if (lastAppStoreVersion.needUpdate(reqDTO.getVersion())){
            respDTO.setUpdateStatus(SysParamConstans.APP_STORE_UPDATE_STATUS);
            getUpdateUrl(reqDTO,respDTO);
            getUpdateNote(reqDTO,respDTO);
            context.getResult().setModule(respDTO);
            return;
        }

        //热更新版本
        SysParamModel lastHotUpdateVersion = sysParamService.selectByKey(SysParamConstans.HOT_UPDATE_VERSION);
        if (lastHotUpdateVersion == null || lastHotUpdateVersion.getDO().getParamValue() == null ){
            return;
        }
        if (lastHotUpdateVersion.needUpdate(reqDTO.getVersion())){
            respDTO.setUpdateStatus(SysParamConstans.HOT_UPDATE_UPDATE_STATUS);
            getUpdateUrl(reqDTO,respDTO);
            getUpdateNote(reqDTO,respDTO);
            context.getResult().setModule(respDTO);
            return;
        }
        return;
    }

    private void getUpdateUrl(UpdateStatusReqDTO reqDTO,UpdateStatusRespDTO respDTO){
        if (SysParamConstans.NO_UPDATE_STATUS.equals(respDTO.getUpdateStatus())){
            return;
        }
        if (SysParamConstans.HOT_UPDATE_UPDATE_STATUS.equals(respDTO.getUpdateStatus())){
            respDTO.setUrl(sysParamService.selectValueByKey(SysParamConstans.HOT_UPDATE_URL));
            return;
        }
        if (SysParamConstans.IOS.equals(reqDTO.getOs())){
            respDTO.setUrl(sysParamService.selectValueByKey(SysParamConstans.IOS_APP_STORE_URL));
            return;
        }
        if (SysParamConstans.ANDROID.equals(reqDTO.getOs())){
            respDTO.setUrl(sysParamService.selectValueByKey(SysParamConstans.ANDROID_APP_STORE_URL));
            return;
        }
    }

    private void getUpdateNote(UpdateStatusReqDTO reqDTO,UpdateStatusRespDTO respDTO){
        if (SysParamConstans.NO_UPDATE_STATUS.equals(respDTO.getUpdateStatus())){
            return;
        }
        if (SysParamConstans.HOT_UPDATE_UPDATE_STATUS.equals(respDTO.getUpdateStatus())){
            respDTO.setUpdateNotes(sysParamService.selectValueByKey(SysParamConstans.HOT_UPDATE_NOTE));
            return;
        }
        if (SysParamConstans.IOS.equals(reqDTO.getOs())){
            respDTO.setUpdateNotes(sysParamService.selectValueByKey(SysParamConstans.IOS_APP_STORE_NOTE));
            return;
        }
        if (SysParamConstans.ANDROID.equals(reqDTO.getOs())){
            respDTO.setUpdateNotes(sysParamService.selectValueByKey(SysParamConstans.ANDROID_APP_STORE_NOTE));
            return;
        }
    }

    private String getAppStoreVersionKey(UpdateStatusReqDTO reqDTO){
        if (SysParamConstans.IOS.equals(reqDTO.getOs())){
            return SysParamConstans.IOS_APP_STORE_VERSION;
        }
        if (SysParamConstans.ANDROID.equals(reqDTO.getOs())){
            return SysParamConstans.ANDROID_APP_STORE_VERSION;
        }
        return null;
    }
}