package com.shuframework.jdkutil.random;

import java.util.Random;

import com.shuframework.jdkutil.lang.StringUtil;

/**
 * 产生随机数（推荐使用这个来替换MathUtil）<br/>
 * 底层都是java.util.Random类, 线程安全, 但是多线程下可能性能比较低, 因为Random用了很多CAS的类，ThreadLocalRandom根本没有用到 <br/>
 * 生成的随机数是线性可预测的, 所以在安全性要求比较高的场合，应当使用SecureRandom。
 *
 * @author shu
 */
public class RandomUtil {

    private RandomUtil(){}

    /**
     * 返回的范围是[0,num)
     *
     * @param @param num
     * @return int    返回类型
     * @Title: random
     */
    public static int random(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }

    /**
     * 返回的范围是[start, end)
     *
     * @param start 范围起始值
     * @param end   范围终止值
     * @return int    返回类型
     * @Title: random
     */
    public static int random(int start, int end) {
//		return random(end - start) + start; //返回[start, end)
//		return random(end - start + 1) + start;	//返回[start, end]
        return random(end - start) + start;
    }

    /**
     * 返回的几位数之间的值, length范围 [1,10) <br>
     * 如length=1,返回[0, 10) 即0-9之间的值<br>
     * 如length=2,返回[10, 100) 即10-99之间的值<br>
     * 如length=3,返回[100, 1000) 即100-999之间的值<br>
     *
     * @param length 几位数
     * @return int
     */
    public static int randomByLength(int length) {
        int start = 0;
        if (length == 1) {
            return random(10);
        } else if (length > 1 && length < 10) {
            // 由于10^0 =1,所以单独处理
            start = pow10(length - 1);
        } else {
            throw new IllegalArgumentException("超过范围, length范围是[1,10)");
        }
        int end = pow10(length);

        return random(start, end);
    }

    /**
     * 返回的几位数的值, 位数不够则补零, length范围 [1,10) <br>
     * 如length=1,返回[0, 10) 即0-9之间的值<br>
     * 如length=2,返回[00, 100) 即00-99之间的值<br>
     * 如length=3,返回[000, 1000) 即000-999之间的值<br>
     *
     * @param length 几位数
     * @return String
     */
    public static String randomFillZero(int length) {
        if (length > 0 && length < 10) {
            int end = pow10(length);
            int num = random(end);
            return StringUtil.fillLeftZero(num, length);
        } else {
            throw new IllegalArgumentException("超过范围, length范围是[1,10)");
        }
    }

    /**
     * 10的次方, length范围 [1,10)
     *
     * @param length
     * @return
     */
    private static int pow10(int length) {
        return (int) Math.pow(10, length);
    }

//	private static String fillZero(int num, int length) {
//		return String.format("%0" + length + "d", num);
//	}

}
