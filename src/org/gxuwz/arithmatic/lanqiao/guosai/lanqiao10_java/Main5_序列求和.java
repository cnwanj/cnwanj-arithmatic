package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_java;

/**
 * @Author: vovhh
 * @Date: 2020-11-10 22:35:26
 * @Description:
 *
 * 试题 E: 序列求和
 * 本题总分：15 分
 * 【问题描述】
 * 学习了约数后，小明对于约数很好奇，他发现，给定一个正整数 t，总是可
 * 以找到含有 t 个约数的整数。小明对于含有 t 个约数的最小数非常感兴趣，并
 * 把它定义为 S t 。
 * 例如 S 1 = 1, S 2 = 2, S 3 = 4, S 4 = 6，· · · 。
 * 现在小明想知道，前 60 个 S i 的和是多少？即 S 1 + S 2 + · · · + S 60 是多少？
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class Main5_序列求和 {

    public static void main(String[] args) {
        int res = 0;
        int[] cnt = new int[62];
        for (int i = 1; true; i++) {
            int tmp = cntDivisor(i);
            if (tmp >= 60) {
                cnt[60] = cnt[61] = i;
                break;
            }
            if (cnt[tmp] == 0)
                cnt[tmp] = i;
        }
        for (int i = 60; i > 0; i--) {
            if (cnt[i] == 0 || cnt[i] > cnt[i + 1]) {
                cnt[i] = cnt[i + 1];
            }
            res += cnt[i];
        }
        System.out.print(res);
    }

    static int cntDivisor(int num) {
        int cnt = 1;
        for (int i = 1, hi = num / 2; i <= hi; i++)
            if (num % i == 0) cnt++;
        return cnt;
    }
}
