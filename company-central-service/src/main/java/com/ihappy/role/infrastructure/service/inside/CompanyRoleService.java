package com.ihappy.role.infrastructure.service.inside;

import com.ihappy.role.common.enumtype.CompanyRoleEnum;
import com.ihappy.role.domain.bo.CheckRoleNameBO;
import com.ihappy.role.domain.bo.CompanyRoleBO;
import com.ihappy.company.domain.bo.GetCompanyRoleFuncMenuBO;
import com.ihappy.role.domain.bo.QueryCompanyRolePageBO;
import com.ihappy.role.domain.dbdo.company.BaseinfoCompanyRole;
import com.ihappy.role.domain.model.model.company.CompanyRoleModel;
import com.ihappy.user.domain.dto.response.person.BaseinfoPersonCompanyOrgRespDTO;
import reactor.util.annotation.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/3/31.
 */
public interface CompanyRoleService {
    List<CompanyRoleModel> findRoleListByRoleIdList(List<Long> roleIdList);

    /**
     * 根据企业id列表查询
     * @param compIdList
     * @return
     */
    List<CompanyRoleModel> findRoleListByCompIdList(List<Long> compIdList);

    Integer addRoleListSameCompId(List<BaseinfoCompanyRole> baseinfoCompanyRoles);

//    /**
//     * 添加公司角色
//     * @param baseinfoCompanyRole
//     * @return
//     */
//    int addOneCompanyRoleByCompId(BaseinfoCompanyRole baseinfoCompanyRole);

    /**
     * app-管理-角色权限-添加角色
     * @param baseinfoCompanyRole
     * @return
     */
    int addCompanyRole(BaseinfoCompanyRole baseinfoCompanyRole);

    /**
     * 根据企业id查询角色信息列表
     * @param queryCompanyRolePageBO
     * @return
     */
     List<CompanyRoleModel> findRolePageByCompId(QueryCompanyRolePageBO queryCompanyRolePageBO);

    /**
     * 通过公司id和角色id查询角色信息
     * @param map
     * @return
     */
    CompanyRoleModel findOneRoleByCompIdAndRoleId(Map<Integer,Integer> map);

    /**
     * 通过公司id和角色名称查看角色信息
     * @param checkRoleNameBO
     * @return
     */
    CompanyRoleModel checkRoleNameIsExist(CheckRoleNameBO checkRoleNameBO);
    /**
     * 通过公司id和角色no查看角色信息
     * @param companyRoleBO
     * @return
     */
    CompanyRoleModel  checkCompanyRoleNoIsOrNotRepeat(CompanyRoleBO companyRoleBO);

    /**
     * 根据角色ID和角色权限获取功能菜单
     * @return
     */
    CompanyRoleModel getCompanyRoleByRoleId(GetCompanyRoleFuncMenuBO getCompanyRoleFuncMenuBO);
    /**
     * 根据角色id修改角色信息
     * @param companyRoleBO
     * @return
     */
    int editCompanyRoleByRoleId(CompanyRoleBO companyRoleBO);

    /**
     * 根据角色id删除角色信息
     * @param companyRoleBO
     * @return
     */
    Integer removeCompanyRoleByRoleId(CompanyRoleBO companyRoleBO);
    /**
     * 根据权限查询不同的角色列表
     * @param queryCompanyRolePageBO
     * @return
     */
    List<CompanyRoleModel> findCompRoleByCondition(QueryCompanyRolePageBO queryCompanyRolePageBO);


    /**
     * 获取角色信息
      * @param baseinfoPersonCompanyOrgRespDTO
     * @param compId
     * @return
     */
    @Nullable  CompanyRoleEnum findCompanyRoleInfoByPersonInfo(BaseinfoPersonCompanyOrgRespDTO baseinfoPersonCompanyOrgRespDTO, long compId);


}
