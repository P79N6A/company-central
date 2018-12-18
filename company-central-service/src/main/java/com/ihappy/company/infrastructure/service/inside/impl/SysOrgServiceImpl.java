package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.common.util.CollectionUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.bo.SysOrgByOrgListBO;
import com.ihappy.company.domain.dbdo.SysOrg;
import com.ihappy.company.domain.model.factory.SysOrgFactory;
import com.ihappy.company.domain.model.model.SysOrgModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysOrgMapper;
import com.ihappy.company.infrastructure.service.inside.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.transform;

/**
 * Created by liuhc on 2018/6/14.
 */
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

    @Override
    public List<SysOrgModel> getSysOrgListByOrgIdList(SysOrgByOrgListBO sysOrgByOrgListBO) {
        List<SysOrg> orgList = sysOrgMapper.getSysOrgListByOrgIdList(sysOrgByOrgListBO);
        if(CollectionUtil.isEmpty(orgList)){
            return new ArrayList<SysOrgModel>();
        }
        return transform(orgList, (sysOrg) -> new SysOrgModel(sysOrg));
    }

    @Override
    public SysOrgModel getSysOrgByOrgId(SysOrg sysOrg) {
        if(sysOrg == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_IS_NULL.getErrMsg());
        }
        if (sysOrg.getOrgId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_ID_IS_NULL.getErrMsg());
        }
        SysOrg res = sysOrgMapper.selectByPrimaryKey(sysOrg.getOrgId());
        if (res == null){
            return null;
        }
        return new SysOrgModel(res);
    }

    @Override
    public List<SysOrgModel> getChildSysOrgByOrgId(SysOrg sysOrg) {
        if(sysOrg == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_IS_NULL.getErrMsg());
        }
        if (sysOrg.getOrgId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_ID_IS_NULL.getErrMsg());
        }
        List<SysOrgModel> res = new ArrayList<SysOrgModel>();

        List<SysOrg> childList = sysOrgMapper.selectChildren(sysOrg);
        for (SysOrg obj : childList){
            res.add(new SysOrgModel(obj));
        }
        return res;
    }

    @Override
    public List<SysOrgModel> getAllChildSysOrgByOrgId(List<SysOrg> sysOrgs) {
        if (CollectionUtils.isEmpty(sysOrgs)){
            return null;
        }
        List<SysOrgModel> res = new ArrayList<SysOrgModel>();
        for (SysOrg obj : sysOrgs){
            List<SysOrg> child = getChildSysOrgListByOrgId(obj);
            res.addAll(SysOrgFactory.sysOrgsToModels(child));
            List<SysOrgModel> children = getAllChildSysOrgByOrgId(child);
            if (!CollectionUtils.isEmpty(children)){
                res.addAll(children);
            }
        }
        return res;
    }

    private List<SysOrg> getChildSysOrgListByOrgId(SysOrg sysOrg) {
        if(sysOrg == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_IS_NULL.getErrMsg());
        }
        if (sysOrg.getOrgId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_ID_IS_NULL.getErrMsg());
        }

        List<SysOrg> childList = sysOrgMapper.selectChildren(sysOrg);
        return childList;
    }
}
