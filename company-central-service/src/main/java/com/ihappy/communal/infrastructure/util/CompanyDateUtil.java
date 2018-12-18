package com.ihappy.communal.infrastructure.util;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.item.common.enumtype.ItemErrorCodeEnum;
import com.ihappy.item.exception.ItemException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sunjd on 2018/4/3.
 */
public class CompanyDateUtil {

    public static final String Y_M_D_H_M ="yyyy-MM-dd HH:mm";
    public static final String YMDHMS ="yyyyMMddHHmmss";
    private final static Logger logger = CompanyLoggerUtil.getLogger();

    public static long getDate14Long(Date val) {
        return Long.parseLong((new SimpleDateFormat("yyyyMMddHHmmss")).format(val));
    }
    public static Long getTodayStartDate14Long() {
        return (getDate14Long(new Date()) / 1000000) * 1000000;
    }

    /**
     * 计算增加若干天数后的时间
     *
     * @param date 当前天数  例：20180405010929 表示 2018-04-05 01:09:29
     * @param days 增加天数
     * @return Long类型 增加后的 时间
     */
    public static Long addDateToLong(Long date, Integer days) {
        if (date == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    ItemErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date dt = sdf.parse(date + "");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.DAY_OF_YEAR, days);
            return getDate14Long(rightNow.getTime());
        } catch (ParseException e) {
            throw new ItemException(ItemErrorCodeEnum.
                    PARSE_FAILED.getErrCode(),
                    ItemErrorCodeEnum.PARSE_FAILED.getErrMsg());
        }
    }

    /**
     * 计算增加若干天数后的时间
     *
     * @param date 当前天数  例：20180405010929 表示 2018-04-05 01:09:29
     * @param days 增加天数
     * @return Long类型 增加后的 时间
     */
    public static Long addDateToLong(Long date, Long days) {
        if (date == null) {
            throw new CompanyException(CompanyErrorCodeEnum.
                    ILLGAL_ARGUMENT.getErrCode(),
                    ItemErrorCodeEnum.ILLGAL_ARGUMENT.getErrMsg());
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date dt = sdf.parse(date + "");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(dt);
            rightNow.add(Calendar.DAY_OF_YEAR, Integer.valueOf(days.toString()));
            return getDate14Long(rightNow.getTime());
        } catch (ParseException e) {
            throw new ItemException(ItemErrorCodeEnum.
                    PARSE_FAILED.getErrCode(),
                    ItemErrorCodeEnum.PARSE_FAILED.getErrMsg());
        }
    }

    public static String longDate2String(Long time) {
        if (time != null && time > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date dt = sdf.parse(time + "");
                return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return "";
    }

    public static String longDate2String(Long time,String source,String target) {
        if (time != null && time > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat(source);
            try {
                Date dt = sdf.parse(time + "");
                return new java.text.SimpleDateFormat(target).format(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return "";
    }
    /**
     * 当天返回 HH:MM  24小时制  当天之前显示  X天前
     *
     * @param time unix时间戳 秒
     * @return
     */
    public static String lastContactTime(Long time) {
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        if (null == time || time == 0) return "";
        try {
            time = getDate(time.toString(), "yyyyMMddHHmmss").getTime() / 1000;
            Long today = ymd.parse(ymd.format(new Date())).getTime() / 1000;
            if (time < today) {
                Long num = (today - time) / 3600 / 24;
                if ((today - time) % (3600 * 24) > 0) num++;
                return num + "天前";
            } else {
                return TimeStamp2Date(time.toString(), "yyyy-MM-dd HH:mm:ss").substring(11, 16);
            }
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return "";
    }

    public static String timeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     *
     * @param timestampString 时间戳 如："1473048265";
     * @param formats         要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (formats == null || formats.equals(""))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    public static Date getDate(String date, String pattern) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static String parseDian(Long strDate) {
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //加上时间
        //必须捕获异常
        try {
            Date date = simpleDateFormat.parse(strDate + "");
            return sDateFormat.format(date);
        } catch (ParseException px) {
            px.printStackTrace();
            return "";
        }
    }

    public static String parseDate(Long strDate,String parse) {
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sDateFormat = new SimpleDateFormat(parse); //加上时间
        //必须捕获异常
        try {
            Date date = simpleDateFormat.parse(strDate + "");
            return sDateFormat.format(date);
        } catch (ParseException px) {
            px.printStackTrace();
            return "";
        }
    }

    /**
     * @Description: 传入天数, 小时数, 分钟数, 秒数, 返回毫秒值
     * @Param:
     * @return:
     * @Author: zhangtengpo
     * @Date: 2018/6/4
     */
    public static Long getMillisecondByDayHourMinuteSecond(Integer day, Integer hour, Integer minute, Integer second) {
        day = day == null ? 0 : day;
        hour = hour == null ? 0 : hour;
        minute = minute == null ? 0 : minute;
        second = second == null ? 0 : second;
        Long dayMillisecond = Long.valueOf(day * 24 * 60 * 60 * 1000L);
        Long hourMillisecond = Long.valueOf(hour * 60 * 60 * 1000L);
        Long minuteMillisecond = Long.valueOf(minute * 60 * 1000L);
        Long secondMillisecond = Long.valueOf(second * 1000L);
        return dayMillisecond + hourMillisecond + minuteMillisecond + secondMillisecond;
    }


    public static Date weeHours(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        //时分秒（毫秒数）
        long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000;
        //凌晨00:00:00
        cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);

        if (flag == 0) {
            return cal.getTime();
        } else if (flag == 1) {
            //凌晨23:59:59
            cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000);
        }
        return cal.getTime();
    }

    public static Date addDays(Date dt, int days, int flag) {
        Calendar cal = Calendar.getInstance();
        Date date = weeHours(dt,flag);
        if (date != null) {
            cal.setTime(date);
        }
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 获取日期月份  返回示例  201808
     * @param date
     * @return
     */
    public static int getIntDateYM(Date date){
        Long longDate = getDate14Long(date);
        return Integer.valueOf(longDate/100000000+"");
    }

    public static int getIntDateYM(){
        return getIntDateYM(new Date());
    }

    /**
     * Date增加月数
     * @param date
     * @param days
     * @return
     */
    public static Date addMonth(Date date,int days){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, days);
        Date m = c.getTime();
        return m;
    }
}
