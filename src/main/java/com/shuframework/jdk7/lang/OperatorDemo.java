package com.shuframework.jdk7.lang;

import org.junit.Test;

/**
 * 运算符示例
 * @author shu
 *
 */
public class OperatorDemo {
	
	//位运算符
	/**
	 * &(与运算)、 
	 * |(或运算)、
	 * ^(异或运算)、
	 * <<(左移)、
	 * >>(右移)、
	 * >>>(无符号右移)
	 */
	@Test
	public void test() {
		System.out.println(3 & 4);//0
		System.out.println(3 | 4);//7
		System.out.println(3 ^ 4);//7
	}
	
	
	@Test
	public void test2() {
		int h = hashCode("gdejicbegh");
		int h2 = hashCode("hgebcijedg");
		System.out.println("h:"+h);		//-801038016
		System.out.println("h2:"+h2);	//-801038016
		int m = 16;
		System.out.println(h >>> m);
		int hashCode1 = h ^ (h >>> m);
		
		int rh = h % m;
		int hashCode2 = (rh >= 0) ? rh : -rh;
		System.out.println(hashCode1);//0
		System.out.println(hashCode2);//0
	}
	
	
    public int hashCode(String str) {
        int h = 0;
        char val[] = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            h = 31 * h + val[i];
        }
        return h;
    }

}
