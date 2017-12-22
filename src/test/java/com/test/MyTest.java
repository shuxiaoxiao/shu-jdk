package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.shuframework.jdk7.enums.DateEnum;

/**
 * 例子测试
 * @author shu
 *
 */
public class MyTest {


	@Test
	public void switch_test() {
		DateEnum key = DateEnum.DAY_OF_MONTH;
		getByEnum(key);
	}

	private void getByEnum(DateEnum key) {
		switch (key) {
		case DAY_OF_YEAR:
			System.out.println("year" + DateEnum.DAY_OF_YEAR);
			break;
		case DAY_OF_MONTH:
			System.out.println("month");
			break;

		default:
			break;
		}
	}
	
	@Test
	public void sort_test() {
//		String[] strArr = {"cc", "aa", "dd", "b", "ca"};
//		System.out.println("前：" + strArr[0]);
//		Arrays.sort(strArr);
//		System.out.println("后：" + strArr[0]);
		
		List<Object> strList = new ArrayList<>();
		strList.add("cc");
		strList.add("aa");
		strList.add("dd");
		strList.add("b");
		strList.add("ca");
		
		System.out.println("前：" + strList.toString());
//		Collections.sort(strList, (o1, o2) -> {
//			return 1;
//		});
		Collections.sort(strList, new Comparator<Object>() {
				 public int compare(Object object1, Object object2) {// 实现接口中的方法  
					 return 1;
				 }
		});
		System.out.println("后：" + strList.toString());
	}
	
	@Test
	public void test2() {
		//应付总金额(分)
		int payPlan = 0;
		//实付总金额(分)
		int payActual = 0;
		//第三方支付金额(分)
		int payThirdPrice = 0;
		int deductFee = 200;//违约金
		
		payPlan = payActual = payThirdPrice = deductFee;
		System.out.println(payPlan);
		System.out.println(payActual);
		System.out.println(payThirdPrice);
		
	}
	
	@Test
	public void date_test2() {
		long diffSecondTime = 6959/100L;
		System.out.println(diffSecondTime);
		if(diffSecondTime >= 60 && diffSecondTime <= 15 *60){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
		
	}
	
	@Test
	public void date_test() {
		long a = 1512554103000L;
		Date date = new Date(a);
		System.out.println(date);
	}
	
	@Test
	public void compareTo_test() {
//		String hmTime = "10:00";//0.0	0.0
//		String hmTime = "11:00";//1.0	0.0
//		String hmTime = "12:00";//1.0	0.0
//		String hmTime = "12:30";//1.0	0.0
//		String hmTime = "13:00";//1.0	0.0
//		String hmTime = "13:30";//0.0	0.0
//		String hmTime = "22:00";//0.0	1.0
//		String hmTime = "22:30";//0.0	1.0
//		String hmTime = "23:30";//0.0	1.0
//		String hmTime = "00:00";//0.0	1.0
		String hmTime = "00:30";
		double noonPeakCost = 0d; //午高峰加价
        double eveningPeakCost = 0d; //晚高峰加价
        if (hmTime.compareTo("11:00") >= 0 && hmTime.compareTo("13:00") <= 0){
            noonPeakCost = 1.0d; //午高峰加价1元
        }
        if (hmTime.compareTo("00:00") >= 0 && hmTime.compareTo("08:00") <= 0){
            eveningPeakCost = 1.0d; //晚高峰加价1元
        }
        if (hmTime.compareTo("22:00") >= 0 && hmTime.compareTo("24:00") <= 0){
            eveningPeakCost = 1.0d; //晚高峰加价1元
        }
		System.out.println(noonPeakCost);
		System.out.println(eveningPeakCost);
	}
}
