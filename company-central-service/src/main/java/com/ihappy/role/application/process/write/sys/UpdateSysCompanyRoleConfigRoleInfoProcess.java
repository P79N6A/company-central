package com.ihappy.role.application.process.write.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.common.util.RolePrivilegeRedisUtil;
import com.ihappy.role.domain.bo.SysCompanyRoleConfigBO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleConfigRoleInfoUpdateReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleConfigRoleInfoUpdateRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleRightRespDTO;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * created by zhangmengdan
 * 运营后台-平台设定-角色配置-角色修改process
 */
public class UpdateSysCompanyRoleConfigRoleInfoProcess extends DefaultProcess<SysCompanyRoleConfigRoleInfoUpdateReqDTO, SysCompanyRoleConfigRoleInfoUpdateRespDTO> {
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;

    @Override
    public void process(Context<SysCompanyRoleConfigRoleInfoUpdateReqDTO, SysCompanyRoleConfigRoleInfoUpdateRespDTO> context) {
        SysCompanyRoleConfigRoleInfoUpdateReqDTO sysCompanyRoleConfigRoleInfoUpdateReqDTO = context.getParam();
//查询角色信息
        SysCompanyRoleModel role = sysCompanyRoleService.findSysCompanyRoleConfigRoleInfoByRoleId(SysCompanyRoleFactory.sysCompanyRoleConfigRoleInfoUpdateReqDTOTOModel(sysCompanyRoleConfigRoleInfoUpdateReqDTO));
        //角色是否为空
        if (role == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //角色是否被删除
        if (role.getDO().getIsDeleted() == true) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_IS_DELETED.getErrCode(),
                    RoleErrorCodeEnum.ROLE_IS_DELETED.getErrMsg());
        }
        //检查系统公司角色名称是否重复
        SysCompanyRoleModel checkSysCompanyRoleNameIsOrNotExisit = sysCompanyRoleService.checkSysCompanyRoleNameIsOrNotExisit(SysCompanyRoleFactory.sysCompanyRoleConfigRoleInfoUpdateReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleInfoUpdateReqDTO));
        if (checkSysCompanyRoleNameIsOrNotExisit != null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NAME_IS_REPEAT.getErrMsg());
        }
        SysCompanyRoleConfigBO sysCompanyRoleConfigBO = SysCompanyRoleFactory.sysCompanyRoleConfigRoleInfoUpdateReqDTOToSysCompanyRoleConfigBO(sysCompanyRoleConfigRoleInfoUpdateReqDTO);

        //将前端传入的json字符串数组转换成list对象
        List<SysCompanyRoleRightRespDTO> sysCompanyRoleRightFromReq = JSONArray.parseArray(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleRights(), SysCompanyRoleRightRespDTO.class);
        //将数据库里的json字符串数组转换成list对象
        List<SysCompanyRoleRightRespDTO> sysCompanyRoleRightFromDb = JSONArray.parseArray(role.getDO().getRoleRights(), SysCompanyRoleRightRespDTO.class);
        //将list对象转换成map对象
        Map<String, SysCompanyRoleRightRespDTO> map = new HashMap<>();
        //循环前端list对象，将参数和对象放入map
        for (SysCompanyRoleRightRespDTO sysCompanyRoleRightRespDTO : sysCompanyRoleRightFromReq) {
            map.put(sysCompanyRoleRightRespDTO.getCtId() + "_" + sysCompanyRoleRightRespDTO.getClId(), sysCompanyRoleRightRespDTO);
        }
        //循环数据库list对象，并通过前端传入的参数来获取数据库里的func
        for (SysCompanyRoleRightRespDTO sysCompanyRoleRightRespDTO : sysCompanyRoleRightFromDb) {
            SysCompanyRoleRightRespDTO sysCompanyRoleRightReq = map.get(sysCompanyRoleRightRespDTO.getCtId() + "_" + sysCompanyRoleRightRespDTO.getClId());
            //如果存在
            if (sysCompanyRoleRightReq != null) {
                sysCompanyRoleRightRespDTO.setFunc(sysCompanyRoleRightReq.getFunc());
            }
        }
        sysCompanyRoleConfigBO.setRoleRights(JSON.toJSONString(sysCompanyRoleRightFromDb));
        Integer updateSysCompanyRole = sysCompanyRoleService.editSysCompanyRoleConfigRoleInfoByRoleId(sysCompanyRoleConfigBO);
        SysCompanyRoleConfigRoleInfoUpdateRespDTO sysCompanyRoleConfigRoleInfoUpdateRespDTO = new SysCompanyRoleConfigRoleInfoUpdateRespDTO();
        if (updateSysCompanyRole > 0) {
            sysCompanyRoleConfigRoleInfoUpdateRespDTO.setMessage("修改成功");
        }
        RolePrivilegeRedisUtil.delSysCompanyRole(ConfigCenterUtil.ENV, String.valueOf(sysCompanyRoleConfigRoleInfoUpdateReqDTO.getRoleId()));
        context.getResult().setModule(sysCompanyRoleConfigRoleInfoUpdateRespDTO);
    }
}
