package com.ihappy.company.infrastructure.repo.shardingjdbc.algorithm;

/**
 * baseinfoCompanyRole表分片算法
 * Created by sunjd on 2018/4/2.
 */
public class BaseinfoCompanyRoleComplexAlg extends ShardByColFirstCommComplexAlg{
    @Override
    protected void initInfo() {
        lastLength = 4;
        shardingColumnStr = "role_id,comp_id";
    }
}
