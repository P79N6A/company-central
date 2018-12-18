package com.ihappy.role.application.process.query.sys;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.bo.SysFuncByClIdBO;
import com.ihappy.role.domain.dto.request.sys.SysFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysFuncFactory;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 运营后台查询所有权限
 * Created by Administrator on 2018/6/16.
 */
public class QuerySysFuncListProcess extends DefaultQueryProcess<SysFuncListQueryReqDTO, List<PrivilegeAllRespDTO>> {

    @Autowired
    private SysFuncService sysFuncService;

    @Override
    public void process(Context<SysFuncListQueryReqDTO, List<PrivilegeAllRespDTO>> context) {

        SysFuncListQueryReqDTO sysFuncListQueryReqDTO = context.getParam();

        SysFuncByClIdBO sysFuncByClIdBO = new SysFuncByClIdBO();
        sysFuncByClIdBO.setClientId(sysFuncListQueryReqDTO.getClientId());

       List<SysFuncModel> resultModel =  sysFuncService.selectSysFuncByList(sysFuncByClIdBO);

        List<PrivilegeAllRespDTO> respDTOList = new ArrayList<>();

       for(SysFuncModel sysFuncModel : resultModel){
          respDTOList.add( SysFuncFactory.toPrivilegeAllRespDTO(sysFuncModel));
       }

       if(!CollectionUtil.isEmpty(respDTOList)){
           RolePrivilegeRedisUtil.putAllSysPriv(ConfigCenterUtil.ENV, sysFuncListQueryReqDTO.getClientId()+"", respDTOList);

       }
       context.getResult().setModule(respDTOList);
    }
}
