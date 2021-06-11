package org.gxuwz.arithmatic.leetcode.demo6_动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 *
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * 思路：
 * 1.记录1 ~ amount的金额所需的硬币数量。
 * 2.建立数组arr，下标为金额数，元素为金额所需的硬币数。
 * 3.初始化数组元素为最大金额amount + 1，默认为不能凑。
 * 4.从1到amount遍历每种金额数，获取每种金额数的硬币最小数。
 * 5.遍历硬币，若金额数 - 当前硬币面额 >= 0，差表示子问题金额数，+1表示被减去的硬币数，获取子问题中最小硬币数。
 */
public class Main322_零钱兑换 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5};
        Boolean aTrue = Boolean.TRUE;
        System.out.println(coinChange(arr, 5));
    }

    public static int coinChange(int[] coins, int amount) {
        // 下标为总金额，元素为凑成的硬币数
        int[] arr = new int[amount + 1];
        // 初始化元素为金额最大值
        Arrays.fill(arr, amount + 1);
        // 当总金额为0时，需要0硬币
        arr[0] = 0;
        // 从金额数为1开始遍历
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                // 若金额数 - 当前硬币数 >= 0
                if (i - coin >= 0) {
                    // 获取子问题的最小硬币数
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }
        // 若硬币数没有变化，说明不能凑成，返回-1
        return arr[amount] == amount + 1 ? -1 : arr[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        // 下标为总金额，元素为凑成的硬币数
        int[] dp = new int[amount + 1];
        // 初始化dp表里面数据全部为max
        Arrays.fill(dp, amount + 1);
        // 已知目标金额为0的时候，需要0个硬币
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));
        // 遍历1到amount需要多少硬币
        for (int i = 1; i <= amount; i++) {
            // 遍历所有硬币
            for (int coin : coins) {
                if (i >= coin) {
                    // 子问题dp[i-coin]加1枚硬币就是当前硬币的需要个数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        // 如果目标金额的一直没有答案返回-1
        return dp[amount] == coins.length + 1 ? -1 : dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == coins.length + 1 ? -1 : dp[amount];
    }
}
