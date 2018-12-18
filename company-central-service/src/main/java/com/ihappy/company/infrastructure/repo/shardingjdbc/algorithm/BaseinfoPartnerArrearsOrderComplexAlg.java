package com.ihappy.company.infrastructure.repo.shardingjdbc.algorithm;

/**
 * Created by sunjd on 2018/4/18.
 */
public class BaseinfoPartnerArrearsOrderComplexAlg extends ShardByColFirstCommComplexAlg{
    @Override
    protected void initInfo() {
        lastLength = 4;
        shardingColumnStr = "order_id,comp_id";
    }
}
