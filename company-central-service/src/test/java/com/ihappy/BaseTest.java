package com.ihappy;

import com.alibaba.fastjson.JSONObject;
import com.ihappy.config.common.ConfigSetPropertyHolder;
import com.ihappy.gateway.dto.PersonUserInfoDTO;
import com.ihappy.unifiedLog.module.Result;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by renyueliang on 2018/3/8.
 */
public abstract class BaseTest {


    protected ApplicationContext applicationContext;

    protected PersonUserInfoDTO personUserInfoDTO;

    @Before
    public void setUp() throws Exception {

        ConfigSetPropertyHolder configSetPropertyHolder = new ConfigSetPropertyHolder();
        configSetPropertyHolder.setAppId("50");
        configSetPropertyHolder.init();
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-company.xml");

    }

    public <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    protected void printResult(Object result) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("********************************************************************************************");
        System.out.println(JSONObject.toJSONString(result));
        System.out.println("********************************************************************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
