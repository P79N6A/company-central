package com.ihappy.role.common.util;

import com.alibaba.fastjson.JSONArray;

/**
 * json转换工具类
 *
 * @author gongwenqiang
 * @version V1.0.0
 * @date 2018/9/3 10:21 AM
 */
public class JsonUtil {
    /**
     * 判断是否是Json数组
     * @param content
     * @return
     */
    public static boolean isJsonArray(String content) {
        try {
            JSONArray.parseArray(content);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }
}
