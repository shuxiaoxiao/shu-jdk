package com.shuframework.jdk7.lang;

import java.util.Calendar;
import java.util.Date;

/**
 * Date工具类 Date 、String 、XMLGregorianCalendar 3种类型的转换<br/>
 * 以及日期的常见操作,底层依赖的是java.util.Calendar
 * 
 * @author shu
 */
public class DateUtil {
//	/**日期格式为yyyy-MM-dd HH:mm:ss.SSS*/
//	public static final String YMD_HMS_S ="yyyy-MM-dd HH:mm:ss.SSS";
//	/**日期格式为yyyy-MM-dd HH:mm:ss*/
//	public static final String YMD_HMS ="yyyy-MM-dd HH:mm:ss";
//	/**日期格式为yyyy-MM-dd*/
//	public static final String YMD ="yyyy-MM-dd";
//	public static final int YEAR = 1;
//	public static final int MOUTH = 2;
//	public static final int WEEK_OF_YEAR = 3;
//	public static final int WEEK_OF_MONTH = 4;
	/**天*/
	public static final int DAY = 5;
	/**时(12小时制)*/
	public static final int HOUR = 10;
	/**时(24小时制)*/
	public static final int HOUR_OF_DAY = 11;
	/**分钟*/
	public static final int MINUTE = 12;
	/**秒*/
	public static final int SECOND = 13;
	/**毫秒*/
	public static final int MILLISECOND = 14;

	
	/**
	 * time1与time2的时间差，返回单位是毫秒数 <br>
	 * 返回值大于0, 表示time1 > time2 
	 * 返回值等于0, 表示time1 = time2 
	 * 返回值小于0, 表示time1 < time2 
	 * 
	 * @param time1	当前时间
	 * @param time2	比较时间
	 * @return
	 */
	public static long timeDiff(Date time1, Date time2) {
		return time1.getTime() - time2.getTime();
	}
	
	/**
	 * time1与time2的时间差,设定了type则根据其返回<br/>
	 * 结果都是整型,默认的取整方式(向上取整),如0.6返回是0
	 * @param time1	当前时间
	 * @param time2	比较时间
	 * @param type	获取时间类型——DateUtil.DAY(天)、DateUtil.HOUR(小时)、DateUtil.MINUTE(分钟)、DateUtil.SECOND(秒)
	 * @return
	 */
	public static long timeDiff(Date time1, Date time2, int type) {
		long times = time1.getTime() - time2.getTime();
		switch (type) {
			case DateUtil.DAY:
				times = times / 1000 /3600 /24;
				break;
			case DateUtil.HOUR:
				times = times / 1000 /3600;
				break;
			case DateUtil.MINUTE:
				times = times / 1000 /60;
				break;
			case DateUtil.SECOND:
				times = times / 1000;
				break;
		}
		return times;
	}
	
	/**
	 * time1与time2的时间差，没有type返回单位是毫秒数,设定了type则根据其返回,结果都是整型,依据四舍五入
	 * 
	 * @param time1	当前时间
	 * @param time2	比较时间
	 * @param type	获取时间类型——DateUtil.DAY(天)、DateUtil.HOUR(小时)、DateUtil.MINUTE(分钟)、DateUtil.SECOND(秒)
	 * @return
	 */
	public static long timeDiff2(Date time1, Date time2, int type) {
		long times = time1.getTime() - time2.getTime();
		switch (type) {
		case DateUtil.DAY:
			times = (long) (times / 1000.0 /3600 /24 + 0.5);
			break;
		case DateUtil.HOUR:
			times = (long) (times / 1000.0 /3600 + 0.5);
			break;
		case DateUtil.MINUTE:
			times = (long) (times / 1000.0 /60 + 0.5);
			break;
		case DateUtil.SECOND:
			times = (long) (times / 1000.0 + 0.5);
			break;
		}
		return times;
	}
	
	/**
	 * time1与time2的时间差，没有type返回单位是毫秒数,设定了type则根据其返回
	 * 
	 * @param time1	当前时间
	 * @param time2	比较时间
	 * @param type	获取时间类型——DateUtil.HOUR(小时)、DateUtil.MINUTE(分钟)、DateUtil.SECOND(秒)
	 * @return
	 */
	public static double timeDiff2Double(Date time1, Date time2, int type) {
		double times = time1.getTime() - time2.getTime();
		switch (type) {
		case DateUtil.HOUR:
			times = times / 1000.0 /3600;
			break;
		case DateUtil.MINUTE:
			times = times / 1000.0 /60;
			break;
		case DateUtil.SECOND:
			times = times / 1000.0;
			break;
		}
		return times;
	}
	
