package com.ihappy.role.infrastructure.service.inside.impl;


import com.google.common.collect.Lists;
import com.ihappy.common.util.StringUtil;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.GetCompanyRoleFuncMenuBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.role.domain.bo.CheckRoleNameBO;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.role.domain.bo.QueryCompanyRolePageBO;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;
import com.ihappy.role.domain.dto.request.comp.CompanyRoleQueryReqDTO;
import com.ihappy.role.domain.dto.response.comp.CompanyRoleQueryRespDTO;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.company.BaseinfoCompanyRoleMapper;
import com.ihappy.role.infrastructure.service.CompanyRoleReadService;
import com.ihappy.role.infrastructure.service.inside.CompanyRoleService;
import com.ihappy.unifiedLog.module.Result;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.transform;

/**
 * Created by sunjd on 2018/3/31.
 */
public class CompanyRoleServiceImpl implements CompanyRoleService {
    private final static Logger logger = CompanyLoggerUtil.getLogger();

    @Autowired
    private BaseinfoCompanyRoleMapper baseinfoCompanyRoleMapper;
    @Autowired
    private CompanyRoleReadService companyRoleReadServiceClient;
    @Autowired
    private CompanyInfoService companyInfoService;

    @Override
    public List<CompanyRoleModel> findRoleListByRoleIdList(List<Long> roleIdList) {
        List<CompanyRoleModel> models = new ArrayList<CompanyRoleModel>();
        if (CollectionUtils.isEmpty(roleIdList)) {
            return new ArrayList<>();
        }
        List<BaseinfoCompanyRole> baseinfoCompanyRoles = baseinfoCompanyRoleMapper.selectByPrimaryKeyList(roleIdList);
        if (CollectionUtils.isEmpty(baseinfoCompanyRoles)) {
            return new ArrayList<>();
        }
        baseinfoCompanyRoles.forEach((obj)->{
            models.add(new CompanyRoleModel(obj));
        });
        return models;
    }

    @Override
    public List<CompanyRoleModel> findRoleListByCompIdList(List<Long> compIdList) {
        if (CollectionUtils.isEmpty(compIdList)) {
            return new ArrayList<>();
        }
        List<BaseinfoCompanyRole> baseinfoCompanyRoles = baseinfoCompanyRoleMapper.selectByCompIdList(compIdList);
        if (CollectionUtils.isEmpty(baseinfoCompanyRoles)) {
            return new ArrayList<>();
        }
        return transform(baseinfoCompanyRoles, (baseinfoCompanyRole) -> new CompanyRoleModel(baseinfoCompanyRole));
    }

    @Override
    public Integer addRoleListSameCompId(List<BaseinfoCompanyRole> baseinfoCompanyRoles) {
        Integer resCount = 0;
        for (BaseinfoCompanyRole obj : baseinfoCompanyRoles) {
            int times = CompanyConstant.ERROR_RETRY;
            Integer success = 0;
            for (; times > 0; times--) {
                try {
                    success = baseinfoCompanyRoleMapper.insertSelective(obj);
                } catch (Throwable e) {
                    logger.error(e.getMessage(), e);
                    Thread.currentThread().interrupt();
                }
                if (success != 1) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e1) {
                        logger.error(e1.getMessage(), e1);
                        Thread.currentThread().interrupt();
                    }
                } else {
                    break;
                }
            }
            resCount += success;
        }
        return resCount;
    }

