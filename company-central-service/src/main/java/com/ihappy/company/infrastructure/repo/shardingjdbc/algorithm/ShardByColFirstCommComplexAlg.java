package com.ihappy.company.infrastructure.repo.shardingjdbc.algorithm;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import io.shardingjdbc.core.api.algorithm.sharding.ListShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.ShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import io.shardingjdbc.core.exception.ShardingJdbcException;

import java.util.*;

/**
 * 支持多个分片字段，但是不支持这些字段的组合，即按配置字段的先后顺序匹配，匹配到后就停止
 * @author gongwq
 * @create 2018-03-24 11:17
 */
public abstract class ShardByColFirstCommComplexAlg implements ComplexKeysShardingAlgorithm {

    /**
     *  路由由分片列的后几位路由
     */
    protected int lastLength;


    /**
     * 分列字段字符
     */
    protected String shardingColumnStr;

    /**
     * 初始化信息，需要子类去实现
     */
    protected abstract void initInfo();


    /**
     *
     * @param collection 表来源，比如 table_0,table_1,table_2等
     * @param shardingValues 入参传入，分表值集合
     * @return 分表集合
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, Collection<ShardingValue> shardingValues) {
        initInfo();
        long modValue = (long) Math.pow(10, lastLength);
//        System.out.println(("collection:" + JSON.toJSONString(collection) + ",shardingValues:" + JSON.toJSONString(shardingValues)));
        if(StringUtil.isBlank(shardingColumnStr)){
            throw new ShardingJdbcException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
        }
        List<String> shardingSuffix = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(shardingColumnStr, ",");
        while (stringTokenizer.hasMoreTokens()){
            String column = stringTokenizer.nextToken();
            Collection values = getShardingValue(shardingValues, column);
            if(CollectionUtil.isEmpty(values)) {
                continue; //如果没有这列值，就继续匹配
            }

            Iterator iterator = values.iterator();
            while (iterator.hasNext()){
                Object value = iterator.next();
                if(value == null || !StringUtils.isNumeric(value.toString())){
                    throw new ShardingJdbcException(CompanyErrorCodeEnum.SHARDING_COLUMN_NULL_ERROR.getErrCode());
                }
                Long lvalue = Long.parseLong(value.toString());
                String suffix = "_" + new Long(lvalue % modValue % collection.size()).toString();
                collection.forEach( x -> {
                    if(x.endsWith(suffix)){
                        shardingSuffix.add(x);
                    }
                });
            }
            return shardingSuffix;
        }
        return shardingSuffix;
    }

    private Collection<Long> getShardingValue(Collection<ShardingValue> shardingValues, final String key) {
        Collection<Long> valueSet = new ArrayList<>();
        Iterator<ShardingValue> iterator = shardingValues.iterator();
        while (iterator.hasNext()) {
            ShardingValue next = iterator.next();
            if (next instanceof ListShardingValue) {
                ListShardingValue value = (ListShardingValue) next;
                if (value.getColumnName().equals(key)) {
                    return value.getValues();
                }
            }
        }
        return valueSet;
    }
}
