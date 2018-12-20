package com.shuframework.jdk8.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * jdk8 的日期 示例
 * 	需要注意的是jdk8 的日期类都是不可变且线程安全，每次操作后返回的都是新对象
 * Instant		它代表的是时间戳
 * Clock		时钟，用来获取某个时区下（所以对时区是敏感的）当前的瞬时时间、日期。用来代替System.currentTimelnMillis()与TimeZone.getDefault()方法
 * LocalDate	不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等
 * LocalTime		它代表的是不含日期的时间
 * LocalDateTime	它包含了日期及时间，不过还是没有偏移信息或者说时区
 * ZonedDateTime 	这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的
 * 
 * Duration		用来计算两个给定的日期之间包含多少秒，多少毫秒
 * Period		用来计算两个给定的日期之间包含多少天，多少月或者多少年
 * @author shu
 *
 */
public class LocalDateDemo {
	
	/**
	 * java.time.Instant的初始化 类似于之前的java.util.Date
	 * jdkutil System.currentTimeMillis()与date.getTime() 都能获得当前时间毫秒数
	 * jdk8 Instant.now().toEpochMilli() 获得当前时间毫秒数
	 */
	@Test
	public void instant_init_test() {
		Date date = new Date();
		System.out.println(System.currentTimeMillis());
		System.out.println(date.getTime());

		Instant today = date.toInstant();
//		Instant today = Instant.now();
		System.out.println(today);//2017-12-13T07:27:31.902Z
		System.out.println(today.getEpochSecond());//秒
		System.out.println(today.toEpochMilli());//毫秒
		
		System.out.println(Instant.now().toEpochMilli());//毫秒
		System.out.println(Clock.systemUTC().millis());//毫秒
	}
	
	@Test
	public void clock_init_test() {
		Clock clock = Clock.systemUTC();
		System.out.println("Clock : " + clock.millis());
	}
	
	/**
	 * java.time.LocalDate的初始化
	 * 	now()
	 * 	of(int year, int month, int dayOfMonth)
	 */
	@Test
	public void localDate_init_test() {
		LocalDate today = LocalDate.now();
		System.out.println(today);//2017-12-13, 重写了toString()
		
		//年份的检查有点奇怪，范围是[Year.MIN_VALUE, Year.MAX_VALUE] 即[-999_999_999, +999_999_999]
		LocalDate date = LocalDate.of(2017, 5, 30);
		System.out.println(date);//2017-05-30
	}
	
	/**
	 * java.time.LocalDate的初始化
	 * 	now()
	 * 	of(int year, int month, int dayOfMonth)
	 */
	@Test
	public void localDateTime_init_test() {
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);//2017-12-13T11:25:23.168
		
