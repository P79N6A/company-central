package com.ihappy.role.infrastructure.service.inside.impl;

import com.ihappy.role.domain.bo.*;
import com.ihappy.role.domain.dbdo.sys.SysCompanyFunc;
import com.ihappy.role.domain.model.model.sys.SysCompanyFuncModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysCompanyFuncMapper;
import com.ihappy.role.infrastructure.service.inside.SysCompanyFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

public class SysCompanyFuncServiceImpl implements SysCompanyFuncService {
    @Autowired
    private SysCompanyFuncMapper sysCompanyFuncMapper;
    @Override
    public List<SysCompanyFuncModel> selectSysCompanyFunctListByCtId(SysCompanyFuncByCtIdQuery sysCompanyFuncByCtIdQuery) {
        List<SysCompanyFunc> result = sysCompanyFuncMapper.selecSysCompanyFunctListByCtId(sysCompanyFuncByCtIdQuery);
        return transform(result, (obj) -> new SysCompanyFuncModel(obj));
    }
    @Override
    public List<SysCompanyFuncModel> findSysCompanyRoleConfigRoleInfoTypeMenu(SysCompanyRoleConfigRoleInfoTypeMenuBO sysCompanyRoleConfigRoleInfoTypeMenuBO) {
        List<SysCompanyFuncModel> list = new ArrayList<>();
        List<SysCompanyFunc> menu = sysCompanyFuncMapper.selectSysCompanyRoleConfigRoleInfoTypeMenu(sysCompanyRoleConfigRoleInfoTypeMenuBO);
        if (!CollectionUtils.isEmpty(menu)) {
            for (SysCompanyFunc sysCompanyFunc : menu) {
                if (sysCompanyFunc != null) {
                    list.add(new SysCompanyFuncModel(sysCompanyFunc));
                }
            }
        }
        return list;
    }
    @Override
    public SysCompanyFuncModel findSysCompanyFuncByCtFuncId(SysCompanyFuncBO sysCompanyFuncBO) {
        SysCompanyFunc menu = sysCompanyFuncMapper.findSysCompanyFuncByCtFuncId(sysCompanyFuncBO);
        if (menu == null) {
            return null;
        }
        return new SysCompanyFuncModel(menu);
    }

    @Override
    public List<SysCompanyFuncModel> findCompanyRoleMenuList(CompanyRoleMenuBO companyRoleMenuBO) {
        List<SysCompanyFuncModel> list = new ArrayList<>();
        List<SysCompanyFunc> menuList = sysCompanyFuncMapper.selectCompanyRoleMenuList(companyRoleMenuBO);
        for (SysCompanyFunc sysCompanyFunc : menuList) {
            if (sysCompanyFunc != null) {
                list.add(new SysCompanyFuncModel(sysCompanyFunc));
            }
        }
        return list;
    }

    @Override
    public List<SysCompanyFuncModel> findCompanyRoleAddRoleMenuList(CompanyRoleAddRoleMenuBO companyRoleAddRoleMenuBO) {
        List<SysCompanyFuncModel> list = new ArrayList<>();
        List<SysCompanyFunc> sysCompanyFuncList = sysCompanyFuncMapper.selectCompanyRoleAddRoleMenuList(companyRoleAddRoleMenuBO);
        for (SysCompanyFunc sysCompanyFunc : sysCompanyFuncList) {
            if (sysCompanyFunc != null) {
                list.add(new SysCompanyFuncModel(sysCompanyFunc));
            }
        }
        return list;
    }

    @Override
    public List<SysCompanyFuncModel> findSysCompanyFuncListByctIdclId(SysCompanyFuncBO sysCompanyFuncBO) {
        List<SysCompanyFuncModel> sysCompanyFuncModelsList = new ArrayList<>();
        List<SysCompanyFunc> sysCompanyFuncsList = sysCompanyFuncMapper.selectSysCompanyFuncListByctIdclId(sysCompanyFuncBO);
        for (SysCompanyFunc sysCompanyFunc : sysCompanyFuncsList) {
            if (sysCompanyFunc != null) {
                sysCompanyFuncModelsList.add(new SysCompanyFuncModel(sysCompanyFunc));
            }
        }
        return sysCompanyFuncModelsList;
    }

