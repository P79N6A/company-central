package com.ihappy.company.common.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by chenying on 2018/6/28.
 */
public class DateUtil {

    public static final String YMDHMS ="yyyyMMddHHmmss";
    public static final String Y_M_D_H_M_S ="yyyy-MM-dd HH:mm:ss";
    public static Long getTodayTextYMD() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return Long.valueOf(df.format(new Date()));
    }

    public static long daysDiff(Date firstDay, Date lastDay) {
        if (firstDay == null || lastDay == null) {
            return 0;
        }
        long allDays = (lastDay.getTime() - (firstDay.getTime())) / (1000 * 24 * 60 * 60);

        return allDays;
    }

    public static String formatDate(String format, String date) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isBlank(format)) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf= new SimpleDateFormat(format);
        try {
            Date dt = sdf.parse(date);
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatDate(String date) {
        return formatDate(null,date);
    }

    public static String formatDate(Long date) {
        if (date != null){
            return formatDate(null,date.toString());
        }
        return "";
    }
    public static String formatDateYmdhsm(Long date) {
        if (date != null && date > 0){
            return formatDate(YMDHMS,date.toString());
        }
        return "";
    }

    public static Date parseDate(String ymd) {
        Date date = new Date();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date =df.parse(ymd);
        }catch (ParseException e){

        }
        return date;
    }

    public static Date parseDateYMD(String ymd) {
        DateFormat df = new SimpleDateFormat(YMDHMS);
        try {
            return df.parse(ymd);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parseDateY_M_D(String ymd) {
        DateFormat df = new SimpleDateFormat(Y_M_D_H_M_S);
        try {
            return df.parse(ymd);
        } catch (ParseException e) {
            return null;
        }
    }
    public static String getDateYMD(Date strDate) {
        String date = null;
        if (strDate!= null) {
            Calendar startTime = Calendar.getInstance();
            int year = startTime.get(Calendar.YEAR) - 20;
            // 这里初始化时间，然后设置年份。只以年份为基准，不看时间
            startTime.clear();
            startTime.set(Calendar.YEAR, year);
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
            formatter.setLenient(false);
            formatter.set2DigitYearStart(startTime.getTime());
            try {
                date = formatter.format(strDate);
            }
            catch (Exception e) {
            }
        }
        return date;
    }

    //十分秒改为235959
    public static Date parseDateYmdhsm(Long ymdhsm) {
        DateFormat dd = new SimpleDateFormat("yyyyMMdd");
        DateFormat df = new SimpleDateFormat("yyyyMMddHHssmm");
        try {
            Date old = df.parse(ymdhsm.toString());
            String now = dd.format(old)+"235959";
            return df.parse(now);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        int days = 0;
        if (date1 != null && date2 != null){
            days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        }

        return days;
    }
    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Long date1,Long date2){
        if (date1 != null && date2 != null && date1 > 0 && date2 > 0){
            return differentDays(parseDateYmdhsm(date1),parseDateYmdhsm(date2));
        }else {
            return 0;
        }
    }

    /**
     * 当前时间比date多的天数
     * @param date
     * @return
     */
    public static int differentDays(Long date){
        if (date != null && date > 0){
            return differentDays(parseDateYmdhsm(date),new Date());
        }else {
            return 0;
        }

    }


    public static int getDifferentDays(Date date1,Date date2){
       int difDate =  differentDays(date1,date2);
       int num =difDate;
       if(difDate < 0){
           num = -1;
       }else if(difDate == 2){
           num =3;
        }else if(difDate == 1){
           num =2;
       }else if(difDate == 0){
           num =1;
       }
       return num;
    }

    /****
     * 传入具体日期 ，返回具体日期减一个月。
     *
     * @param date  日期(2018-04-20)
     * @param yearNum  如果为负数是减年 正数是加年
     * @return 2014-03-20
     * @throws ParseException
     */
    public static Date subOrAddYear(Date date,Integer yearNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, yearNum);
        Date dt1 = rightNow.getTime();
        return dt1;
    }

    /**
     * 获取某年某月有多少天
     * @param year
     * @param month
     * @return
     */
    public static int getDayOfMonth(int year,int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, 0); //输入类型为int类型
        return c.get(Calendar.DAY_OF_MONTH);
    }
    public static int compareDate(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {
            return 1;//dt1 在dt2前
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;//dt1在dt2后
        } else {//相等
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(formatDateYmdhsm(20180810173300L));
    }
}
