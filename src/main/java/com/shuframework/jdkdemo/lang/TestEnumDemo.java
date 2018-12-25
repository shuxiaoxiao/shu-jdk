package com.shuframework.jdkdemo.lang;

/**
 * 这个命名只是为了区分示例与工具类，枚举建议都以Enum结束
 * 
 * @author shu
 *
 */
public enum TestEnumDemo {

	FIRST,
	SECOND,
	THIRD,
	FOURTH,
	FIFTH;
	
	/**
	 * 关于value的设计如果刚好，可以参考java.time.DayOfWeek 与java.time.Month
	 * ordinal()是枚举元素的下标，从0开始
	 */
    public int getValue() {
        return ordinal() + 1;
    }
    
    //可以考虑重写values
    
    
    public static void main(String[] args) {
    	int n = TestEnumDemo.SECOND.getValue();//2
    	System.out.println(n);
	}
}
