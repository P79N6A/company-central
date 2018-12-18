package com.ihappy.role.application.process.query.company;

import com.google.common.collect.Lists;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.config.common.ConfigCenterUtil;
import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.role.domain.dto.request.comp.AppRoleListQueryByDiffPowerReqDTO;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleListQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.AppRoleListQueryByDiffPowerRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleListQueryListRespDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleListQueryRespDTO;
import com.ihappy.role.infrastructure.service.CompanyRoleReadService;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.common.util.SysAndPersonRedisUtil;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/24 12:23
 * *@content根据不同的权限查询角色列表
 **/
public class FindAppRoleListByDiffPowerProcess extends DefaultQueryProcess<AppRoleListQueryByDiffPowerReqDTO,
        List<AppRoleListQueryByDiffPowerRespDTO>> {
    @Autowired
    private CompanyRoleService companyRoleService;
    @Autowired
    private CompanyRoleReadService companyRoleReadServiceClient;

    @Override
    public void process(Context<AppRoleListQueryByDiffPowerReqDTO, List<AppRoleListQueryByDiffPowerRespDTO>> context) {
        AppRoleListQueryByDiffPowerReqDTO reqDTO = context.getParam();
        long compId = reqDTO.getLoginCompId();
        long personId = reqDTO.getLoginPersonId();

        //通过redis获取用户信息，通过公司id和登录人
        BaseinfoPersonCompanyOrgRespDTO personInfo =
                SysAndPersonRedisUtil.getUserInfoByComIdAndPersonIdKey(compId, personId, ConfigCenterUtil.ENV);
        if (personInfo == null) {//判断用户是否存在
            throw new CompanyException(CompanyErrorCodeEnum.
                    GET_USER_INFO_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.GET_USER_INFO_ERROR.getErrMsg());
        }
        // 根据公司信息的admin_person_id判断是不是老板
        // 根据用户信息里的roleIds判断其他角色（比如说合伙人，店长，店员）
        CompanyRoleListQueryReqDTO companyRoleListQueryReqDTO = new CompanyRoleListQueryReqDTO();
        companyRoleListQueryReqDTO.setLoginCompId(compId);
        companyRoleListQueryReqDTO.setLoginPersonId(personId);
        Result<CompanyRoleListQueryRespDTO> respDTOResult =
                companyRoleReadServiceClient.findRoleListByCompId(companyRoleListQueryReqDTO);
        if (respDTOResult == null || !respDTOResult.isSuccess()) {
            context.getResult().setModule(Lists.newArrayList());
        }
        List<CompanyRoleListQueryListRespDTO> listQueryListRespDTOS = respDTOResult.getModule().getList();
        if (listQueryListRespDTOS == null || listQueryListRespDTOS.size() == 0) {
            context.getResult().setModule(Lists.newArrayList());
        }
        CompanyRoleEnum companyRoleEnum = companyRoleService.findCompanyRoleInfoByPersonInfo(personInfo, compId);
        if (companyRoleEnum == null) {
            throw new CompanyException(CompanyErrorCodeEnum.GET_USER_INFO_ERROR);
        }
        if (!companyRoleEnum.isBOSSorPARTNER()) {
            listQueryListRespDTOS = listQueryListRespDTOS.stream().filter(x -> x.getRoleNo() != null && !CompanyRoleEnum.isPartner(
                    Integer.valueOf(x.getRoleNo()))).collect(Collectors.toList());
        }

        List<AppRoleListQueryByDiffPowerRespDTO> listQueryByDiffPowerRespDTOS =
                listQueryListRespDTOS.stream().map(x -> {
            AppRoleListQueryByDiffPowerRespDTO appRoleListQueryByDiffPowerRespDTO =
                    new AppRoleListQueryByDiffPowerRespDTO();
            appRoleListQueryByDiffPowerRespDTO.setRoleNo(x.getRoleNo());
            appRoleListQueryByDiffPowerRespDTO.setIsHide(x.getIsHide());
            appRoleListQueryByDiffPowerRespDTO.setRoleId(x.getRoleId());
            appRoleListQueryByDiffPowerRespDTO.setRoleName(x.getRoleName());
            return appRoleListQueryByDiffPowerRespDTO;
        }).collect(Collectors.toList());


        context.getResult().setModule(listQueryByDiffPowerRespDTOS);
    }
}
