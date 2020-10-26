package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_模拟2;

/**
 * @description:
 * 【问题描述】在计算机存储中，12.5MB是多少字节？
 * 【答案提交】这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 * 答案：13107200
 *
 * @author: 韦永恒
 * @date: 2020-08-31 16:21:40
 */
public class Demo1_125MB {

    public static void main(String[] args) {
        long a = (long)(12.5 * 1024) * 1024;
        // 13107200
        System.out.println(a);
    }
}
