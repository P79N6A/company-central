package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.SysCompanyTypeBO;
import com.ihappy.company.domain.model.model.SysCompanyTypeModel;

import java.util.List;

/**
 * Created by liuhc on 2018/5/16.
 */
public interface SysCompanyTypeService {

    List<SysCompanyTypeModel> selectByCompanyTypeList();

    /**
     * 查询系统公司类型列表
     * @param sysCompanyTypeBO
     * @return
     */
    List<SysCompanyTypeModel> selectSysCompanyTypeList(SysCompanyTypeBO sysCompanyTypeBO);
    /**
     * 查询系统公司类型
     * @param sysCompanyTypeBO
     * @return
     */
    SysCompanyTypeModel   selectOneSysCompanyTypeByCtId(SysCompanyTypeBO sysCompanyTypeBO);
}
