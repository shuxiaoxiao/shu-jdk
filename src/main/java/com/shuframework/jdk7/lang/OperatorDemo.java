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
		byte a = 23; // "00010111"
		byte b = 26; // "00011010"

		// 按位与, 两个运算数都为1时，结果为1，其余结果为0
		int c = a & b; // "00010010" = 18
		System.out.println("(c = a & b) = " + c);
		
		// 按位或，两个运算数都为0时，结果为0，其余结果为1
		int d = a | b; // "00011111" = 31
		System.out.println("(d = a | b) = " + d);
		
		// 按位异或，两个运算数相同时结果为0，不同时结果为1
		int e = a ^ b; // "00001101" = 13
		System.out.println("(e = a ^ b) = " + e);
		
		// 按位非，0变成1，1变成0
		int f = ~a; // "11101000" = -24,
		// 注意，Java中采用补码存储数字，对于整数，原码与补码一致，
		// 对于负数，符号位不变，将原码取反然后加1，得到补码，补码"11101000"对应的原码是"10011000"即-24
		System.out.println("(f = ~a) = " + f);
		
		// 右移，左边空出位以符号位填充
		int g = a >> 1;// "00001011" = 11
		System.out.println("(g = a >> 1) = " + g);
		
		// 右移，左边空出位以0填充
		int h = a >>> 1;// "00001011" = 11
		System.out.println("(h = a >>> 1)" + h);
		
		// 对负数操作时，>>和>>>得到结果会不一样
		System.out.println("(-24 >> 1) = " + (-24 >> 1) + "\t (-24 >>> 1) = " + (-24 >>> 1));
		
		// 左移
		int i = a << 1; // "00101110" = 46
		System.out.println("(a << 1) = " + i);

		// 可以发现，右移1位相当于运算数除以2，左移1位相当于运算数乘以2，
		// 实质上，右移n位，相当于运算数除以2的n次方，左移n位，相当于运算数乘以2的n次方，读者可以试验。
		// 在进行乘除法操作时，开发者要有意识的利用这个特点，以提高运算速度。
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
