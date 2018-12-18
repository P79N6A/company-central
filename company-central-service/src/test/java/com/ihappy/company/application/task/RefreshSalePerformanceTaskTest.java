package com.ihappy.company.application.task;

import com.ihappy.BaseTest;
import com.ihappy.company.infrastructure.service.BackdoorRpcService;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by sunjd on 2018/8/31.
 */
public class RefreshSalePerformanceTaskTest extends BaseTest {
    @Test
    public void executeInternal() throws Exception {
        StdScheduler quartzScheduler = getBean("companyQuartzScheduler");
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("startShardingNumber",0);
        map.put("endShardingNumber",14);
        JobDataMap map2 = new JobDataMap(map);
        quartzScheduler.triggerJob(new JobKey("refreshSalePerformanceJob1","company"),map2);

        map.put("startShardingNumber",15);
        map.put("endShardingNumber",29);
        JobDataMap map1 = new JobDataMap(map);
        quartzScheduler.triggerJob(new JobKey("refreshSalePerformanceJob2","company"),map1);
        Thread.sleep(300000);
    }

}