package org.gxuwz.arithmatic.lanqiao.lanqiao6;

/*
立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

请填写该数字，不要填写任何多余的内容或说明性的文字。

 */
public class Demo2_立方变自身 {

    public static void main(String[] args) {
        long n = 110000;
        for (long i = 1; i < n; i++) {
            int sum = 0;
            long s = i * i * i;
            for (int j = 0, k = 1; j < ("" + s).length(); j++, k *= 10) {
                sum += s % (k * 10) / k;
            }
            if (sum == i)
                System.out.println(sum);
        }
    }
}
