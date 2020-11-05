package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-10-30 19:14:39
 * @Description:
 *
 * 标题：区间移位
 *
 * 数轴上有n个闭区间：D1,...,Dn。
 * 其中区间Di用一对整数[ai, bi]来描述，满足ai < bi。
 * 已知这些区间的长度之和至少有10000。
 * 所以，通过适当的移动这些区间，你总可以使得他们的“并”覆盖[0, 10000]——也就是说[0, 10000]这个区间内的每一个点都落于至少一个区间内。
 * 你希望找一个移动方法，使得位移差最大的那个区间的位移量最小。
 *
 * 具体来说，假设你将Di移动到[ai+ci, bi+ci]这个位置。你希望使得maxi{|ci|} 最小。
 *
 * 【输入格式】
 * 输入的第一行包含一个整数n，表示区间的数量。
 * 接下来有n行，每行2个整数ai, bi，以一个空格分开，表示区间[ai, bi]。
 * 保证区间的长度之和至少是10000。
 *
 * 【输出格式】
 * 输出一个数字，表示答案。如果答案是整数，只输出整数部分。如果答案不是整数，输出时四舍五入保留一位小数。
 *
 * 【样例输入】
 * 2
 * 10 5010
 * 4980 9980
 *
 * 【样例输出】
 * 20
 *
 * 【样例说明】
 * 第一个区间往左移动10；第二个区间往右移动20。
 *
 * 【样例输入】
 * 4
 * 0 4000
 * 3000 5000
 * 5001 8000
 * 7000 10000
 * 【样例输出】
 * 0.5
 * 【样例说明】
 * 第2个区间往右移0.5；第3个区间往左移0.5即可。
 *
 * 【数据规模与约定】
 * 对于30%的评测用例，1 <= n <= 10；
 * 对于100%的评测用例，1 <= n <= 10000，0 <= ai < bi <= 10000。
 *
 * 资源约定：
 * 峰值内存消耗 < 256M
 * CPU消耗  < 2000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 */
public class Main6_区间移位 {

    static int n;
    static int[] arr, arr1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n * 2];
        arr1 = new int[n];
        for (int i = 0; i < n * 2; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(arr));
        f();
    }

    /**
     * 2
     * 10 5010
     * 4980 9980
     */
    static void f() {
        for (int i = 0; i < n; i++) {
            if (i == 0 && arr[i] != 0) {
                // 存储起点偏移量
                arr1[i] = arr[i];
                // 起点右区间
                arr[i + 1] -= arr[i];
                // 左区间
                arr[i] = 0;
            } else if (i == n - 1 && arr[i * 2 + 1] != 1000) {
                // 存储终点偏移量
                arr1[i] = 10000 - arr[i * 2 + 1];
                // 终点、左区间
                arr[i * 2] += arr1[i];
                // 右区间
                arr[i * 2 + 1] = 10000;
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