	/**
	 * 获取日期的年份
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 如果需要将int 转成 String，请用 String.valueOf()方法
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取日期的月份
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取日期的天数
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DATE);
	}
	
	/**
	 * 获取日期的星期(国际的记录方式), 周日为一周第一天,即 1 周日  2周一  7周六
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 获取日期的星期 (中国的记录方式), 周一为一周第一天,即 1 周一  2周二  7周日
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getWeek2Zh(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK);
		if(week == 1){
			week = 7;
		}else{
			week --;
		}
		
		return week;
	}

	/**
	 * 判断日期 是不是周末,true表示是周末
	 * 	 
	 * @param date	日期对象
	 * @return true表示该日期是周末
	 */
	public static boolean isWeekend(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 获取当前日期星期，英国算法(周日为一周第一天)
		int day = c.get(Calendar.DAY_OF_WEEK);
		// 如果是周六或周日就返回true
		if (day == 7 || day == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 指定date 增加天数、小时、分钟或秒数
	 * @param date
	 * @param num 数值，天数、小时、分钟或秒数，可以是负值
	 * @param type	类型——DateUtil.DAY(天)、DateUtil.HOUR(小时)、DateUtil.MINUTE(分钟)、DateUtil.SECOND(秒)
	 */
	private static Date addDayOrHourOrMinuteOrSecond(Date date, int num, int type) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		switch (type) {
			case DateUtil.DAY:
				c.add(Calendar.DAY_OF_MONTH, num);
				break;
			case DateUtil.HOUR:
				c.add(Calendar.HOUR, num);
				break;
			case DateUtil.MINUTE:
				c.add(Calendar.MINUTE, num);
				break;
			case DateUtil.SECOND:
				c.add(Calendar.SECOND, num);
				break;
		}
		
		return c.getTime();
	}
	
	/**
	 * 指定date 增加days天，可以是负值
	 * @param date
	 * @param days
	 */
	public static Date addDay(Date date, int days) {
		return addDayOrHourOrMinuteOrSecond(date, days, DateUtil.DAY);
	}
	
	/**
	 * 指定date 增加hour小时，可以是负值
	 * @param date
	 * @param hours
	 */
	public static Date addHour(Date date, int hours) {
		return addDayOrHourOrMinuteOrSecond(date, hours, DateUtil.HOUR);
	}
	
	/**
	 * 指定date 增加minutes分钟，可以是负值
	 * @param date
	 * @param minutes
	 */
	public static Date addMinute(Date date, int minutes) {
		return addDayOrHourOrMinuteOrSecond(date, minutes, DateUtil.MINUTE);
	}
	
	/**
	 * 指定date 增加seconds秒，可以是负值
	 * @param date
	 * @param seconds
	 */
	public static Date addSecond(Date date, int seconds) {
		return addDayOrHourOrMinuteOrSecond(date, seconds, DateUtil.SECOND);
	}

	/**
	 * 获取某个日期该月有多少天
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 获取某个日期的开始时间<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-6 0:00:00"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getStartTimeOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取某个日期的结束时间<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-7 0:00:00"<br/>
	 * 获取的不是"2016-6-6 23:59:59",为了避免出现转点的问题
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getEndTimeOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 24);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
//	//与上面的效果相同
//	public static Date getEndTime(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.add(Calendar.DAY_OF_MONTH, 1);
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		return c.getTime();
//	}
	
	/**
	 * 获取某个日期指定月份第一天的日期<br/>
	 * 如"2016-6-6 10:10:10",指定为5月,返回"2016-5-1 0:00:00"
	 * 
	 * @param date	指定日期
	 * @param specifiedMonth	指定月份 
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date, int specifiedMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, specifiedMonth - 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取当年指定月份第一天的日期<br/>
	 * 如"2016-6-6 10:10:10",指定为5月,返回"2016-5-1 0:00:00"
	 * 
	 * @param specifiedMonth	指定月份 
	 * @return
	 */
	public static Date getFirstDayOfMonth(int specifiedMonth) {
		return getFirstDayOfMonth(new Date(), specifiedMonth);
	}
	
	/**
	 * 获取某个日期该月的第一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-1 0:00:00"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取某个日期该月的最后一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-30 23:59:59"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date, int specifiedMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, specifiedMonth - 1);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 获取某个日期该月的最后一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-30 23:59:59"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getLastDayOfMonth(int specifiedMonth) {
		return getLastDayOfMonth(new Date(), specifiedMonth);
	}
	
	/**
	 * 获取某个日期该月的最后一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-30 23:59:59"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * 获取某个日期下个月的第一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-7-1 0:00:00"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getFirstDayOfNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取某个日期上个月的第一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-5-1 0:00:00"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getFirstDayOfLastMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

}
