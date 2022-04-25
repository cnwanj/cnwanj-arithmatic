package org.gxuwz.arithmatic.other.zuoshen;

import java.util.Arrays;

/**
 * @author: cnwanj
 * @date: 2022-04-06 21:33:46
 * @version: 1.0
 * @desc: 动态规划
 * 题目：
 * 1.给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 2.玩家A和玩家B依次拿走每张纸牌
 * 3.规定玩家A先拿，玩家B后拿
 * 4.但是每个玩家每次只能拿走最左或最右的纸牌
 * 5.玩家A和玩家B都绝顶聪明
 * 6.请返回最后获胜者的分数。
 */
public class Main2 {

	/**
	 * 方法1：暴力递归
	 * @param arr
	 * @return
	 */
	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int before = f1(arr, 0, arr.length - 1);
		int after = g1(arr, 0, arr.length - 1);
		return Math.max(before, after);
	}

	/**
	 * 先手
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int f1(int[] arr, int l, int r) {
		if (l == r) {
			return arr[l];
		}
		// 取左边
		int v1 = arr[l] + g1(arr, l + 1, r);
		// 取右边
		int v2 = arr[r] + g1(arr, l, r - 1);
		return Math.max(v1, v2);
	}

	/**
	 * 后手
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	public static int g1(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// 取左边
		int v1 = f1(arr, l + 1, r);
		// 取右边
		int v2 = f1(arr, l, r - 1);
		return Math.min(v1, v2);
	}

	/**
	 * 方法2：记忆化搜索
	 * @param arr
	 * @return
	 */
	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = arr.length;
		int[][] fMap = new int[len][len];
		int[][] gMap = new int[len][len];
		for (int i = 0; i < len; i++) {
			Arrays.fill(fMap[i], -1);
			Arrays.fill(gMap[i], -1);
		}

		int b = f2(arr, 0, len - 1, fMap, gMap);
		int a = g2(arr, 0, len - 1, fMap, gMap);
		return Math.max(b, a);
	}

	public static int f2(int[] arr, int l, int r, int[][] fMap, int[][] gMap) {
		if (fMap[l][r] != -1) {
			return fMap[l][r];
		}

		int val;
		if (l == r) {
			val = arr[l];
		} else {
			int v1 = arr[l] + g2(arr, l + 1, r, fMap, gMap);
			int v2 = arr[r] + g2(arr, l, r - 1, fMap, gMap);
			val = Math.max(v1, v2);
		}
		return fMap[l][r] = val;
	}

	public static int g2(int[] arr, int l, int r, int[][] fMap, int[][] gMap) {
		if (gMap[l][r] != -1) {
			return gMap[l][r];
		}
		int val;
		if (l == r) {
			val = 0;
		} else {
			int v1 = f2(arr, l + 1, r, fMap, gMap);
			int v2 = f2(arr, l, r - 1, fMap, gMap);
			val = Math.min(v1, v2);
		}
		return gMap[l][r] = val;
	}

	/**
	 * 方法3：动态规划版
	 * @param arr
	 * @return
	 */
	public static int win3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int len = arr.length;
		int[][] fMap = new int[len][len];
		int[][] gMap = new int[len][len];

		for (int i = 0; i < len; i++) {
			fMap[i][i] = arr[i];
		}

		for (int i = 1; i < len; i++) {
			int l = 0;
			int r = i;
			while (r < len) {
				fMap[l][r] = Math.max(arr[l] + gMap[l + 1][r], arr[r] + gMap[l][r - 1]);
				gMap[l][r] = Math.min(fMap[l + 1][r], fMap[l][r - 1]);
				l++;
				r++;
			}
		}

		return Math.max(fMap[0][len - 1], gMap[0][len - 1]);
	}

	public static void main(String[] args) {
		int[] arr = {7, 4, 16, 15, 1};
//		int[] arr = {1, 10, 20, 5};
		System.out.println(win1(arr));
		System.out.println(win2(arr));
		System.out.println(win3(arr));
	}
}