//    @Override
//    public int addOneCompanyRoleByCompId(BaseinfoCompanyRole baseinfoCompanyRole) {
//        if (baseinfoCompanyRole.getRoleName() == null) {
//            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrCode(),
//                    CompanyErrorCodeEnum.COMPANY_ROLE_NAME_IS_NULL.getErrMsg());
//        }
//        return baseinfoCompanyRoleMapper.insertSelective(baseinfoCompanyRole);
//    }

    @Override
    public int addCompanyRole(BaseinfoCompanyRole baseinfoCompanyRole) {
        int n = baseinfoCompanyRoleMapper.insertSelective(baseinfoCompanyRole);
        if (n != 1) {
            throw new CompanyException(CompanyErrorCodeEnum.EXCUTE_SQL_ERROR);
        }
        return n;
    }

    @Override
    public  List<CompanyRoleModel> findRolePageByCompId(QueryCompanyRolePageBO queryCompanyRolePageBO) {
        List<CompanyRoleModel> list = new ArrayList<>();
        List<BaseinfoCompanyRole> baseinfoCompanyRoles = baseinfoCompanyRoleMapper.selectRolePageByCompId(queryCompanyRolePageBO);
        if(!CollectionUtils.isEmpty(baseinfoCompanyRoles)){
            for (BaseinfoCompanyRole baseinfoCompanyRole : baseinfoCompanyRoles) {
                if (baseinfoCompanyRole != null) {
                    list.add(new CompanyRoleModel(baseinfoCompanyRole));
                }
            }
        }
        return list;
    }


    @Override
    public CompanyRoleModel findOneRoleByCompIdAndRoleId(Map<Integer, Integer> map) {
        BaseinfoCompanyRole baseinfoCompanyRole = baseinfoCompanyRoleMapper.selectOneRoleByCompIdAndRoleId(map);
        if (baseinfoCompanyRole == null){
            return null;
        }
        return new CompanyRoleModel(baseinfoCompanyRole);
    }

    @Override
    public CompanyRoleModel checkRoleNameIsExist(CheckRoleNameBO checkRoleNameBO) {
        BaseinfoCompanyRole baseinfoCompanyRole=baseinfoCompanyRoleMapper.checkRoleNameIsExist(checkRoleNameBO);
        if(baseinfoCompanyRole == null){
            return null;
        }
        return new CompanyRoleModel(baseinfoCompanyRole);
    }

    @Override
    public CompanyRoleModel checkCompanyRoleNoIsOrNotRepeat(CompanyRoleBO companyRoleBO) {
        BaseinfoCompanyRole baseinfoCompanyRole=baseinfoCompanyRoleMapper.checkCompanyRoleNoIsOrNotRepeat(companyRoleBO);
        if(baseinfoCompanyRole == null){
            return null;
        }
        return new CompanyRoleModel(baseinfoCompanyRole);
    }

    @Override
    public CompanyRoleModel getCompanyRoleByRoleId(GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBO) {
        BaseinfoCompanyRole role=baseinfoCompanyRoleMapper.selectCompanyRoleByRoleId(getCompanyRoleFuncMenuBO);
        if (role == null){
            return null;
        }
        return new CompanyRoleModel(role);
    }

    @Override
    public int editCompanyRoleByRoleId(CompanyRoleBO companyRoleBO) {
        int oneRole = baseinfoCompanyRoleMapper.updateOneRoleInfoByRoleId(companyRoleBO);
        if (oneRole  != 1) {
            throw new CompanyException(CompanyErrorCodeEnum.EXCUTE_SQL_ERROR);
        }
        return oneRole;
    }

    @Override
    public Integer removeCompanyRoleByRoleId(CompanyRoleBO companyRoleBO) {
        Integer oneRole = baseinfoCompanyRoleMapper.deleteCompanyRoleByRoleId(companyRoleBO);
        return oneRole;
    }

    @Override
    public List<CompanyRoleModel> findCompRoleByCondition(QueryCompanyRolePageBO queryCompanyRolePageBO) {
        List<BaseinfoCompanyRole> roleList =  baseinfoCompanyRoleMapper.selectCompRoleByCondition(queryCompanyRolePageBO);
        List<CompanyRoleModel> companyRoleModelList=new ArrayList<>();
        for (BaseinfoCompanyRole baseinfoCompanyRole:roleList){
            companyRoleModelList.add(new CompanyRoleModel(baseinfoCompanyRole));
        }
        return companyRoleModelList;
    }

    @Override
    public CompanyRoleEnum findCompanyRoleInfoByPersonInfo(BaseinfoPersonCompanyOrgRespDTO baseinfoPersonCompanyOrgRespDTO, long compId) {
        final String compRoleIds = baseinfoPersonCompanyOrgRespDTO.getCompRoleIds();
        final long personId = baseinfoPersonCompanyOrgRespDTO.getPersonId();
        //判断是否是老板
        CompanyInfoByCompIdQuery companyInfoByCompIdQuery = new CompanyInfoByCompIdQuery();
        companyInfoByCompIdQuery.setCompId(Long.valueOf(compId).intValue());
        CompanyModel companyInfo = companyInfoService.selectCompanyInfo(companyInfoByCompIdQuery);
        if (companyInfo == null) {//判断公司是否存在
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_IS_EMPTY);
        }
        BaseinfoCompany baseinfoCompany = companyInfo.getDO();
        if (personId == baseinfoCompany.getAdminPersonId()) {
           return CompanyRoleEnum.BOSS;
        }
        //除老板外的其他角色
        if (!StringUtil.isBlank(compRoleIds)) {
            CompanyRoleQueryReqDTO companyRoleQueryReqDTO = new CompanyRoleQueryReqDTO();
            companyRoleQueryReqDTO.setRoleIds(Lists.newArrayList(Long.parseLong(compRoleIds)));
            Result<List<CompanyRoleQueryRespDTO>> result =companyRoleReadServiceClient.findRoleListByRoleIdList(companyRoleQueryReqDTO);
            boolean isSuccess = result != null && result.isSuccess() && result.getModule() != null && result.getModule().size() == 1;
            if (isSuccess) {
                CompanyRoleQueryRespDTO companyRoleQueryRespDTO = result.getModule().get(0);
                return CompanyRoleEnum.getEnumByKey(Integer.valueOf(companyRoleQueryRespDTO.getRoleNo()));
            }
        }
        return null;
    }
}
