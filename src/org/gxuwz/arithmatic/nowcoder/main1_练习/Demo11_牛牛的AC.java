package org.gxuwz.arithmatic.nowcoder.main1_练习;

/**
 * 一年一度的春招就要到来了，牛牛为了备战春招，在家刷了很多道题，所以牛牛非常喜欢AC这两个字母。
 * 他现在有一个只包含A和C的字符串，你可以任意修改最多k个字符，让A变成C，或者C变成A。
 * 请问修改完之后，最长连续相同字符的长度是多少。
 *
 * 示例1
 * 输入
 * 复制
 * 1,"AAAC"
 * 输出
 * 复制
 * 4
 * 说明
 * 样例一：将最后一位C改成A即可。
 * 备注:
 * 字符串长度<=10^6，且只包含'A'和'C'，k<=10^6。
 */
public class Demo11_牛牛的AC {

    public int Solve (int k, String s) {
        // 定义两个指针，用来记录A和C的个数
        int a = 0;
        int c = 0;
        // 跟踪连续相同字符第一个字母的下标
        int p = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A')
                a ++;
            else
                c ++;
            // 当A和C的数都大于修改次数k时
            while (a > k && c > k) {
                // 进行次数减少，保证保留的连续字符的修改次数不能大于k次
                if (s.charAt(p) == 'A')
                    a --;
                else
                    c --;
                p ++;
            }
            // i - p + 1: 当前字符下标 - 连续字符串第一个字符的下标 + 1 = 连续字符的长度max
            max = Math.max(i - p + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Demo11_牛牛的AC d = new Demo11_牛牛的AC();
        System.out.println(d.Solve(1, "ACACCAACACCAAC"));
    }
}
