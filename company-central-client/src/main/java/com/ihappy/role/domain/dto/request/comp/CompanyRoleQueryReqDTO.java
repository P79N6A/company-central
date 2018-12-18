package com.ihappy.role.domain.dto.request.comp;

import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.exception.RoleException;
import com.ihappy.gateway.dto.ICallRequestBaseQuery;
import com.ihappy.role.common.constans.RoleConstans;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据roleId查询
 * Created by sunjd on 2018/3/31.
 */
public class CompanyRoleQueryReqDTO extends ICallRequestBaseQuery {
    private static final long serialVersionUID = -5051890984098401827L;
    /**
     * 权限id list
     */
    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public void validation() {
        if (roleIds == null || roleIds.size() == 0) {
            throw new RoleException(RoleErrorCodeEnum.
                    ROLE_ID_IS_NULL_ERROR.getErrCode(),
                    RoleErrorCodeEnum.ROLE_ID_IS_NULL_ERROR.getErrMsg());
        }
    }

    /**
     * id < 10000 认为是系统角色
     * @return
     */
    public List<Long> sysRoleIdList(){
        List<Long> sysRoleIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleIds)){
            roleIds.forEach((obj)->{
                if (obj <= RoleConstans.MAX_SYS_ROLE_ID){
                    sysRoleIdList.add(obj);
                }
            });
        }
        return sysRoleIdList;
    }
    public List<Long> companyRoleIdList(){
        List<Long> companyRoleIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleIds)){
            roleIds.forEach((obj)->{
                if (obj > RoleConstans.MAX_SYS_ROLE_ID){
                    companyRoleIdList.add(obj);
                }
            });
        }
        return companyRoleIdList;
    }
}
