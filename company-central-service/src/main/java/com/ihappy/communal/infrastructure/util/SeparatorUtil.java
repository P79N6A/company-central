package com.ihappy.communal.infrastructure.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分界符处理类
 * Created by sunjd on 2018/4/10.
 */
public class SeparatorUtil {
    /**
     * 去掉首尾空格后，去除首尾分界符
     * @param str 源字符串
     * @param separator  分界符
     * @return
     */
    public static String trimSeparator(String str,String separator){
        String regex = "^"+separator+"*|"+separator+"*$";
        // 需要处理多个字符串
        return str.trim().replaceAll(regex, "");
    }

    /**
     * 首尾添加一个分界符
     * @param str
     * @param separator
     * @return
     */
    public static String addSeparator(String str,String separator){
        return separator+trimSeparator(str,separator)+separator;
    }
    public static void main(String[] args) {

        String[] strs = {"1,2,5,", ",,,1,2,5,", ",,,,,,," };
        String regex = "^,*|,*$";

        // 需要处理多个字符串
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("");
        for(int i = 0; i < strs.length; i++) {
            System.out.println(matcher.reset(strs[i]).replaceAll(""));
        }

        // 只处理一个字符串
        String str = ",,,,1,2,3,,,,,";
        System.out.println(str.replaceAll(regex, ""));

        System.out.println(trimSeparator("--1-2-3-----","-"));

    }
}
