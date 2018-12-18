package com.ihappy.role.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ihappy.common.util.StringUtil;
import com.ihappy.role.domain.dto.request.sys.SysCompanyFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysCompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.request.sys.SysFuncListQueryReqDTO;
import com.ihappy.role.domain.dto.response.sys.SysCompanyRoleQueryRespDTO;
import com.ihappy.role.domain.dto.response.sys.SysRoleRightsRespDTO;
import com.ihappy.role.domain.dto.response.PrivilegeAllRespDTO;
import com.ihappy.company.infrastructure.service.CompanyRedisServiceRpcService;
import com.ihappy.myredis.MyRedis;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuhc on 2018/6/4.
 */
public class RolePrivilegeRedisUtil {

    private static MyRedis myRedis;

    private static CompanyRedisServiceRpcService companyRedisServiceRpcService;

    /**
     * 过期时间
     */
    private static Long seconds = 2 * 24 * 3600L;

    public void setMyRedis(MyRedis myRedis) {
        RolePrivilegeRedisUtil.myRedis = myRedis;
    }

    public void setCompanyRedisServiceRpcService(CompanyRedisServiceRpcService companyRedisServiceRpcService) {
        RolePrivilegeRedisUtil.companyRedisServiceRpcService = companyRedisServiceRpcService;
    }

    //外部用户获取所有功能菜单 php 放redis
    private final static String CT_ID_CL_ID_FUNCS = "_CT_ID_CL_ID_FUNCS_";

    // cl 端 ct 业务类型
    private static String createAllPrivKey(String env, String ctId, String clId) {
        if (!StringUtil.isBlank(clId)) {
            return env + CT_ID_CL_ID_FUNCS + ctId + "_" + clId;
        }
        return env + CT_ID_CL_ID_FUNCS + "_" + ctId;
    }
    //公司获取所有菜单
    public static List<PrivilegeAllRespDTO> getAllPriv(String env, String ctId, String clId) {
        String jsonStr = myRedis.getForStr(createAllPrivKey(env, ctId, clId));
        if (StringUtil.isBlank(jsonStr)) {
            SysCompanyFuncListQueryReqDTO sysCompanyFuncListQueryReqDTO = new SysCompanyFuncListQueryReqDTO();
            sysCompanyFuncListQueryReqDTO.setClientId(Integer.parseInt(clId));
            sysCompanyFuncListQueryReqDTO.setCtId(Integer.parseInt(ctId));
            Result<List<PrivilegeAllRespDTO>> result = companyRedisServiceRpcService.getAllPrivilegeByCtIdAndCLientIdQuery(sysCompanyFuncListQueryReqDTO);
            if (result.isSuccess() && result.getModule() != null && result.getModule().size() >= 1) {
                return result.getModule();
            }
            return null;
        }
        return JSONArray.parseArray(jsonStr, PrivilegeAllRespDTO.class);
    }

    public static void putAllPriv(String env, String ctId, String clId,List<PrivilegeAllRespDTO> result){
        myRedis.put(createAllPrivKey(env, ctId, clId),JSON.toJSONString(result),seconds);
    }

    public static void delAllPriv(String env, String ctId, String clId) {
        myRedis.delForStr(createAllPrivKey(env, ctId, clId));
    }


    //外部用户获取所有功能菜单 php 放redis
    private final static String SYS_CT_ID_FUNCS = "_HB_CL_ID_FUNCS_";

    // ct 业务类型
    private static String createSysAllPrivKey(String env, String clId) {
        return env + SYS_CT_ID_FUNCS + "_" + clId;
    }
    //运营后台获取所有菜单
    public static List<PrivilegeAllRespDTO> getAllSysPriv(String env, String clId) {
        String jsonStr = myRedis.getForStr(createSysAllPrivKey(env, clId));
        if (StringUtil.isBlank(jsonStr)) {
            SysFuncListQueryReqDTO sysFuncListQueryReqDTO = new SysFuncListQueryReqDTO();
            sysFuncListQueryReqDTO.setClientId(Integer.parseInt(clId));
            Result<List<PrivilegeAllRespDTO>> result = companyRedisServiceRpcService.getAllPrivilegeCLientIdQuery(sysFuncListQueryReqDTO);
            if (result.isSuccess() && result.getModule() != null && result.getModule().size() >= 1) {
                return result.getModule();
            }
            return null;
        }
        return JSONArray.parseArray(jsonStr, PrivilegeAllRespDTO.class);
    }