    @Override
    public List<SysCompanyFuncModel> findSysCompanyFuncList(SysCompanyFuncBO sysCompanyFuncBO) {
        List<SysCompanyFuncModel> sysCompanyFuncModelList = new ArrayList<>();
        List<SysCompanyFunc> sysCompanyFuncList = sysCompanyFuncMapper.selectSysCompanyFuncList(sysCompanyFuncBO);
        for (SysCompanyFunc sysCompanyFunc : sysCompanyFuncList) {
            if (sysCompanyFunc != null) {
                sysCompanyFuncModelList.add(new SysCompanyFuncModel(sysCompanyFunc));
            }
        }
        return sysCompanyFuncModelList;
    }

    @Override
    public List<SysCompanyFuncModel> selectSysCompanyFuncMenuApplyTypeMenuList(SysCompanyFuncBO sysCompanyFuncBO) {
        List<SysCompanyFuncModel> sysCompanyFuncModelList = new ArrayList<>();
        List<SysCompanyFunc> sysCompanyFuncList = sysCompanyFuncMapper.selectSysCompanyFuncMenuApplyTypeMenuList(sysCompanyFuncBO);
        for (SysCompanyFunc sysCompanyFunc : sysCompanyFuncList) {
            if (sysCompanyFunc != null) {
                sysCompanyFuncModelList.add(new SysCompanyFuncModel(sysCompanyFunc));
            }
        }
        return sysCompanyFuncModelList;
    }

    @Override
    public int selectSysCompanyFuncMenuApplyTypeMenuListCount(SysCompanyFuncBO sysCompanyFuncBO) {
        int total = sysCompanyFuncMapper.selectSysCompanyFuncMenuApplyTypeMenuListCount(sysCompanyFuncBO);
        return total;
    }

    @Override
    public int addSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO) {
        int menu=sysCompanyFuncMapper.insertSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncBO);
        return menu;
    }

    @Override
    public int editSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO) {
        int updateMenu=sysCompanyFuncMapper.updateSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncBO);
        return updateMenu;
    }

    @Override
    public List<SysCompanyFuncModel> checkMenuNameIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO) {
        List<SysCompanyFuncModel> sysCompanyFuncModelList=new ArrayList<>();
        List<SysCompanyFunc> checkMenuName=sysCompanyFuncMapper.checkMenuNameIsOrNotRepeat(sysCompanyFuncBO);
        for (SysCompanyFunc sysCompanyFunc:checkMenuName){
            sysCompanyFuncModelList.add(new SysCompanyFuncModel(sysCompanyFunc));
        }
        return sysCompanyFuncModelList;
    }

    @Override
    public List<SysCompanyFuncModel> checkMenuNoIsOrNotRepeat(SysCompanyFuncBO sysCompanyFuncBO) {
        List<SysCompanyFuncModel> sysCompanyFuncModelList=new ArrayList<>();
        List<SysCompanyFunc> checkMenuName=sysCompanyFuncMapper.checkMenuNoIsOrNotRepeat(sysCompanyFuncBO);
        for (SysCompanyFunc sysCompanyFunc:checkMenuName){
            sysCompanyFuncModelList.add(new SysCompanyFuncModel(sysCompanyFunc));
        }
        return sysCompanyFuncModelList;
    }

    @Override
    public int removeSysCompanyFuncMenuApplyTypeMenu(SysCompanyFuncBO sysCompanyFuncBO) {
        int delMenu=sysCompanyFuncMapper.delSysCompanyFuncMenuApplyTypeMenu(sysCompanyFuncBO);
        return delMenu;
    }

}
