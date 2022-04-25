package org.gxuwz.arithmatic.other.zuoshen;

import java.util.Arrays;

/**
 * @author: cnwanj
 * @date: 2022-04-08 23:15:41
 * @version: 1.0
 * @desc: 背包问题
 *
 */
public class Main3 {

	/**
	 * 暴力递归
	 * @param w
	 * @param v
	 * @param pag
	 * @return
	 */
	public static int f1(int[] w, int[] v, int pag) {
		if (null == w || null == v || w.length != v.length || pag < 0) {
			return 0;
		}
		return g1(w, v, 0, pag);
	}

	public static int g1(int[] w, int[] v, int i, int pag) {
		if (pag < 0) {
			return -1;
		}
		if (i == w.length) {
			return 0;
		}
		// 不拿当前货物，往下一个走
		int p1 = g1(w, v, i + 1, pag);
		// 拿当前货物
		int p2 = 0;
		int rest = pag - w[i];
		if (rest >= 0) {
			p2 = v[i] + g1(w, v, i + 1, rest);
		}
//		int next = g1(w, v, i + 1, pag - w[i]);
//		if (next != -1) {
//			p2 = v[i] + next;
//		}
		return Math.max(p1, p2);
	}

	/**
	 * 记忆化递归
	 * @param w
	 * @param v
	 * @param pag
	 * @return
	 */
	public static int f2(int[] w, int[] v, int pag) {
		if (null == w || null == v || w.length != v.length || pag < 0) {
			return 0;
		}
		int[][] dp = new int[w.length][pag + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return g2(w, v, 0, pag, dp);
	}

	public static int g2(int[] w, int[] v, int i, int pag, int[][] dp) {
		if (pag < 0) {
			return -1;
		}
		if (i == w.length) {
			return 0;
		}
		if (dp[i][pag] != -1) {
			return dp[i][pag];
		}
		// 不拿当前货物，往下一个走
		int p1 = g2(w, v, i + 1, pag, dp);
		// 拿当前货物
		int p2 = 0;
		int rest = pag - w[i];
		if (rest >= 0) {
			p2 = v[i] + g2(w, v, i + 1, rest, dp);
		}
		return dp[i][pag] = Math.max(p1, p2);
	}

	/**
	 * 动态规划最终版
	 * @param w
	 * @param v
	 * @param pag
	 * @return
	 */
	public static int f3(int[] w, int[] v, int pag) {
		if (null == w || null == v || w.length != v.length || pag < 0) {
			return 0;
		}
		int len = w.length;
		int[][] dp = new int[len + 1][pag + 1];
		// 遍历下标index
		for (int i = len - 1; i >= 0 ; i--) {
			// 遍历背包重量
			for (int j = 0; j <= pag; j++) {
				// 与暴力递归逻辑一致
				int p1 = dp[i + 1][j];
				int p2 = 0;
				int rest = j - w[i];
				if (rest >= 0) {
					p2 = v[i] + dp[i + 1][rest];
				}
				dp[i][j] = Math.max(p1, p2);
			}
		}
		return dp[0][pag];
	}


	public static void main(String[] args) {
		int[] w = {1, 2, 3, 5};
		int[] v = {2, 4, 3, 7};
		System.out.println(f1(w, v, 5));
		System.out.println(f2(w, v, 5));
		System.out.println(f3(w, v, 5));
	}
}
