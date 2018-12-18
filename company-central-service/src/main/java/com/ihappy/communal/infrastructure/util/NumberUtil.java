package com.ihappy.communal.infrastructure.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sunjd on 2018/5/2.
 */
public class NumberUtil {
    public static boolean equalNum(Object num1,Object num2){
        if (num1 == null || num2 == null){
            return false;
        }else{
            return num1.toString().equals(num2.toString());
        }
    }

    public static double divideWith2ScaleUp(Long divisor, Long ... dividend) {
        if (divisor == null) {
            return 0.00;
        }
        if(dividend.length == 0){
            return 0.00;
        }
        for(Long d : dividend){
            if (d == null || d == 0L) {
                return 0.00;
            }
        }
        BigDecimal bigDecimal = new BigDecimal(divisor);
        for (Long d : dividend) {
            bigDecimal = bigDecimal.divide(new BigDecimal(d), 10, RoundingMode.UP);
        }

        return bigDecimal.setScale(2, RoundingMode.UP).doubleValue();
    }

    public static void main(String[] args) {
        Long l = 40L;
        Long l1 = 6L;
//        Long l2 = 100L;
//        Long l3 = 10L;
        System.out.println(divideWith2ScaleUp(l, l1));
    }

}
