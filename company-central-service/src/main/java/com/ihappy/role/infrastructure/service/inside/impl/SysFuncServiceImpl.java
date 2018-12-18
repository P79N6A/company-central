package com.ihappy.role.infrastructure.service.inside.impl;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.role.domain.bo.SysFuncBO;
import com.ihappy.role.domain.bo.SysFuncByClIdBO;
import com.ihappy.role.domain.bo.SysFuncListBO;
import com.ihappy.role.domain.dbdo.sys.SysFunc;
import com.ihappy.role.domain.model.model.sys.SysFuncModel;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysFuncMapper;
import com.ihappy.role.infrastructure.service.inside.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SysFuncServiceImpl implements SysFuncService {

    @Autowired
    private SysFuncMapper sysFuncMapper;

    @Override
    public List<SysFuncModel> selectSysFuncByList(SysFuncByClIdBO sysFuncByClIdBO) {
        List<SysFunc> sysFuncList = sysFuncMapper.selectSysFuncByList(sysFuncByClIdBO);
        if (CollectionUtil.isEmpty(sysFuncList)) {
            return new ArrayList<>();
        }
        return transform(sysFuncList, (sysFunc) -> new SysFuncModel(sysFunc));
    }

    @Override
    public List<SysFuncModel> querySysFuncMenuBackstageMenuList(SysFuncListBO sysFuncListBO) {
        List<SysFuncModel> sysFuncModelList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sysFuncModelList) || sysFuncModelList.size() > 0) {
            return new ArrayList<>();
        }
        List<SysFunc> sysFuncList = sysFuncMapper.selectSysFuncMenuBackstageMenuList(sysFuncListBO);
        if (!CollectionUtils.isEmpty(sysFuncList) || sysFuncList.size() > 0) {
            for (SysFunc sysFunc : sysFuncList) {
                if (sysFunc != null) {
                    sysFuncModelList.add(new SysFuncModel(sysFunc));
                }
            }

        }
        return sysFuncModelList;
    }

    @Override
    public int removeSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO) {
        int delMenu = sysFuncMapper.deleteSysFuncMenuBackstageMenu(sysFuncBO);
        return delMenu;
    }

    @Override
    public int addSysFuncMenuBackstageMenu(SysFuncBO sysFuncBO) {
        int addMenu = sysFuncMapper.addSysFuncMenuBackstageMenu(sysFuncBO);
        return addMenu;
    }

    @Override
    public SysFuncModel findSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO) {
        SysFunc findMenuInfo = sysFuncMapper.selectSysFuncMenuBackstageMenuInfo(sysFuncBO);
        if (findMenuInfo == null) {
            return null;
        }
        return new SysFuncModel(findMenuInfo);
    }

    @Override
    public int editSysFuncMenuBackstageMenuInfo(SysFuncBO sysFuncBO) {
        int updateMenu = sysFuncMapper.updateSysFuncMenuBackstageMenuInfo(sysFuncBO);
        return updateMenu;
    }

    @Override
    public List<SysFuncModel> checkMenuNameIsOrNotRepeat(SysFuncBO sysFuncBO) {
        List<SysFuncModel> list = new ArrayList<>();
        List<SysFunc> menuName = sysFuncMapper.checkMenuNameIsOrNotRepeat(sysFuncBO);
        for (SysFunc sysFunc : menuName) {
            list.add(new SysFuncModel(sysFunc));
        }
        return list;
    }

    @Override
    public List<SysFuncModel> checkMenuNoIsOrNotRepeat(SysFuncBO sysFuncBO) {
        List<SysFuncModel> list = new ArrayList<>();
        List<SysFunc> menuNo = sysFuncMapper.checkMenuNoIsOrNotRepeat(sysFuncBO);
        for (SysFunc sysFunc : menuNo) {
            list.add(new SysFuncModel(sysFunc));
        }
        return list;
    }
}
