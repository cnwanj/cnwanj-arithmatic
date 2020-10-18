package org.gxuwz.arithmatic.lanqiao.lanqiao7;

import org.apache.poi.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剪邮票
 *
 * 如【图1.jpg】, 有12张连在一起的12生肖的邮票。
 * 现在你要从中剪下5张来，要求必须是连着的。
 * （仅仅连接一个角不算相连）
 * 比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。
 *
 * 请你计算，一共有多少种不同的剪取方法。
 *
 * 请填写表示方案数目的整数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo7_剪邮票 {

    // 存放每次剪下的邮票
    static List<Integer> list = new ArrayList<Integer>();
    static int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    // 记录每次走过的路径
    static boolean[] visited = new boolean[5];
    static long count = 0;

    public static void main(String[] args) {
        dfs(0);
        System.out.println(count);
    }

    // 深度遍历
    private static void dfs(int step) {
        while (step < A.length) {
            list.add(A[step]);
//            System.out.println(list);
            // 若邮票长度等于5
            if (list.size() == 5) {
                if (check()) {
                    count++;
                }
            }
            step++;
            dfs(step);
            // 将最后一个清除
            list.remove(list.size() - 1);
        }
    }

    private static boolean check() {
        // 标记为false
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int start = list.get(0);
        // 深度路径遍历
        dfsPath(start, 0);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfsPath(int a, int i) {
        visited[i] = true;
        int start1 = a + 1;
        int start2 = a - 1;
        int start3 = a + 4;
        int start4 = a - 4;
        int r = (a - 1) / 4;
        // 若list中存在start1 && 并且两数同在一行
        if (list.contains(start1) && (start1 - 1) / 4 == r && !visited[list.indexOf(start1)])
            dfsPath(start1, list.indexOf(start1));
        if (list.contains(start2) && (start2 - 1) / 4 == r && !visited[list.indexOf(start2)])
            dfsPath(start2, list.indexOf(start2));
        if (list.contains(start3) && !visited[list.indexOf(start3)])
            dfsPath(start3, list.indexOf(start3));
        if (list.contains(start4) && !visited[list.indexOf(start4)])
            dfsPath(start4, list.indexOf(start4));
    }
}

// 我写的1
class Demo7_剪邮票1 {

    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static int sum;
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        // 抽出5个的个数
        dfs1(0);
        System.out.println(sum);
    }

    static void dfs1(int p) {
        while (p < a.length) {
            list.add(a[p]);
            if (list.size() == 5) {
                if (check()) {
                    sum++;
                }
            }
            p++;
            dfs1(p);
            // 将最后面一个干掉
            list.remove(list.size() - 1);
        }
    }

    // 检查0 1数组
    static boolean check() {
        // 将抽出来的5个数分别对应b数组的下标，并标记为1
        int[] b = new int[12];
        for (int i = 0; i < list.size(); i++) {
            b[list.get(i) - 1] = 1;
        }
        boolean[] vis = new boolean[12];
        // 记录邮票连续串的个数
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 1 && !vis[i]) {
                vis[i] = true;
                // 深度优先遍历
                dfs(vis, b, i);
                // 每遍历到一个连续串就 +1
                count ++;
            }
        }
        if (count == 1)
            return true;
        return false;
    }

    private static void dfs(boolean[] vis, int[] b, int n) {
        int[] x = {1, -1, 4, -4};
        int m;
        // 四周遍历
        for (int i = 0; i < 4; i++) {
            m = n + x[i];
            if (m >= 0 && m < b.length && b[m] == 1 && !vis[m]) {
                if (i < 2) {
                    // 纵向遍历，若在同一行
                    if (n / 4 == m / 4) {
                        vis[m] = true;
                        dfs(vis, b, m);
                    }
                } else {
                    // 横向遍历
                    vis[m] = true;
                    dfs(vis, b, m);
                }
            }
        }
    }
}

// 我写的2
class Demo7_剪邮票2 {

    private static int[] arr, arr1 = new int[5], arr2;
    // 记录上下左右
    private static int[] x = {-1, 1, -4, 4};
    private static int count = 0;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        f(0, 0);
        System.out.println(count);
    }

    static void f(int c, int p) {
        if (p == arr1.length) {
            if (check()) {
                count ++;
            }
            return;
        }
        for (int i = c; i < arr.length; i++) {
            arr1[p] = arr[i];
            f(i + 1, p + 1);
        }
    }

    static boolean check() {
        // 将抽取到的数替换为1
        arr2 = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[arr1[i] - 1] = 1;
        }

        // 记录是否走过
        boolean[] vis = new boolean[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr2[i] == 1 && !vis[i]) {
                vis[i] = true;
                // 深度遍历
                dfs(vis, i);
                count ++;
            }
        }
        if (count != 1)
            return false;
        return true;
    }

    static void dfs(boolean[] vis, int n) {
        for (int i = 0; i < x.length; i++) {
            int m = n + x[i];
            if (m >= 0 && m < arr.length && arr2[m] == 1 && !vis[m]) {
                if (i < 2) {
                    if (n / 4 == m / 4) {
                        vis[m] = true;
                        dfs(vis, m);
                    }
                } else {
                    vis[m] = true;
                    dfs(vis, m);
                }
            }
        }
    }
}
