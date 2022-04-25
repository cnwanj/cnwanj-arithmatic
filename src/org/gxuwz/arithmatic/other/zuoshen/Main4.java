package org.gxuwz.arithmatic.other.zuoshen;

/**
 * @author: cnwanj
 * @date: 2022-04-09 10:45:42
 * @version: 1.0
 * @desc: 动态规划
 * 1.规定1和A对应、2和B对应、3和C对应...26和Z对应
 * 2.那么一个数字字符串比如"111”就可以转化为:"AAA"、“KA"和"AK"
 * 3.给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 */
public class Main4 {
	/**
	 * 暴力递归
	 * @param arr
	 * @param i
	 * @return
	 */
	public static int f1(char[] arr, int i) {
		// 走到结尾，计一次数
		if (i == arr.length) {
			return 1;
		}
		// 单独0作为无效字符
		if (arr[i] == '0') {
			return 0;
		}
		int count = f1(arr, i + 1);
		if (i + 1 < arr.length && (arr[i] - '0') * 10 + (arr[i] - '0') < 27) {
			count += f1(arr, i + 2);
		}
		return count;
	}

	public static int f3(char[] arr) {
		int len = arr.length;
		int[] dp = new int[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (arr[i] != '0') {
				int count = dp[i + 1];
				if (i + 1 < len && (arr[i] - '0') * 10 + (arr[i] - '0') < 27) {
					count += dp[i + 2];
				}
				dp[i] = count;
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		char[] arr = "101".toCharArray();
		System.out.println(f1(arr, 0));
		System.out.println(f3(arr));
	}
}
