package com.jothan.test.time.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期帮助类
 *
 * @author rplees
 * @date 2010-10-18
 */
public class DateUtils {

    public final static String YYYY_MM_DD_HH_MM    = "yyyy-MM-dd HH:mm";
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String DEFAULT_DATE_FORMAT = YYYY_MM_DD_HH_MM_SS;
    public final static String YYYYMMDDHHMMSS      = "yyyyMMddHHmmss";
    public final static String YYYY_MM_DD          = "yyyy-MM-dd";
    public final static String YYYYMMDD            = "yyyyMMdd";
    public final static String YYYY_MM_DD_00_00_00 = "yyyy-MM-dd 00:00:00";

    public static String getStringDateFromUnix(long unixTime) {
        Date unixDate = new Date(unixTime);
        return parseTime(unixDate);
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static String getCurrentTime(String format) {
        if (StringUtils.isEmpty(format)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getDayTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_00_00_00);
        return sdf.format(new Date());
    }

    public static String getDateStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        return sdf.format(new Date());
    }

    public static Date formatDate(String dateStr) {
        return formatDate(dateStr, YYYY_MM_DD);
    }

    public static Date formatTime(String dateStr) {
        return formatDate(dateStr, YYYY_MM_DD_HH_MM_SS);
    }

    public static Date formatDate(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(format)) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parseDate(Date date) {
        return parseDate(date, YYYY_MM_DD);
    }

    public static String parseDate(Date date, String format) {
        if (null == date || StringUtils.isEmpty(format)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String parseTime(Date date) {
        return parseDate(date, YYYY_MM_DD_HH_MM_SS);
    }

    public static boolean checkDateStrValid(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(format)) {
            return false;
        }

        Date date = formatDate(dateStr, format);
        if (null == date) {
            return false;
        }

        String newDateStr = parseDate(date, format);
        return dateStr.equals(newDateStr);
    }

    public static boolean checkDateStrValid(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return false;
        }

        Date date = formatDate(dateStr, YYYY_MM_DD);
        if (null == date) {
            return false;
        }

        String newDateStr = parseDate(date, YYYY_MM_DD);
        return dateStr.equals(newDateStr);
    }

    /**
     * 在指定时间的基础上增加 days 后的日期
     *
     * @param days
     * @return
     */
    public static Date addDay(int days, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 在指定时间的基础上增加 hours 后的小时
     *
     * @param hours
     * @return
     */
    public static Date addHour(int hours, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    /**
     * 在指定时间的基础上增加 minuted 后的小时
     * @param mins
     * @return
     */
    public static Date addMin(int mins, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, mins);
        return calendar.getTime();
    }

    /**
     * 在当前时间的基础上增加 days 后的日期
     *
     * @param days
     * @return
     */
    public static Date addDay(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Long getTimeStampFromDate(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr).getTime() / 1000;
        } catch (ParseException e) {
        }
        return null;
    }

    /**
     * 在指定时间的基础上增加 days 后的日期
     *
     * @param
     * @return
     */
    public static Date addMonth(int month, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date getLastDayOfMonth(String date) {
        Date firstDate = formatDate(date + "-01");
        if (null == firstDate) {
            return null;
        }

        Date endDate = DateUtils.addMonth(1, firstDate);
        return DateUtils.addDay(-1, endDate);
    }

    /**
     * 获取两日期之间相差天数
     *
     * @param startDate
     *            开始时间
     * @param endDate
     *            结束时间
     * @return 天数
     */
    public static long twoDateBetweenDays(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
    }

    /**
     * 功能描述：返回月
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日期
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date
     *            日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取上n个小时整点小时时间
     * @param date
     * @return
     */
    public static String getLastHourTime(Date date, int n) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - n);
        date = ca.getTime();
        return sdf.format(date);
    }

    /**
     * 获取当前时间的整点小时时间
     * @param date
     * @return
     */
    public static String getCurrHourTime(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        date = ca.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }

    /**
     * 获取当前时间的今天开始时间
     *
     * @param date
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取多少天前的时间点
     * @return
     */
    public static String getDayBeforeStartTime(int dayBefore) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -dayBefore);
        Date date = getStartTimeOfDay(cal.getTime());
        return parseDate(date, DateUtils.YYYY_MM_DD_HH_MM_SS);
    }

    public static String getDayAfterStartTime(int dayAfter) {
        return getDayBeforeStartTime(-dayAfter);
    }

    public static Date now() {
        return new Date();
    }

    public static long getNowTimestamp10() {
        return now().getTime() / 1000;
    }
}
