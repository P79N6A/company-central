package com.ihappy.company.infrastructure.repo.shardingjdbc.algorithm;

/**
 * baseinfoCompanyPartner表分片算法
 * Created by sunjd on 2018/3/31.
 */
public class BaseinfoCompanyPartnerComplexAlg extends ShardByColFirstCommComplexAlg{
    @Override
    protected void initInfo() {
        lastLength = 4;
        shardingColumnStr = "partner_id,comp_id";
    }
}
