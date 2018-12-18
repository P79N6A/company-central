package com.ihappy.role.infrastructure.service.inside.impl;

import com.ihappy.role.domain.bo.SysClientBO;
import com.ihappy.role.domain.bo.SysClientInfoBO;
import com.ihappy.company.domain.model.model.SysClientModel;
import com.ihappy.role.domain.dbdo.sys.SysClient;
import com.ihappy.role.infrastructure.repo.mybatis.mapper.sys.SysClientMapper;
import com.ihappy.role.infrastructure.service.inside.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class SysClientServiceImpl implements SysClientService {
    @Autowired
    private SysClientMapper sysClientMapper;

    @Override
    public List<SysClientModel> querySysClientList(SysClientBO sysClientBO) {
        List<SysClient> sysClientList = sysClientMapper.querySysClientList(sysClientBO);
        List<SysClientModel> sysClientModelList = new ArrayList<>();
        if (CollectionUtils.isEmpty(sysClientList)) {
            return sysClientModelList;
        }
        for (SysClient sysClient : sysClientList) {
            sysClientModelList.add(new SysClientModel(sysClient));
        }
        return sysClientModelList;
    }
    @Override
    public SysClientModel querySysClientByClId(SysClientInfoBO sysClientInfoBO) {
        SysClient client = sysClientMapper.querySysClientByClId(sysClientInfoBO);
        if (client == null) {
            return null;
        }
        return new SysClientModel(client);
    }
}
