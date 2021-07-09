package org.gxuwz.arithmatic.nowcoder.main1_练习;

/**
 * 题目描述
 * 给定一个包含大写英文字母和数字的句子，找出这个句子所包含的最大的十六进制整数，返回这个整数的值。数据保证该整数在int表示范围内
 * <p>
 * 示例1
 * 输入
 * 复制
 * "012345BZ16"
 * 输出
 * 复制
 * 1193051
 * 说明
 * 12345B对应十进制为1193051
 * 备注:
 * 0<字符串长度<=10^5
 */
public class Demo10_最大数 {
    public static int solve(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 48 && s.charAt(i) <= 57) || (s.charAt(i) >= 65 && s.charAt(i) <= 70)) {
                end++;
                max = Math.max(max, Integer.parseInt(s.substring(start, end), 16));
            } else {
                start = i + 1;
                end++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solve("012345BZ16"));
    }
}
