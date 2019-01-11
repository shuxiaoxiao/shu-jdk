package com.shuframework.jdkutil.lang;

import com.shuframework.jdkutil.SystemUtil;
import com.shuframework.jdkutil.enums.DatePatternEnum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date工具类 Date与String类型的转换<br/>
 * 以及日期的常见操作,底层依赖的是java.util.Calendar
 * 结束时间（endTime，lastDay）都是23:59:59，为了解决转点问题
 *
 * @author shuheng
 */
public class DateUtil {

    private DateUtil() {
    }

    /**
     * 日期格式为yyyy-MM-dd HH:mm:ss
     */
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式为yyyy-MM-dd
     */
    public static final String YMD = "yyyy-MM-dd";

    /**
     * 将指定字符(String)串转换成日期 (Date)<br/>
     * 如果发生格式对不上差一部分，则返回 null;
     * 如果发生格式对不上多一部分，则返回 datePattern的格式。
     * <p>
     * datePattern为yyyy-MM-dd，dateStr为""或"2017-01"，则返回null
     * datePattern为yyyy-MM-dd，dateStr为"2017-01-01 12"，则返回"2017-01-01"对应的日期
     * </p>
     *
     * @param dateStr     String 日期字符串
     * @param datePattern String 日期格式
     * @return
     */
    public static Date strToDate(String dateStr, String datePattern) {
        if (StringUtil.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        // return sd.parse(dateStr);//这样可能会出 类型现转换异常
        return sd.parse(dateStr, new java.text.ParsePosition(0));
    }

    /**
     * 将指定字符(String)串转换成日期 (Date),格式是yyyy-MM-dd HH:mm:ss <br>
     * 如果发生错误，则返回 null, 格式不是yyyy-MM-dd HH:mm:ss也会返回null
     *
     * @param dateStr String 日期字符串
     * @return Date
     */
    public static Date strToDate(String dateStr) {
        return strToDate(dateStr, YMD_HMS);
    }

    /**
     * 将指定字符(String)串转换成日期 (Date),格式是yyyy-MM-dd HH:mm:ss <br>
     * 如果发生错误，则返回 null, 格式不是yyyy-MM-dd HH:mm:ss也会返回null
     *
     * @param dateStr String 日期字符串
     * @return Date
     */
    public static Date strToDateShort(String dateStr) {
        return strToDate(dateStr, YMD);
    }

    /**
     * 将指定日期(Date)对象转换成 格式化字符串 (String)
     *
     * @param date        Date 日期对象
     * @param datePattern String 日期格式
     * @return
     */
    public static String dateToStr(Date date, String datePattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        return sd.format(date);
    }

    /**
     * 将指定日期(Date)对象转换成 格式化字符串 (String),格式是yyyy-MM-dd HH:mm:ss
     *
     * @param date Date 日期对象
     * @return
     */
    public static String dateToStr(Date date) {
        return dateToStr(date, YMD_HMS);
    }

    /**
     * 将指定时间戳(timestamp) 转换成 格式化日期(Date),格式是yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(long timestamp) {
        return timestampToDate(timestamp, YMD_HMS);
    }

    /**
     * 将指定时间戳(timestamp) 转换成 格式化日期(Date)
     *
     * @param timestamp   时间戳
     * @param datePattern 日期格式
     * @return
     */
    public static Date timestampToDate(long timestamp, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        String dateStr = sd.format(timestamp);
        return sd.parse(dateStr, new java.text.ParsePosition(0));
    }

    /**
     * 获得当前时间的str格式，格式为yyMMddHHmmss
     *
     * @return
     */
    public static String today2Str() {
        Date date = new Date();
        return dateToStr(date, DatePatternEnum.YMD_HMS_.getCode());
    }

    /**
     * 获得当前时间的str格式，格式为yyMMddHHmmss
     *
     * @return
     */
    public static String today2Str(DatePatternEnum dateEnum) {
        Date date = new Date();
        return dateToStr(date, dateEnum.getCode());
    }

////////////////////////////////////////

    /**
     * 返回true表示 time1在time2前（time1与time2一样返回是false）
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isBefore(Date time1, Date time2) {
        long times = timeDiff(time1, time2);
        if (times > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回true表示 time1在time2后（time1与time2一样返回是false）
     *
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isAfter(Date time1, Date time2) {
        long times = timeDiff(time1, time2);
        if (times < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * time1与time2的时间差，返回单位是毫秒数 <br>
     * 返回值大于0, 表示time1 > time2
     * 返回值等于0, 表示time1 = time2
     * 返回值小于0, 表示time1 < time2
     *
     * @param time1 当前时间
     * @param time2 比较时间
     * @return
     */
    public static long timeDiff(Date time1, Date time2) {
        return time1.getTime() - time2.getTime();
    }

    /**
     * time1与time2的时间差在不在 seconds（秒值）之内
     * time1与time2的时间差是3s, seconds=3 返回true; seconds=5 返回true
     *
     * @param time1
     * @param time2
     * @param seconds
     * @return
     */
    public static boolean isBetweenTimeDiff(Date time1, Date time2, long seconds) {
        long timeDiff = timeDiff(time1, time2);
        long betweenTimeDiff = timeDiff - seconds * 1000;
        if (betweenTimeDiff <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 2个日期相差几天（由于底层算法是时间戳相减，所以2个时间是ymd格式的）
     * 如 01-02与 01-01 相差2天
     *
     * @param endTime
     * @param startTime
     * @return
     */
    public static Integer getBetweenCounts(Date endTime, Date startTime) {
//        //不能解决跨年的问题
//        int counts = 0;
//        if (endTime.getYear() == startTime.getYear()) {
//            int end = DateUtil.getDayOfYear(endTime);
//            int start = DateUtil.getDayOfYear(startTime);
//            counts = end - start + 1;
//        } else {
//            Long diffTime = (endTime.getTime() - startTime.getTime()) / (1000L * 3600 * 24);
//            counts = diffTime.intValue() + 1;
//        }
        // 推荐直接减
        Long diffTime = (endTime.getTime() - startTime.getTime()) / (1000L * 3600 * 24);
        int counts = diffTime.intValue() + 1;
        return counts;
    }


    /**
     * 获取日期的年份
     *
     * @param date 日期对象
     * @return
     */
    public static int getYear(Date date) {
        return get(date, Calendar.YEAR);
    }

    /**
     * 获取日期的月份(已加1处理了)
     * 如"2016-6-6 10:10:10",返回6
     *
     * @param date 日期对象
     * @return
     */
    public static int getMonth(Date date) {
        return get(date, Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的天数(月份的第几天)
     *
     * @param date 日期对象
     * @return
     */
    public static int getDayOfMonth(Date date) {
        return get(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期的天数(年份的第几天)
     *
     * @param date 日期对象
     * @return
     */
    public static int getDayOfYear(Date date) {
        return get(date, Calendar.DAY_OF_YEAR);
    }

    /**
     * 获得该年的第几周 （周日为第一天）
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        return get(date, Calendar.WEEK_OF_YEAR);
    }

    /**
     * 如果需要将int 转成 String，请用 String.valueOf()方法
     *
     * @param date
     * @param field 日期类型
     * @return
     */
    private static int get(Date date, int field) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(field);
    }

    /**
     * 获得该年的第几周 (中国的记录方式：周一为第一天)
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear2Zh(Date date) {
        Calendar c = Calendar.getInstance();
        //设置每周开始的时间
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取某个日期该月有多少天(该月最大天数)
     * 如 1月 是31天
     *
     * @param date 日期对象
     * @return
     */
    public static int getMaxDaysOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取日期的星期(国际的记录方式), 周日为一周第一天,即 1 周日  2周一  7周六
     *
     * @param date 日期对象
     * @return
     */
    public static int getWeek(Date date) {
        return get(date, Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取日期的星期 (中国的记录方式), 周一为一周第一天,即 1 周一  2周二  7周日
     *
     * @param date 日期对象
     * @return
     */
    public static int getWeek2Zh(Date date) {
        int week = getWeek(date);
        if (week == 1) {
            week = 7;
        } else {
            week--;
        }
        return week;
    }

    public static int getWeek2Zh(Calendar c) {
        int week = c.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            week = 7;
        } else {
            week--;
        }

        return week;
    }

    /**
     * 判断日期 是不是周末,true表示是周末
     *
     * @param date 日期对象
     * @return true表示该日期是周末
     */
    public static boolean isWeekend(Date date) {
        // 获取当前日期星期，英国算法(周日为一周第一天)
        int week = getWeek(date);
        // 如果是周六或周日就返回true
        if (week == 7 || week == 1) {
            return true;
        }
        return false;
    }


    /**
     * 指定date 增加天数、小时、分钟或秒数
     *
     * @param date
     * @param field 日期类型
     * @param num   数值，天数、小时、分钟或秒数，可以是负值
     */
    private static Date add(Date date, int field, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, num);
        return c.getTime();
    }

    /**
     * 指定date 增加years年，可以是负值
     *
     * @param years
     */
    public static Date addYear(int years) {
        return addYear(new Date(), years);
    }

    /**
     * 指定date 增加years年，可以是负值
     *
     * @param date
     * @param years
     */
    public static Date addYear(Date date, int years) {
        return add(date, Calendar.YEAR, years);
    }

    /**
     * 指定date 增加months月，可以是负值
     *
     * @param months
     */
    public static Date addMonth(int months) {
        return addMonth(new Date(), months);
    }

    /**
     * 指定date 增加months月，可以是负值
     *
     * @param date
     * @param months
     */
    public static Date addMonth(Date date, int months) {
        return add(date, Calendar.MONTH, months);
    }

    /**
     * 指定date 增加days天，可以是负值
     *
     * @param days
     */
    public static Date addDay(int days) {
        return addDay(new Date(), days);
    }

    /**
     * 指定date 增加days天，可以是负值
     *
     * @param date
     * @param days
     */
    public static Date addDay(Date date, int days) {
        return add(date, Calendar.DATE, days);
    }

    /**
     * 指定date 增加hour小时，可以是负值
     *
     * @param hours
     */
    public static Date addHour(int hours) {
        return addHour(new Date(), hours);
    }

    /**
     * 指定date 增加hour小时，可以是负值
     *
     * @param date
     * @param hours
     */
    public static Date addHour(Date date, int hours) {
        return add(date, Calendar.HOUR, hours);
    }

    /**
     * 指定date 增加minutes分钟，可以是负值
     *
     * @param minutes
     */
    public static Date addMinute(int minutes) {
        return addMinute(new Date(), minutes);
    }

    /**
     * 指定date 增加minutes分钟，可以是负值
     *
     * @param date
     * @param minutes
     */
    public static Date addMinute(Date date, int minutes) {
        return add(date, Calendar.MINUTE, minutes);
    }

    /**
     * 指定date 增加seconds秒，可以是负值
     *
     * @param seconds
     */
    public static Date addSecond(int seconds) {
        return addSecond(new Date(), seconds);
    }

    /**
     * 指定date 增加seconds秒，可以是负值
     *
     * @param date
     * @param seconds
     */
    public static Date addSecond(Date date, int seconds) {
        return add(date, Calendar.SECOND, seconds);
    }


////////////////////////////////////////

//    /**
//     * 获取当前日期的开始时间
//     *
//     * @return
//     */
//    public static Date getStartTime() {
//        return getStartTime(new Date());
//    }

    /**
     * 获取某个日期的开始时间<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-6 0:00:00"
     *
     * @param date 日期对象
     */
    public static Date getStartTime(Date date) {
        return getStartTime(date, 0);
    }

    /**
     * 获取某个日期加上days 的开始时间<br/>
     * 如"2016-6-6 10:10:10" 调用getStartTime(date, 2) 即后天的开始时间
     * 返回"2016-6-8 0:00:00"
     *
     * @param date
     * @param addDays
     */
    public static Date getStartTime(Date date, int addDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, addDays);
        initFirst(c);
        return c.getTime();
    }

//    /**
//     * 获得当前日期的结束时间
//     *
//     * @return
//     */
//    public static Date getEndTime() {
//        return getEndTime(new Date());
//    }

    /**
     * 获取某个日期的结束时间<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-6 23:59:59"
     *
     * @param date 日期对象
     */
    public static Date getEndTime(Date date) {
        return getEndTime(date, 0);
    }

    /**
     * 获取某个日期加上days 结束时间<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-6 23:59:59"
     *
     * @param date 日期对象
     * @return
     */
    public static Date getEndTime(Date date, int addDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, addDays);
        initLast(c);
        return c.getTime();
    }

    /**
     * 获取某个日期的结束时间<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-7 0:00:00"<br/>
     * 获取的不是"2016-6-6 23:59:59",为了避免出现转点的问题
     *
     * @param date 日期对象
     * @return
     */
    public static Date getEndTimeOf24(Date date) {
        //第二天的开始，就是第一天的结束
        return getStartTime(date, 1);
    }

    /**
     * 获取某个日期加上days 的结束时间<br/>
     * 如"2016-6-6 10:10:10" 调用getEndTime(date, 2) 即后天的结束时间
     * 返回"2016-6-9 0:00:00"<br/>
     * 获取的不是"2016-6-8 23:59:59",为了避免出现转点的问题
     *
     * @param date
     * @param addDays
     * @return
     */
    public static Date getEndTimeOf24(Date date, int addDays) {
        //(addDays+1)的开始，就是addDays的结束
        return getStartTime(date, addDays + 1);
    }

    /**
     * 获取某个日期该周的第一天（周一）<br/>
     * 如"2016-6-6 10:10:10 周一",返回"2016-6-6 0:00:00"
     * 如"2016-6-8 10:10:10 周三",返回"2016-6-6 0:00:00"
     *
     * @param date 日期对象
     * @return
     */
    public static Date getFirstDayOfWeek2zh(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int week2Zh = getWeek2Zh(c);
        //需要减几天
        c.add(Calendar.DAY_OF_MONTH, 1 - week2Zh);
        initFirst(c);
        return c.getTime();
    }

    /**
     * 获取某个日期指定月份第一天的日期<br/>
     * 如"2016-6-6 10:10:10",指定为5月,返回"2016-5-1 0:00:00"
     *
     * @param date           指定日期
     * @param specifiedMonth 指定月份
     * @return
     */
    public static Date getFirstDayOfMonth(Date date, int specifiedMonth) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, specifiedMonth - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        initFirst(c);
        return c.getTime();
    }

    /**
     * 获取当年指定月份第一天的日期<br/>
     * 如"2016-6-6 10:10:10",指定为5月,返回"2016-5-1 0:00:00"
     *
     * @param specifiedMonth 指定月份
     * @return
     */
    public static Date getFirstDayOfMonth(int specifiedMonth) {
        return getFirstDayOfMonth(new Date(), specifiedMonth);
    }

    /**
     * 获取某个日期该月的第一天<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-1 0:00:00"
     *
     * @param date 日期对象
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        return getFirstDayByAddMonth(date, 0);
    }

    /**
     * 获取某个日期 添加月的第一天的开始时间
     * <pre>
     * 	getFirstDayByAddMonth(date, 1), 返回下个月的第一天的开始时间
     * 	getFirstDayByAddMonth(date, -1), 返回上个月的第一天的开始时间
     * </pre>
     * 如"2016-6-6 10:10:10" getFirstDayByAddMonth(date, 1), 返回下个月的第一天 即"2016-7-1 0:00:00"
     * 如"2016-6-6 10:10:10" getFirstDayByAddMonth(date, -1), 返回上个月的第一天 即"2016-5-1 0:00:00"
     *
     * @param date     日期对象
     * @param addMonth 添加的月份数字
     * @return
     */
    public static Date getFirstDayByAddMonth(Date date, int addMonth) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, addMonth);
        c.set(Calendar.DAY_OF_MONTH, 1);
        initFirst(c);
        return c.getTime();
    }

    /**
     * 获取某个日期该月的最后一天<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-30 23:59:59"
     *
     * @param date           日期对象
     * @param specifiedMonth 日期对象
     * @return
     */
    public static Date getLastDayOfMonth(Date date, int specifiedMonth) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MONTH, specifiedMonth - 1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
        initLast(c);
        return c.getTime();
    }

//    /**
//     * 获取某个日期该月的最后一天<br/>
//     * 如"2016-6-6 10:10:10",返回"2016-7-1 00:00:00"
//     * 获取的不是"2016-6-30 23:59:59",为了避免出现转点的问题
//     *
//     * @param date 日期对象
//     * @return
//     */
//    public static Date getLastDay2FirstOfMonth(Date date, int specifiedMonth) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.MONTH, specifiedMonth);
//        c.set(Calendar.DAY_OF_MONTH, 1);
//        initFirst(c);
//        return c.getTime();
//    }

