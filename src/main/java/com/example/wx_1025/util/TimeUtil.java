package com.example.wx_1025.util;

import com.example.wx_1025.domain.TimeHorizon;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Time util.
 *
 * @program: wx_1025
 * @description: 关于时间操作的工具包
 * @author: chenzou
 * @create: 2021 -10-26 19:07
 */
@Slf4j
public class TimeUtil {

    /**
     * Get current time calendar.获取当前的时间
     *
     * @return the calendar
     */
    public static Calendar getCurrentTime() {
        return Calendar.getInstance();
    }

    /**
     * 获取当前时间的前N天时间
     *
     * @param cl     the cl
     * @param dayNum the day num
     * @return the before day
     */
    public static Calendar getBeforeDay(Calendar cl,int dayNum) {
        //使用深拷贝避免污染到原来的calendar
        Calendar myCalendar= (Calendar) cl.clone();
        int day = myCalendar.get(Calendar.DATE);
        myCalendar.set(Calendar.DATE, day - dayNum);
        return myCalendar;
    }

    /**
     * 获取当前时间的后N天时间
     *
     * @param cl     the cl
     * @param dayNum the day num
     * @return the after day
     */
    public static Calendar getAfterDay(Calendar cl,int dayNum) {

        Calendar myCalendar= (Calendar) cl.clone();
        int day = myCalendar.get(Calendar.DATE);
        myCalendar.set(Calendar.DATE, day + dayNum);
        return myCalendar;
    }

    /**
     * Dim format date string.格式化时间精确到日
     *
     * @param time the time
     * @return the string
     */
    public static String dimFormatDate(Date time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(time);
    }

    /**
     * Detail fromat date string.格式化时间精确到秒
     *
     * @param time the time
     * @return the string
     */
    public static String  detailFromatDate(Date time){
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
        return simpleDateFormat.format(time);
    }

    /**
     * Get specified time date.通过字符串获取指定data
     *
     * @param timeString the time string 年-月-日
     * @return the date
     */
    public static Date getSpecifiedTime(String timeString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(timeString);
            return parse;
        } catch (ParseException e) {
            log.error("时间格式化错误，请检查输入的字符串是否满足格式");
        }

        return null;
    }


    /**
     * Fast time horizon.快速获取时间段
     *  @param beginTime the begin time开始的时间字符
     * @param endTime   the end time结束时间
     * @return
     */
    public static TimeHorizon fastTimeHorizon(String beginTime, String endTime){
        Date specifiedBeginTime = TimeUtil.getSpecifiedTime(beginTime);
        Date specifiedEndTime = TimeUtil.getSpecifiedTime(endTime);
        return new TimeHorizon(TimeUtil.dimFormatDate(specifiedBeginTime), TimeUtil.dimFormatDate(specifiedEndTime));
    }

}
