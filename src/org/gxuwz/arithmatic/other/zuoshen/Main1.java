package org.gxuwz.arithmatic.other.zuoshen;

import java.util.Arrays;

/**
 * @author: cnwanj
 * @date: 2022-04-05 20:29:39
 * @version: 1.0
 * @desc: 动态规划
 * 参考：左神
 *
 * 动态规划（Dynamic Programming）：
 * 如果有重复调用的过程，经过计算一遍之后，把答案记下来，下回再遇到重复过程直接调这个行为叫做动态规划。
 * 动态规划返回的就是暴力递归的一个缓存。
 *
 * 题目：
 * 1.假设有排成一行的N个位置，记为1~N，N一定大于或等于2。
 * 2.开始时机器人在其中的M位置上(M一定是1~N中的一个)。
 * 3.如果机器人来到1位置，那么下一步只能往右来到2位置。
 * 4.如果机器人来到N位置，那么下一步只能往左来到N-1位置。
 * 5.如果机器人来到中间位置，那么下一步可以往左走或者往右走。
 * 6.规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)
 * 的方法有多少种给定四个参数N、M、K、P，返回方法数。
 */
public class Main1 {

	/**
	 * 暴力递归的方法进行求解，会有大量的重复计算，需要优化
	 * @param start 当前位置
	 * @param K	步数
	 * @param aim	目标位置
	 * @param n	数组长度
	 * @return		当前位置经过步数后到达目标的方法有多少种
	 */
	public static int f1(int start, int K, int aim, int n) {
		if (start < 1 || start > n || K < 1 || aim < 1 || aim > n || n < 2) {
			return -1;
		}
		return dp1(start, K, aim, n);
	}

	public static int dp1(int cur, int step, int aim, int n) {
		// 如果步数走完了，并且走到终点aim，则计一次路径，否则返回0
		if (step == 0) {
			return cur == aim ? 1 : 0;
		}
		// 若cur为1，只能走到2的位置
		if (cur == 1) {
			return f1(2, step - 1, aim, n);
		}
		// 若cur为n，只能走到n-1的位置
		if (cur == n) {
			return f1(n - 1, step - 1, aim, n);
		}
		// 如果在中间位置，则是左右两边都可以走
		return f1(cur - 1, step - 1, aim, n) + f1(cur + 1, step - 1, aim, n);
	}

	/**
	 * 通过记忆化方法，将已走过的值记录到一个二维数组中
	 * @param start 当前位置
	 * @param K	步数
	 * @param aim	目标位置
	 * @param n	数组长度
	 * @return		当前位置经过步数后到达目标的方法有多少种
	 */
	public static int f2(int start, int K, int aim, int n) {
		if (start < 1 || start > n || K < 1 || aim < 1 || aim > n || n < 2) {
			return -1;
		}
		// cur和step为变量，只要这两个值确定，就将结果记录到记忆数组中
		int[][] dp = new int[n + 1][K + 1];
		for (int i = 0; i < dp.length; i++) {
			// 初始化为-1
			Arrays.fill(dp[i], -1);
		}
		return dp2(start, K, aim, n, dp);
	}

	private static int dp2(int cur, int step, int aim, int n, int[][] dp) {
		if (dp[cur][step] != -1) {
			return dp[cur][step];
		}
		int value;
		if (step == 0) {
			return cur == aim ? 1 : 0;
		} else if (cur == 1) {
			value = dp2(2, step - 1, aim, n, dp);
		} else if (cur == n) {
			value = dp2(n - 1, step - 1, aim, n, dp);
		} else {
			value = dp2(cur - 1, step - 1, aim, n, dp) + dp2(cur + 1, step - 1, aim, n, dp);
		}
		// 将已走过的记录下来
		dp[cur][step] = value;
		return value;
	}

	/**
	 * 最终版本
	 * @param start 当前位置
	 * @param K	步数
	 * @param aim	目标位置
	 * @param n	数组长度
	 * @return		当前位置经过步数后到达目标的方法有多少种
	 */
	private static int f3(int start, int K, int aim, int n) {
		if (start < 1 || start > n || K < 1 || aim < 1 || aim > n || n < 2) {
			return -1;
		}
		int[][] dp = new int[n + 1][K + 1];
		dp[aim][0] = 1;
		// 列（从上到下，再从左到右）
		for (int step = 1; step <= K; step++) {
			// 第一行的值为左下角
			dp[1][step] = dp[2][step - 1];
			// 中间的值为左上角、左下角之和
			for (int cur = 2; cur < n; cur++) {
				dp[cur][step] = dp[cur - 1][step - 1] + dp[cur + 1][step - 1];
			}
			// 第n行的值为左上角
			dp[n][step] = dp[n - 1][step - 1];
		}
		return dp[start][K];
	}

	public static void main(String[] args) {
//		System.out.println(f2(2, 4,4, 4));
		System.out.println(f2(2, 6,4, 5));
		System.out.println(f3(2, 6,4, 5));
	}
}
