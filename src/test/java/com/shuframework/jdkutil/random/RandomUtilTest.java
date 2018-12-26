package com.shuframework.jdkutil.random;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Created by gwc gongwenchao@xubei.com
 * @Description:
 * @date 2018-12-26 16:56
 */
public class RandomUtilTest {

    @Test
    public void verifyCodeHasLetter() {
        String vcode = RandomUtil.verifyCodeHasLetter(6);
        System.out.println(vcode);
    }

    @Test
    public void random() {
    }


    @Test
    public void randomByLength() {
        int random = RandomUtil.randomByLength(6);
        System.out.println(random);
    }

    @Test
    public void randomFillZero() {
        String random = RandomUtil.randomFillZero(6);
        System.out.println(random);
    }
}