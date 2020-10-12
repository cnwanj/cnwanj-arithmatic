package org.gxuwz.arithmatic.lanqiao.lanqiao6;

/**
 * 牌型种数
 *
 * 小明被劫持到X赌城，被迫与其他3人玩牌。
 * 一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
 * 这时，小明脑子里突然冒出一个问题：
 * 如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 *
 * 请填写该整数，不要填写任何多余的内容或说明文字。
 *
 * 【答案】
 * 3598180
 */
public class Demo7_牌型总数 {

    private static int count = 0;

    public static void main(String[] args) {
//        f1();
//        f2(0, 0);
        f4(0, 0);
        System.out.println(count);
    }

    static void f1() {
        int[] a = new int[13];
        int count = 0;
        for (a[0] = 0; a[0] <= 4; a[0]++)
            for (a[1] = 0; a[1] <= 4; a[1]++)
                for (a[2] = 0; a[2] <= 4; a[2]++)
                    for (a[3] = 0; a[3] <= 4; a[3]++)
                        for (a[4] = 0; a[4] <= 4; a[4]++)
                            for (a[5] = 0; a[5] <= 4; a[5]++)
                                for (a[6] = 0; a[6] <= 4; a[6]++)
                                    for (a[7] = 0; a[7] <= 4; a[7]++)
                                        for (a[8] = 0; a[8] <= 4; a[8]++)
                                            for (a[9] = 0; a[9] <= 4; a[9]++)
                                                for (a[10] = 0; a[10] <= 4; a[10]++)
                                                    for (a[11] = 0; a[11] <= 4; a[11]++)
                                                        for (a[12] = 0; a[12] <= 4; a[12]++) {
                                                            if (a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7]
                                                                    + a[8] + a[9] + a[10] + a[11] + a[12] == 13) {
                                                                count++;
                                                            }
                                                        }

        System.out.println(count);
    }

    static void f3(int type, int sum) {
        if (sum == 13 || type > 13) {
            if (type == 13)
                count ++;
            return;
        }
        for (int i = 0; i <= 4; i++) {
            f3(type + i, sum + 1);
        }
    }

    /**
     * 13种牌，对于每种都有5中选择 即：0张，1张，2张，3张，4张
     * @param num 牌序号 1-13
     * @param sum   每人手中牌的总数
     */
    static void f4(int num, int sum) {
        if (num > 13 || sum > 13)
            return;

        if (sum == 13) {
            count ++;
            return;
        }

        // i表示每张牌的数量0-4张
        for (int i = 0; i < 5; i++) {
            // 牌序号加1，每张牌的数量相加
            f4(num + 1, sum + i);
        }
    }
}
