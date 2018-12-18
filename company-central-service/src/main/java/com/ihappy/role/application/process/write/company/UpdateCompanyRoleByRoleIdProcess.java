package com.ihappy.role.application.process.write.company;

import com.alibaba.fastjson.JSON;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.role.common.enumtype.RoleErrorCodeEnum;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleUpdateReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleRight;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleUpdateRespDTO;
import com.ihappy.role.domain.model.factory.company.CompanyRoleFactory;
import com.ihappy.role.domain.model.factory.sys.SysCompanyRoleFactory;
import com.ihappy.role.domain.model.model.sys.SysCompanyRoleModel;
import com.ihappy.role.exception.RoleException;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.company.BaseinfoCompanyRoleMapper;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.role.infrastructure.service.inside.SysCompanyRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by zhangmengdan
 * APP-管理-角色管理-角色修改process
 */
public class UpdateCompanyRoleByRoleIdProcess extends DefaultProcess<CompanyRoleUpdateReqDTO, CompanyRoleUpdateRespDTO> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private BaseinfoCompanyRoleMapper baseinfoCompanyRoleMapper;
    @Autowired
    private SysCompanyRoleService sysCompanyRoleService;
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public void process(Context<CompanyRoleUpdateReqDTO, CompanyRoleUpdateRespDTO> context) {
        CompanyRoleUpdateReqDTO companyRoleUpdateReqDTO = context.getParam();
        //公司信息
        CompanyModel companyModel = companyInfoService.selectCompanyInfo(CompanyRoleFactory.companyRoleUpdateReqDTOToCompanyInfoByCompIdQuery(companyRoleUpdateReqDTO));
        if (companyModel == null) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
        //查询系统角色详情
        SysCompanyRoleModel sysCompanyRoleInfo = sysCompanyRoleService.finsSysCompanyRoleInfo(SysCompanyRoleFactory.companyRoleUpdateReqDTOToSysCompanyRoleBO(companyRoleUpdateReqDTO));
        if (sysCompanyRoleInfo != null) {
            throw new CompanyException(RoleErrorCodeEnum.SYS_ROLE_NOT_CAN_UPDATE.getErrCode(),
                    RoleErrorCodeEnum.SYS_ROLE_NOT_CAN_UPDATE.getErrMsg());
        }
        //查询公司角色详情
        BaseinfoCompanyRole companyRole = baseinfoCompanyRoleMapper.selectCompanyRoleByRoleId(CompanyRoleFactory.companyRoleUpdateReqDTOToGetCompanyRoleFuncMenuBO(companyRoleUpdateReqDTO));
        if (companyRole == null) {
            throw new CompanyException(RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrCode(),
                    RoleErrorCodeEnum.ROLE_NOT_EXISTS.getErrMsg());
        }
        //系统默认角色不能修改
        if (companyRole.getIsDefault() == 1) {
            throw new CompanyException(RoleErrorCodeEnum.SYSTEM_ROLE_NAME_IS_CAN_NOT_UPDATE.getErrCode(),
                    RoleErrorCodeEnum.SYSTEM_ROLE_NAME_IS_CAN_NOT_UPDATE.getErrMsg());
        }

        //判断角色名称是否重复
        BaseinfoCompanyRole role = baseinfoCompanyRoleMapper.checkRoleNameIsExist(CompanyRoleFactory.companyRoleUpdateReqDTOToCheckRoleNameBO(companyRoleUpdateReqDTO));
        if (role != null) {
            throw new CompanyException(RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_REPEAT.getErrCode(),
                    RoleErrorCodeEnum.COMPANY_ROLE_NAME_IS_REPEAT.getErrMsg());
        }
        CompanyRoleBO companyRoleBO = CompanyRoleFactory.companyRoleUpdateReqDTOModel(companyRoleUpdateReqDTO);
        //json数组对象转化成list对象
        //将前端传过来的Jason对象转换成list对象
        List<CompanyRoleRight> compRoleRightsFromReq = JSON.parseArray(companyRoleUpdateReqDTO.getRoleRights(),
                CompanyRoleRight.class);
        //将数据库里的Jason对象转换成list对象
        List<CompanyRoleRight> compRoleRightsFromDb = JSON.parseArray(companyRole.getRoleRights(),
                CompanyRoleRight.class);

//        Map<String, CompanyRoleRight> ctldClidCompanyRoleRightMap = compRoleRightsFromReq.stream()
//                .collect(Collectors.toMap(companyRoleRight -> companyRoleRight.getCtId() + "_" + companyRoleRight.getClId(),
//                        companyRoleRight -> companyRoleRight));
//list对象转换成map对象
        Map<String, CompanyRoleRight> ctldClidCompanyRoleRightMap = new HashMap<>();
        //循环前端list对象
        for (CompanyRoleRight companyRoleRight : compRoleRightsFromReq) {
            if(StringUtil.isBlank(companyRoleRight.getFunc())){
                throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                        RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
            }
            if(StringUtil.isBlank(companyRoleRight.getCtId())){
                throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                        RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
            }
            if(StringUtil.isBlank(companyRoleRight.getClId())){
                throw new RoleException(RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrCode(),
                        RoleErrorCodeEnum.ROLE_RIGHTS_IS_JSON_ARRAY.getErrMsg());
            }
            //将参数和对象放入map里
            ctldClidCompanyRoleRightMap.put(companyRoleRight.getCtId() + "_" + companyRoleRight.getClId(), companyRoleRight);
        }
//循环数据库list对象
        for (CompanyRoleRight companyRoleRight : compRoleRightsFromDb) {
            //通过前端传入的对象获取数据库里的对应的数据
            CompanyRoleRight companyRoleRightReq = ctldClidCompanyRoleRightMap.get(companyRoleRight.getCtId() +
                    "_" + companyRoleRight.getClId());
            //如果有
            if (companyRoleRightReq != null) {
                //则将前端的func对象放入数据库func里
                companyRoleRight.setFunc(companyRoleRightReq.getFunc());
            }
        }
//        compRoleRightsFromDb.forEach(companyRoleRight -> {
//            CompanyRoleRight companyRoleRightReq = ctldClidCompanyRoleRightMap.get(companyRoleRight.getCtId() +
//                    "_" + companyRoleRight.getClId());
//            if (companyRoleRightReq != null) {
//                companyRoleRight.setFunc(companyRoleRightReq.getFunc());
//            }
//        });
//将根据前端传入的数据修改的func设置成数据库里的角色权限，并将转换成json字符串形式
        companyRoleBO.setRoleRights(JSON.toJSONString(compRoleRightsFromDb));
        int updateRole = companyRoleService.editCompanyRoleByRoleId(companyRoleBO);

        CompanyRoleUpdateRespDTO companyRoleUpdateRespDTO = new CompanyRoleUpdateRespDTO();
        if (updateRole > 0) {
            companyRoleUpdateRespDTO.setMessage("修改成功");
        }
        context.getResult().setModule(companyRoleUpdateRespDTO);
        return;
    }

}

