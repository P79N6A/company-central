package com.ihappy.company.domain.model.factory;

/**
 * Created by sunjd on 2018/8/31.
 */
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-8-15 上午11:01
 */
public class QuartzJobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        // 创建job对象后注入bean
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}