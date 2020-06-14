package org.gxuwz.arithmatic.practice.t3;

/**
 * 先输入一个自然数n(n<500)，然后对此数按照如下方法进行处理
 * 1.不做任何处理
 * 2.在它的左边加上一个自然数，该自然数不能超过原数首位数字的一半
 * 3.加上数后，继续按照此规则进行处理，知道不能再加自然数为止
 * 输入：6
 * 满足条件的数为 6
 * 16
 * 26
 * 126
 * 36
 * 136
 * 输出：6
 */
public class Demo20 {
    public static int f(int n) {
        for (int i = 1; i <= n / 2; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
//        for(int i=1; i<=1000; i++){
//            System.out.println("100"+i+",java"+i+",javaEE"+i);
//        }
        for (int i = 1; i <= 20; i++) {
            System.out.println("<option value='第" + i + "周'>第" + i + "周</option>");
        }
    }
}
