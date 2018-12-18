package com.ihappy.role.application.process.write.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.bo.SysRoleManageBO;
import com.ihappy.role.domain.dto.request.sys.SysRoleMangeRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleMangeRoleUpdateRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleRightRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * created by zhangmengdan
 *  运营后台-设置-角色管理-角色编辑-修改process
 */
public class UpdateSysRoleManageRoleInfoProcess extends DefaultProcess<SysRoleMangeRoleUpdateReqDTO, SysRoleMangeRoleUpdateRespDTO> {
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public void process(Context<SysRoleMangeRoleUpdateReqDTO, SysRoleMangeRoleUpdateRespDTO> context) {
        SysRoleMangeRoleUpdateReqDTO sysRoleMangeRoleUpdateReqDTO = context.getParam();
        SysRoleModel sysRoleModel = sysRoleService.findSysRoleManageRoleInfoByRoleId(SysRoleFactory.SysRoleMangeRoleUpdateReqDTOTOModel(sysRoleMangeRoleUpdateReqDTO));
        //角色是否为空
        if (sysRoleModel == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //角色是否被删除
        if (sysRoleModel.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //角色名称是否重复
        SysRoleModel role = sysRoleService.checkSysRoleNameIsOrNotRepeat(SysRoleFactory.sysRoleMangeRoleUpdateReqDTOTOModel(sysRoleMangeRoleUpdateReqDTO));
        if (role != null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrMsg());
        }
        SysRoleManageBO sysRoleManageBO=SysRoleFactory.SysRoleMangeRoleUpdateReqDTOTOModel(sysRoleMangeRoleUpdateReqDTO);
        //将前端json字符串对象转换成list对象
        List<SysRoleRightRespDTO> sysRoleRightsRespDTOSFromReq=JSONArray.parseArray(sysRoleMangeRoleUpdateReqDTO.getRoleRights(),SysRoleRightRespDTO.class);
        //将数据库里的json字符串转换成list对象
        List<SysRoleRightRespDTO> sysRoleRightRespDTOListFromDb=JSONArray.parseArray(sysRoleModel.getDO().getRoleRights(),SysRoleRightRespDTO.class);
        HashMap<String,SysRoleRightRespDTO> map=new HashMap<>();
        //循环l前端list对象，并将其放入map集合里
        for (SysRoleRightRespDTO sysRoleRightRespDTOReq:sysRoleRightsRespDTOSFromReq){
            map.put(sysRoleRightRespDTOReq.getClId(),sysRoleRightRespDTOReq);
        }
        //循环数据库里的list对象,并通过前端传过来的值来获取数据库里的值，如果有，则将前端设置的func替换数据库里的func
        for (SysRoleRightRespDTO sysRoleRightRespDTO:sysRoleRightRespDTOListFromDb){
            SysRoleRightRespDTO roleRightRespDTOFromReq=map.get(sysRoleRightRespDTO.getClId());
            if (roleRightRespDTOFromReq!=null){
                sysRoleRightRespDTO.setFunc(roleRightRespDTOFromReq.getFunc());
            }
        }
        sysRoleManageBO.setRoleRights(JSON.toJSONString(sysRoleRightRespDTOListFromDb));
        Integer updateRoleInfo = sysRoleService.editSysRoleManageRoleInfoByRoleId(sysRoleManageBO);

        SysRoleMangeRoleUpdateRespDTO sysRoleMangeRoleUpdateRespDTO =new SysRoleMangeRoleUpdateRespDTO();
        if (updateRoleInfo == null || updateRoleInfo == 0){
            sysRoleMangeRoleUpdateRespDTO.setMessage("修改失败");
        }else{
            sysRoleMangeRoleUpdateRespDTO.setMessage("修改成功");
        }
        context.getResult().setModule(sysRoleMangeRoleUpdateRespDTO);
    }
}