    public static void delAllSysPriv(String env, String clId) {
        myRedis.delForStr(createSysAllPrivKey(env, clId));
    }

    public static void putAllSysPriv(String env, String clId,List<PrivilegeAllRespDTO> result){
        myRedis.put(createSysAllPrivKey(env, clId),JSON.toJSONString(result),seconds);
    }

    //根据id获取系统角色
    private final static String SYS_COMPANY_ROLE = "_SYS_COMPANY_ROLE_";

    // roleId 系统角色id
    private static String createSysCompanyRoleKey(String env, String roleId) {
        return env + SYS_COMPANY_ROLE + "_" + roleId;
    }

    //系统角色
    public static SysCompanyRoleQueryRespDTO getSysCompanyRole(String env, String roleId) {
        //用户后台还是 php接口，先不从redis取数据
        //SysCompanyRoleQueryRespDTO sysRole = myRedis.get(createSysCompanyRoleKey(env, roleId),SysCompanyRoleQueryRespDTO.class);
        SysCompanyRoleQueryRespDTO sysRole = null;
        if (null == sysRole) {
            SysCompanyRoleQueryReqDTO param = new SysCompanyRoleQueryReqDTO();
            param.setRoleIds(Arrays.asList(Long.parseLong(roleId)));
            Result<List<SysCompanyRoleQueryRespDTO>> result = companyRedisServiceRpcService.getSysCompanyRoleList(param);
            if (result.isSuccess() && result.getModule() != null && result.getModule().size() >= 1) {
                return result.getModule().get(0);
            }
            return null;
        }
        return sysRole;
    }

    /**
     * 根据 业务类型/设备端 过滤RoleRight
     * @param env
     * @param roleId
     * @param ctId
     * @param clId
     * @return
     */
    public static SysCompanyRoleQueryRespDTO getSysCompanyRole(String env, String roleId,String ctId,String clId) {
        SysCompanyRoleQueryRespDTO sysRole = getSysCompanyRole(env,roleId);
        return filterByCtIdAndClId(sysRole,ctId,clId);
    }

    public static List<SysCompanyRoleQueryRespDTO> getSysCompanyRole(String env, List<Long> roleIds){
        List<SysCompanyRoleQueryRespDTO> respDTOS = new ArrayList<SysCompanyRoleQueryRespDTO>();
        for (Long roleId : roleIds){
            SysCompanyRoleQueryRespDTO respDTO = getSysCompanyRole(env,roleId.toString());
            if (respDTO != null){
                respDTOS.add(respDTO);
            }
        }
        return respDTOS;
    }

    /**
     * 根据 业务类型/设备端 过滤RoleRight
     * @param env
     * @param roleIds
     * @param ctId
     * @param clId
     * @return
     */
    public static List<SysCompanyRoleQueryRespDTO> getSysCompanyRole(String env, List<Long> roleIds,String ctId,String clId){
        List<SysCompanyRoleQueryRespDTO> respDTOS = new ArrayList<SysCompanyRoleQueryRespDTO>();
        for (Long roleId : roleIds){
            SysCompanyRoleQueryRespDTO respDTO = filterByCtIdAndClId(getSysCompanyRole(env,roleId.toString()),ctId,clId);
            if (respDTO != null){
                respDTOS.add(respDTO);
            }
        }
        return respDTOS;
    }

    public static void delSysCompanyRole(String env, String roleId) {
        myRedis.del(createSysCompanyRoleKey(env, roleId));
    }

    public static void putSysCompanyRole(String env, String roleId,SysCompanyRoleQueryRespDTO result){
        myRedis.put(createSysCompanyRoleKey(env, roleId),result,seconds);
    }

    /**
     * 根据 业务类型/设备端 过滤RoleRight，若无匹配权限，则返回null
     * @param respDTO
     * @param ctId  业务类型  null 则不判断
     * @param clId  设备端    null 则不判断
     * @return
     */
    private static SysCompanyRoleQueryRespDTO filterByCtIdAndClId(SysCompanyRoleQueryRespDTO respDTO,String ctId,String clId) {
        if (respDTO == null) {
            return null;
        }
        List<SysRoleRightsRespDTO> list = respDTO.getSysRoleRights();
        Iterator<SysRoleRightsRespDTO> iter = list.iterator();
        while (iter.hasNext()) {
            SysRoleRightsRespDTO obj = iter.next();
            if (!((ctId == null || obj.getCtId().contains(ctId)) && (clId == null || obj.getClId().contains(clId)))) {
                iter.remove();
            }
        }
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        return respDTO;
    }
}
