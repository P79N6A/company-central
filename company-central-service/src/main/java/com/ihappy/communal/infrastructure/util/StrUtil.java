package com.ihappy.communal.infrastructure.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunjd on 2018/4/24.
 */
public class StrUtil {
    /**
     * 过滤以separator为分隔符的target中的replacement元素
     * 不支持多个相同元素重复出现
     * @param target
     * @param replacement
     * @param separator
     * @return
     */
    public static String replaceInSet(String target,String replacement,String separator){
        if (target.equals(replacement)){
            return "";
        }
        String regExpr = "^"+replacement+separator+"|"+separator+replacement+"$";
        Pattern p = Pattern.compile(regExpr);
        Matcher m = p.matcher(target);
        String res = m.replaceAll("").trim();
        res = res.replace(separator+replacement+separator,separator);
        return res;
    }
}
