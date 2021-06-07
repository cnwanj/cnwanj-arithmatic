package org.gxuwz.arithmatic.nowcoder.main_练习;

import java.util.Scanner;

/**
 * 题目描述
 * 在这个特殊的假期里，由于牛牛在家特别无聊，于是他发明了一个小游戏，游戏规则为：将字符串数字中为偶数位的数字进行翻转，将翻转后的结果进行输出。
 * <p>
 * 示例1
 * 输入
 * 复制
 * "1234"
 * 输出
 * 复制
 * "1432"
 * 说明
 * 第2、4位为偶数，所以将其翻转后，得到 1432
 * 示例2
 * 输入
 * 复制
 * "12346"
 * 输出
 * 复制
 * "16342"
 * 说明
 * 第2、4、5位为偶数，所以将其翻转后，得到 16342
 * 备注:
 * 数字的长度<=10^7 且不包含数字0
 */
public class Demo8_神奇的数字 {
    /**
     * @param str string字符串
     * @return string字符串
     */
    public static String change(String str) {
        char[] c = str.toCharArray();
        int p1 = 0;
        int p2 = c.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && c[p1] % 2 != 0)
                p1++;
            while (p1 < p2 && c[p2] % 2 != 0)
                p2--;
            char temp = c[p1];
            c[p1] = c[p2];
            c[p2] = temp;
            p1++;
            p2--;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(change(str));
    }
}
