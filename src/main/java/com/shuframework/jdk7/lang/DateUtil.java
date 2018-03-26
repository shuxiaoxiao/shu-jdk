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
	
	//这块的常量修改为枚举了
//	/**天*/
//	public static final int DAY = 5;
//	/**时(12小时制)*/
//	public static final int HOUR = 10;
//	/**时(24小时制)*/
//	public static final int HOUR_OF_DAY = 11;
//	/**分钟*/
//	public static final int MINUTE = 12;
//	/**秒*/
//	public static final int SECOND = 13;
//	/**毫秒*/
//	public static final int MILLISECOND = 14;

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
	 * 获取日期的月份(已加1处理了)
	 * 如"2016-6-6 10:10:10",返回6
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
	 * 获取日期的天数(月份的第几天)
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
	 * 获取某个日期该月有多少天
	 * 如 1月 是31天
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static int getActualDaysOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DATE);
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
	 * 返回true表示 time1在time2前（time1与time2一样返回是false）
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isBefore(Date time1, Date time2) {
		long times = timeDiff(time1, time2);
		if(times > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 返回true表示 time1在time2后（time1与time2一样返回是false）
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean isAfter(Date time1, Date time2) {
		long times = timeDiff(time1, time2);
		if(times < 0){
			return true;
		}else{
			return false;
		}
	}
	
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
		if(betweenTimeDiff <= 0){
			return true;
		}else{
			return false;
		}
	}
	
// 一般不需要这样处理	
//	/**
//	 * time1与time2的时间差,设定了type则根据其返回<br/>
//	 * 结果都是整型,默认的取整方式(向上取整),如0.6返回是0
//	 * @param time1	当前时间
//	 * @param time2	比较时间
//	 * @param dateEnum	获取时间类型——DateEnum.DAY(天)、DateEnum.HOUR24(小时)、DateEnum.MINUTE(分钟)、DateEnum.SECOND(秒)
//	 * @return
//	 */
//	public static long timeDiff(Date time1, Date time2, DateEnum dateEnum) {
//		long times = time1.getTime() - time2.getTime();
//		switch (dateEnum) {
//			case DAY:
//				times = times / 1000 / 3600 / 24;
//				break;
//			case HOUR24:
//				times = times / 1000 / 3600;
//				break;
//			case MINUTE:
//				times = times / 1000 / 60;
//				break;
//			case SECOND:
//				times = times / 1000;
//				break;
//			default:
//				// 默认是毫秒
//				break;
//		}
//		return times;
//	}
//	
//	/**
//	 * time1与time2的时间差，没有type返回单位是毫秒数,设定了type则根据其返回,结果都是整型,依据四舍五入
//	 * 
//	 * @param time1	当前时间
//	 * @param time2	比较时间
//	 * @param dateEnum	获取时间类型——DateEnum.DAY(天)、DateEnum.HOUR24(小时)、DateEnum.MINUTE(分钟)、DateEnum.SECOND(秒)
//	 * @return
//	 */
//	public static long timeDiff2(Date time1, Date time2, DateEnum dateEnum) {
//		long times = time1.getTime() - time2.getTime();
//		switch (dateEnum) {
//			case DAY:
//				times = (long) (times / 1000.0 /3600 /24 + 0.5);
//				break;
//			case HOUR24:
//				times = (long) (times / 1000.0 /3600 + 0.5);
//				break;
//			case MINUTE:
//				times = (long) (times / 1000.0 /60 + 0.5);
//				break;
//			case SECOND:
//				times = (long) (times / 1000.0 + 0.5);
//				break;
//			default:
//				// 默认是毫秒
//				break;
//		}
//		return times;
//	}
//	
//	/**
//	 * time1与time2的时间差，没有type返回单位是毫秒数,设定了type则根据其返回
//	 * 
//	 * @param time1	当前时间
//	 * @param time2	比较时间
//	 * @param dateEnum	获取时间类型——DateEnum.DAY(天)、DateEnum.HOUR24(小时)、DateEnum.MINUTE(分钟)、DateEnum.SECOND(秒)
//	 * @return
//	 */
//	public static double timeDiff2Double(Date time1, Date time2, DateEnum dateEnum) {
//		double times = time1.getTime() - time2.getTime();
//		switch (dateEnum) {
//			case HOUR24:
//				times = times / 1000.0 /3600;
//				break;
//			case MINUTE:
//				times = times / 1000.0 /60;
//				break;
//			case SECOND:
//				times = times / 1000.0;
//				break;
//			default:
//				break;
//		}
//		return times;
//	}
	
	
	/**
	 * 指定date 增加天数、小时、分钟或秒数
	 * @param date
	 * @param num 数值，天数、小时、分钟或秒数，可以是负值
	 * @param dateEnum	类型——DateEnum.DAY(天)、DateEnum.HOUR24(小时)、DateEnum.MINUTE(分钟)、DateEnum.SECOND(秒)
	 */
	private static Date addDayOrHourOrMinuteOrSecond(Date date, int num, DateTimeEnum dateEnum) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		switch (dateEnum) {
			case DAY:
				c.add(Calendar.DAY_OF_MONTH, num);
				break;
			case HOUR24:
				c.add(Calendar.HOUR, num);
				break;
			case MINUTE:
				c.add(Calendar.MINUTE, num);
				break;
			case SECOND:
				c.add(Calendar.SECOND, num);
				break;
			default:
				break;
		}
		
		return c.getTime();
	}
	
	/**
	 * 指定date 增加days天，可以是负值
	 * @param days
	 */
	public static Date addDay(int days) {
		return addDayOrHourOrMinuteOrSecond(new Date(), days, DateTimeEnum.DAY);
	}
	
	/**
	 * 指定date 增加days天，可以是负值
	 * @param date
	 * @param days
	 */
	public static Date addDay(Date date, int days) {
		return addDayOrHourOrMinuteOrSecond(date, days, DateTimeEnum.DAY);
	}
	
	/**
	 * 指定date 增加hour小时，可以是负值
	 * @param hours
	 */
	public static Date addHour(int hours) {
		return addDayOrHourOrMinuteOrSecond(new Date(), hours, DateTimeEnum.HOUR24);
	}
	
	/**
	 * 指定date 增加hour小时，可以是负值
	 * @param date
	 * @param hours
	 */
	public static Date addHour(Date date, int hours) {
		return addDayOrHourOrMinuteOrSecond(date, hours, DateTimeEnum.HOUR24);
	}
	
	/**
	 * 指定date 增加minutes分钟，可以是负值
	 * @param minutes
	 */
	public static Date addMinute(int minutes) {
		return addDayOrHourOrMinuteOrSecond(new Date(), minutes, DateTimeEnum.MINUTE);
	}
	
	/**
	 * 指定date 增加minutes分钟，可以是负值
	 * @param date
	 * @param minutes
	 */
	public static Date addMinute(Date date, int minutes) {
		return addDayOrHourOrMinuteOrSecond(date, minutes, DateTimeEnum.MINUTE);
	}
	
	/**
	 * 指定date 增加seconds秒，可以是负值
	 * @param seconds
	 */
	public static Date addSecond(int seconds) {
		return addDayOrHourOrMinuteOrSecond(new Date(), seconds, DateTimeEnum.SECOND);
	}
	
	/**
	 * 指定date 增加seconds秒，可以是负值
	 * @param date
	 * @param seconds
	 */
	public static Date addSecond(Date date, int seconds) {
		return addDayOrHourOrMinuteOrSecond(date, seconds, DateTimeEnum.SECOND);
	}

	
	/**
	 * 获取当前日期的开始时间
	 * @return
	 */
	public static Date getStartTime() {
		return getStartTime(new Date());
	}
	
	/**
	 * 获取某个日期的开始时间<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-6 0:00:00"
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getStartTime(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		return c.getTime();
		return getStartTime(date, 0);
	}
	
	/**
	 * 获取某个日期加上days 的开始时间<br/>
	 * 如"2016-6-6 10:10:10" 调用getStartTime(date, 2) 即后天的开始时间
	 * 返回"2016-6-8 0:00:00"
	 * 
	 * @param date
	 * @param addDays
	 * @return
	 */
	public static Date getStartTime(Date date, int addDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, addDays);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获得当前日期的结束时间
	 * @return
	 */
	public static Date getEndTime() {
		return getEndTime(new Date());
	}
	
	/**
	 * 获取某个日期的结束时间<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-6-7 0:00:00"<br/>
	 * 获取的不是"2016-6-6 23:59:59",为了避免出现转点的问题
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getEndTime(Date date) {
		//第二天的开始，就是第一天的结束
		return getStartTime(date, 1);
	}
//	//与上面的效果相同
//	public static Date getEndTime(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.HOUR_OF_DAY, 24);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		return c.getTime();
//	}

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
	public static Date getEndTime(Date date, int addDays) {
		//(addDays+1)的开始，就是addDays的结束
		return getStartTime(date, addDays + 1);
	}

	
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
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.DAY_OF_MONTH, 1);
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		return c.getTime();
		return getFirstDayByAddMonth(date, 0);
	}
	
	/**
	 * 获取某个日期该月的最后一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-7-1 00:00:00"
	 * 获取的不是"2016-6-30 23:59:59",为了避免出现转点的问题
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date, int specifiedMonth) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.MONTH, specifiedMonth - 1);
//		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
//		c.set(Calendar.HOUR_OF_DAY, 23);
//		c.set(Calendar.MINUTE, 59);
//		c.set(Calendar.SECOND, 59);
//		return c.getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, specifiedMonth);
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
	public static Date getLastDayOfMonth(int specifiedMonth) {
		return getLastDayOfMonth(new Date(), specifiedMonth);
	}
	
	/**
	 * 获取某个日期该月的最后一天<br/>
	 * 如"2016-6-6 10:10:10",返回"2016-7-1 00:00:00"
	 * 获取的不是"2016-6-30 23:59:59",为了避免出现转点的问题
	 * 
	 * @param date	日期对象
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
//		c.set(Calendar.HOUR_OF_DAY, 23);
//		c.set(Calendar.MINUTE, 59);
//		c.set(Calendar.SECOND, 59);
//		return c.getTime();
		return getLastDayByAddMonth(date, 0);
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
	 * @param date	日期对象
	 * @param addMonth	添加的月份数字
	 * @return
	 */
	public static Date getFirstDayByAddMonth(Date date, int addMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, addMonth);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
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
	 * @param date	日期对象
	 * @param addMonth	添加的月份数字
	 * @return
	 */
	public static Date getLastDayByAddMonth(Date date, int addMonth) {
		return getFirstDayByAddMonth(date, (addMonth + 1));
	}

}
