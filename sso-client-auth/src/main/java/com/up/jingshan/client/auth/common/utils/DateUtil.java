package com.up.jingshan.client.auth.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 时间工具
 * @date 2020/1/8
 */
public class DateUtil {
    public static final String DATE_FMT_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FMT_Y_M_D_H_M = "yyyy-MM-dd HH:mm";
    public static final String DATE_FMT_YMDHMSS = "yyyyMMddHHmmssSSS";
    public static final String DATE_FMT_YMDHMSS_CHS = "yyyy年MM月dd日HH点mm分ss秒SSS毫秒 ";
    public static final String DATE_FMT_YMDHMS = "yyyyMMddHHmmss";
    public static final String DATE_FMT_YMDHMS_CHS = "yyyy年MM月dd日HH点mm分ss秒";
    public static final String DATE_FMT_Y_M_D = "yyyy-MM-dd";
    public static final String DATE_FMT_YMD = "yyyyMMdd";
    public static final String DATE_FMT_YMD_CHS = "yyyy年MM月dd日";
    public static final String DATE_FMT_YM = "yyyyMM";
    public static final String DATE_FMT_YM_CHS = "yyyy年MM月";
    public static final String DATE_FMT_Y = "yyyy";
    public static final String DATE_FMT_Y_CHS = "yyyy年";
    public static final String DATE_FMT_HMS = "HHmmss";
    public static final String DATE_FMT_HMS_CHS = "HH点mm分ss秒";
    public static final String DATE_FMT_MD = "MMdd";
    public static final String DATE_FMT_MD_CHS = "MM月dd日";
    public static final String DATE_FMT_HM = "HH:mm";
    public static final String DATE_FMT_DEFAULT = "yyyy-MM-dd";
    public static final String DATE_FMT_RFC_822 = "EEE, d MMM yyyy HH:mm:ss Z";
    public static final String DATE_FMT_CUPS_DATE = "yyyyMMdd HH:mm:ss";
    public static final String DATE_FMT_COOKIE = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    private static final DateFormat DATE_FORMATTER_DEFAULT = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat DATE_FORMATTER_MEDIUM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat DATE_FORMATTER_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat DATE_FORMATTER_LONG_COMPACT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final DateFormat DATE_FORMATTER_YEAR_MONTH = new SimpleDateFormat("yyyyMM");
    private static final DateFormat DATE_FORMATTER_YEAR_MONTH_DAY = new SimpleDateFormat("yyyyMMdd");
    private static final DateFormat DATE_FORMATTER_RFC_822 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
    private static final DateFormat DATE_FORMATTER_CUPS_DATE = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    private static final DateFormat DATE_FORMATTER_COOKIE = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'");

    /**
     * 是否是可用的时间
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean isValidDate(String date, String format) {
        if (date != null && !"".equals(date.trim()) && format != null && !"".equals(format.trim())) {
            SimpleDateFormat s = new SimpleDateFormat(format);

            try {
                s.setLenient(false);
                s.parse(date);
                return true;
            } catch (Exception var4) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 解析时间
     *
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date, String format) throws ParseException {
        if (date != null && !"".equals(date.trim()) && format != null && !"".equals(format.trim())) {
            return (new SimpleDateFormat(format)).parse(date);
        } else {
            throw new IllegalArgumentException("Args can not be null!");
        }
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        if (date != null && format != null && !"".equals(format.trim())) {
            return (new SimpleDateFormat(format)).format(date);
        } else {
            throw new IllegalArgumentException("Args can not be null!");
        }
    }

    /**
     * 根据指定的格式来格式化时间
     *
     * @param date
     * @param format1
     * @param format2
     * @return
     * @throws ParseException
     */
    public static String formatDateByFormat(String date, String format1, String format2) throws ParseException {
        return formatDate(parseDate(date, format1), format2);
    }

    /**
     * 解析时间戳
     *
     * @param time
     * @param format
     * @return
     * @throws ParseException
     */
    public static Timestamp parseTimestamp(String time, String format) throws ParseException {
        return new Timestamp(parseDate(time, format).getTime());
    }

    /**
     * 格式化时间戳
     *
     * @param time
     * @param format
     * @return
     */
    public static String formatTimestamp(Timestamp time, String format) {
        if (time != null && format != null && !"".equals(format.trim())) {
            return (new SimpleDateFormat(format)).format(time);
        } else {
            throw new IllegalArgumentException("Args can not be null!");
        }
    }

    /**
     * 前一天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date afterDay(Date date, int day) {
        return new Date(date.getTime() + (long) day * 24L * 3600L * 1000L);
    }

    /**
     * 后一天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date beforeDay(Date date, int day) {
        return new Date(date.getTime() - (long) day * 24L * 3600L * 1000L);
    }
}