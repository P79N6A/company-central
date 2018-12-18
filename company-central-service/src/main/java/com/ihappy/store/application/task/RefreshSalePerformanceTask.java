package com.ihappy.store.application.task;

import com.alibaba.fastjson.JSON;
import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.store.domain.bo.performance.SalePerformanceBO;
import com.ihappy.store.domain.dbdo.performance.SalePerformance;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunjd on 2018/8/31.
 */
public class RefreshSalePerformanceTask extends QuartzJobBean {
    private final Integer LIMIT = 100;  // 每次处理的记录数
    @Autowired
    private CompanyStoreService companyStoreService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        CompanyLoggerUtil.getTaskLogger().info("-------------------------------------刷新业绩定时任务开始-----------------------------");
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Integer startShardingNumber = jobDataMap.getIntegerFromString("startShardingNumber");
        Integer endShardingNumber = jobDataMap.getIntegerFromString("endShardingNumber");
        CountDownLatch countDownLatch = new CountDownLatch(endShardingNumber - startShardingNumber + 1);
        for (int shardingNumber = startShardingNumber; shardingNumber <= endShardingNumber; shardingNumber++) {
            final int nowShardingNumber = shardingNumber;
            new Thread(() -> refreshSalePerformance(countDownLatch, nowShardingNumber)).start();
        }
        try {
            // 本次数据处理完再触发下次任务
            countDownLatch.await();
            CompanyLoggerUtil.getTaskLogger().info("----------------------------------刷新业绩定时任务结束-----------------------------");
        } catch (InterruptedException e) {
            CompanyLoggerUtil.getTaskLogger().error(e);
        }
    }

    private void refreshSalePerformance(CountDownLatch countDownLatch, int shardingNumber) {
        Integer yearMonth = CompanyDateUtil.getIntDateYM();
        try {
            SalePerformanceBO shardingQuery = new SalePerformanceBO();
            shardingQuery.setShardingNum(shardingNumber);
            shardingQuery.setLimit(LIMIT);
            shardingQuery.setYearMonth(CompanyDateUtil.getIntDateYM(CompanyDateUtil.addMonth(new Date(),-1)));
            int totalCount = companyStoreService.selectShardingSalePerformanceCount(shardingQuery);
            CompanyLoggerUtil.getTaskLogger().info("线程 "+Thread.currentThread().getId()+" 分片="+shardingNumber+" totalCount="+totalCount);
            // 分页处理
            for (int offset = 0; offset < totalCount; offset += LIMIT) {
                shardingQuery.setOffset(offset);
                List<SalePerformance> salePerformances = companyStoreService.selectShardingSalePerformance(shardingQuery);
                for (SalePerformance obj : salePerformances) {
                    SalePerformanceBO bo = new SalePerformanceBO(obj);
                    bo.setSalePerformanceId(DistributedPrimaryKeyFactory.generateSalePerformanceId(obj.getCompId()));
                    bo.setYearMonth(yearMonth);
                    bo.setInsertType(1);
                    bo.setUpdatedAt(CompanyDateUtil.getDate14Long(new Date()));
                    CompanyLoggerUtil.getTaskLogger().info("线程 "+Thread.currentThread().getId()+" 更新数据="+ JSON.toJSONString(bo));
                    try {
                        Integer row = companyStoreService.insertOrUpdateSalePerformance(bo);
                        CompanyLoggerUtil.getTaskLogger().info("线程 "+Thread.currentThread().getId()+"影响行数="+row);
                    } catch (Exception e) {
                        CompanyLoggerUtil.getTaskLogger().error("刷新门店员工业绩出错",e);
                    }
                }
            }
            CompanyLoggerUtil.getTaskLogger().info("线程 "+Thread.currentThread().getId()+" Over");
        } catch (Exception e) {
            CompanyLoggerUtil.getTaskLogger().error("刷新门店员工业绩出错",e);
        } finally {
            countDownLatch.countDown();
        }
    }
}
