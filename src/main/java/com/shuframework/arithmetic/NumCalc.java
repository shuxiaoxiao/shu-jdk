package com.shuframework.arithmetic;

/**
 * 数字计算：实现排列、组合的概念
 */
public class NumCalc {

    public static void main(String[] args) {
//        p(5, 0);// 1
//        p(5, 4);
//        p(5, 5);
//        factorial(5);
//        System.out.println("----------");
//        p(5, 2);
//        int r1 = c(7, 3);
//        System.out.println("r1:" + r1);
//        System.out.println("----------");
//        int r2 = c(7, 4);
//        System.out.println("r2:" + r2);

        int r1 = c(7, 0);
        System.out.println("r1:" + r1);
        System.out.println("----------");
        int r2 = c(7, 7);
        System.out.println("r2:" + r2);
    }


    /**
     * n!  阶乘factorial 其实排列的 A(n, n)或A(n, n-1)
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
//        int num = 1;
//        for (int i = n; i > 1; i--){
//            num *= i;
//        }
//        System.out.println(num);
//        return num;
        return p(n, n - 1);
    }

    /**
     * n>m  排列permutation 或arrangement
     *
     * @param n
     * @param m
     * @return
     */
    public static int p(int n, int m) {
        int num = 1;
        for (int i = n; i > (n - m); i--) {
            num *= i;
            System.out.print(i + " ");
        }
        System.out.println("=" + num);
        return num;
    }

    /**
     * n>m  组合combination
     * 算法：C(n, m) = A(n, m)/A(m, m-1)
     * 如：C(6, 3) = A(6, 3)/ A(3, 2)
     *
     * @param n
     * @param m
     * @return
     */
    public static int c(int n, int m) {
        //特殊情况
        if (m == 0 || n == m) {
            return 1;
        }
        // 大于中间数时，选择小的数进行遍历
        if (m > n / 2) {
            m = n - m;
        }
        return p(n, m) / p(m, m - 1);
    }
    //这个是原理算法，上面是简化版
//    public static int c2(int n, int m) {
//        int num1 = 1;//被除数
//        int num2 = 1;//除数
//        for (int i = n; i > (n - m); i--) {
//            num1 *= i;
//            System.out.print(i + " ");
//        }
//        System.out.println("=" + num1);
//        for (int i = m; i > 1; i--) {
//            num2 *= i;
//            System.out.print(i + " ");
//        }
//        System.out.println("=" + num2);
//        return num1 / num2;
//    }

}