    /**
     * 获取某个日期该月的最后一天<br/>
     * 如"2016-6-6 10:10:10",返回"2016-6-30 23:59:59"
     *
     * @param specifiedMonth 指定月份
     * @return
     */
    public static Date getLastDayOfMonth(int specifiedMonth) {
        return getLastDayOfMonth(new Date(), specifiedMonth);
    }

    /**
     * 获取某个日期该月的最后一天<br/>
     * 如"2016-6-6 10:10:10",返回"2016-7-1 00:00:00"
     * 获取的不是"2016-6-30 23:59:59",为了避免出现转点的问题
     *
     * @param date 日期对象
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        return getLastDayByAddMonth(date, 0);
    }


    /**
     * 获取某个日期 添加月的最后一天结束时间<br/>
     * <pre>
     * 	getLastDayByAddMonth(date, 1), 返回下个月的最后一天的结束时间, 即下2个月的开始时间
     * 	getLastDayByAddMonth(date, -1), 返回上个月的最后一天的结束时间, 即这个月的开始时间
     * </pre>
     * 如"2016-6-6 10:10:10" getLastDayByAddMonth(date, 1), 返回"2016-7-31 23:59:59" 即"2016-8-1 0:00:00"
     * 如"2016-6-6 10:10:10" getFirstDayByAddMonth(date, -1), 返回"2016-5-1 23:59:59" 即"2016-6-1 0:00:00"
     *
     * @param date     日期对象
     * @param addMonth 添加的月份数字
     * @return
     */
    public static Date getLastDayByAddMonth(Date date, int addMonth) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, addMonth);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
        initLast(c);
        return c.getTime();
    }

//    public static Date getLastDay2FirstByAddMonth(Date date, int addMonth) {
//        return getFirstDayByAddMonth(date, (addMonth + 1));
//    }

    /**
     * 时分秒格式化为 00:00:00
     */
    private static void initFirst(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 时分秒格式化为 23:59:59
     */
    private static void initLast(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 获取某个日期今年的第一天<br/>
     * 如"2016-6-6 10:10:10",返回"2016-1-1 0:00:00"
     * 与public static Date getFirstDayOfMonth(1) 方法相同了
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfYear(Date date) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.set(Calendar.MONTH, 0);//月份从0开始
//        c.set(Calendar.DAY_OF_MONTH, 1);
//        initFirst(c);
//        return c.getTime();
        // 获得指定月份的开始时间
        return getFirstDayOfMonth(date, 1);
    }

}
