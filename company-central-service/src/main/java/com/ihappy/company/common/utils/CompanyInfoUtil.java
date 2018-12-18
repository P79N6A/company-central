package com.ihappy.company.common.utils;

import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.CompanyTypeEnum;
import com.yx.eweb.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/6/8.
 * 公司信息相关工具类
 */
public class CompanyInfoUtil {
    /**
     * 判断公司业务类型是否为零售
     * 业务类型中包含零售则 返回true
     * @param ctIds
     * @return
     */
    public static Boolean isRetail(String ctIds){
        if (StringUtils.isEmpty(ctIds)){
            return false;
        }
        List<String> ctIdStr = Arrays.asList(ctIds.split(","));
        for (String ctId : ctIdStr){
            if (!StringUtil.isBlank(ctId) && StringUtil.isNumeric(ctId)){
                if (CompanyTypeEnum.RETAILERS.getTypeCode().equals(Integer.valueOf(ctId))){
                    return true;
                }
            }
        }
        return false;
    }



    public static String createFactoryInfoRedisKey(String compId){
        return CompanyConstant.FACTORY_INFO_REDIS_KEY+"-"+compId;
    }
}