		//年份的检查有点奇怪，范围是[Year.MIN_VALUE, Year.MAX_VALUE] 即[-999_999_999, +999_999_999]
		LocalDateTime date = LocalDateTime.of(2017, 12, 13, 10, 0);
//		LocalDateTime date = LocalDateTime.of(2017, 12, 13, 10, 0, 0);
//		LocalDateTime date = LocalDateTime.of(2017, 12, 13, 10, 0, 0, 100);
		System.out.println(date);//2017-12-13T10:00
	}
	
	/**
	 * java.time.YearMonth的初始化
	 * 	now()
	 * 	of(int month, int dayOfMonth)
	 * 	from(TemporalAccessor temporal)
	 */
	@Test
	public void yearMonth_init_test() {
		YearMonth yearMonth = YearMonth.now();
		System.out.println("YearMonth:" + yearMonth);//2017-12
		
		YearMonth yearMonth2 = YearMonth.of(2017,  12);
		System.out.println("YearMonth2:" + yearMonth2);//--12-13
		
		YearMonth yearMonth3 = YearMonth.from(LocalDate.now());
		System.out.println("YearMonth3:" + yearMonth3);//--12-13
	}
	
	/**
	 * java.time.MonthDay的初始化
	 * 	now()
	 * 	of(int month, int dayOfMonth)
	 * 	from(TemporalAccessor temporal)
	 */
	@Test
	public void monthDay_init_test() {
		MonthDay monthDay = MonthDay.now();
		System.out.println("MonthDay:" + monthDay);//2017-12
		
		MonthDay monthDay2 = MonthDay.of(12,  13);
		System.out.println("MonthDay2:" + monthDay2);//2017-12
		
		MonthDay monthDay3 = MonthDay.from(LocalDate.now());
		System.out.println("MonthDay3:" + monthDay3);//2017-12
	}
	
	/**
	 * java.time.MonthDay的初始化
	 * 	now()
	 * 	of(int hour, int minute)
	 * 	of(int hour, int minute, int second)
	 * 	of(int hour, int minute, int second, int nanoOfSecond)
	 * 	from(TemporalAccessor temporal)
	 */
	@Test
	public void localTime_init_test() {
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime:" + localTime);//11:25:23.170
		
		LocalTime localTime2 = LocalTime.of(12,  13);
		System.out.println("LocalTime2:" + localTime2);//12:13
		
		//LocalDate没时间, LocalDateTime才有时间
		LocalTime localTime3 = LocalTime.from(LocalDateTime.now());
		System.out.println("LocalTime3:" + localTime3);//11:25:23.170
	}
	
	/**
	 * 判断今天是不是某个特殊的日子，比如生日啊，周年纪念日
	 */
	@Test
	public void equals_test() {
		LocalDate date1 = LocalDate.now();
		//年份的检查有点奇怪，范围是[Year.MIN_VALUE, Year.MAX_VALUE] 即[-999_999_999, +999_999_999]
		LocalDate date2 = LocalDate.of(2017, 12, 13);
		System.out.println(date1.equals(date2));
		
		MonthDay monthDay1 = MonthDay.now();
		MonthDay monthDay2 = MonthDay.of(12,  13);
		MonthDay monthDay3 = MonthDay.of(11,  13);
		System.out.println(monthDay1.equals(monthDay2));//true
		System.out.println(monthDay1.equals(monthDay3));//false
	}
	
	/**
	 * 判断2个日期的大小，调用的还是compareTo()，底层实现是每个部分拆开比较
	 */
	@Test
	public void beforeOrAfter_test() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = date1.plusDays(1);
		System.out.println(date1.isBefore(date2));//true
		System.out.println(date1.isAfter(date2));//false
		
		LocalDateTime datetime1 = LocalDateTime.now();
		LocalDateTime datetime2 = datetime1.plusDays(1);
		System.out.println(datetime1.isBefore(datetime2));//true
		System.out.println(datetime1.isAfter(datetime2));//false
		
		System.out.println(date1.compareTo(date2));//-1
		System.out.println(datetime1.compareTo(datetime2));//-1
	}
	
	/**
	 * 获得年月日
	 */
	@Test
	public void localDate_test1() {
		LocalDate today = LocalDate.now();
		//Today's Local date : 2017-12-13, 重写了toString()
		System.out.println("Today's Local date : " + today);
		
		//年
		int year = today.getYear();
		//月
		int month = today.getMonthValue();
		//效果与上面的相同，但是原理有点区别
		int month2 = today.getMonth().getValue();
		//该天是月份的第几天
		int day = today.getDayOfMonth();
		//该天是一年的第几天
		int dayY = today.getDayOfYear();
		//该天是星期几
		int dayW = today.getDayOfWeek().getValue();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day); 
		System.out.println("Month:" + month2);
		System.out.println("DayOfYear:" + dayY);
		System.out.println("DayOfWeek:" + dayW);
		
		//判断是否是闰年
		System.out.println(today.isLeapYear());//false
	}
	
	/**
	 * 类似之前的add 方法
	 */
	@Test
	public void plus_test() {
		LocalDate today = LocalDate.now();
		//前一天
		LocalDate today1 = today.plusDays(-1);
		//后一天
		LocalDate today2 = today.plusDays(1);
		System.out.println(today);//2017-12-13
		System.out.println(today1);//2017-12-12
		System.out.println(today2);//2017-12-14
		
		//后一天，等价于today.plusDays(1)
		LocalDate today3 = today.plus(1, ChronoUnit.DAYS);
		System.out.println(today3);//2017-12-14
		
		//加一周，等价于today.plusDays(7)
		LocalDate today5 = today.plusWeeks(1);
		System.out.println(today5);//2017-12-20
	}
	
	/**
	 * plus是加法，minus是减法，所以加负数就等于减法，减负数就等于加法
	 */
	@Test
	public void minus_test() {
		LocalDate today = LocalDate.now();
		//前一天
		LocalDate today1 = today.minusDays(1);
		System.out.println(today);//2017-12-13
		System.out.println(today1);//2017-12-12
		
		//后一天，等价于today.minusDays(1)
		LocalDate today3 = today.minus(1, ChronoUnit.DAYS);
		System.out.println(today3);//2017-12-14
		
		//加一周，等价于today.minusDays(7)
		LocalDate today5 = today.minusWeeks(1);
		System.out.println(today5);//2017-12-20
	}
	
	@Test
	public void DateTimeFormatter_test() {
//		LocalDate today = LocalDate.now();
		String dateTimeStr = "2017-12-13T12:20:30";
		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(localDateTime);
		String dateTimeStr2 = "2017-12-13T12:20:30Z";
		LocalDateTime localDateTime2 = LocalDateTime.parse(dateTimeStr2, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(localDateTime2);
		
		String dateStr = "20171213";
		LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(localDate);
	}
	
	@Test
	public void DateTimeFormatter_test2() {
		String dateTimeStr = "2017-12-13";
		final String YMD_HMS ="yyyy-MM-dd";
//		String dateTimeStr = "2017-12-13 12:20:30";
//		final String YMD_HMS ="yyyy-MM-dd HH:mm:ss";
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(YMD_HMS);
		TemporalAccessor dateTemporal = format.parse(dateTimeStr);
		System.out.println(LocalDate.from(dateTemporal));//2017-12-13
		System.out.println(LocalDateTime.from(dateTemporal));//2017-12-13
		
//		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, format);
//		System.out.println(localDateTime);
	}
}
