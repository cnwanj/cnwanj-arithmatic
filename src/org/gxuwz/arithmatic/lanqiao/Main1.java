package org.gxuwz.arithmatic.lanqiao;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    static boolean[] vis = new boolean[12345];
    static long[][] arr = new long[300][300];
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        int n = 2019;
        int m = (int)Math.sqrt(n);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        // 遍历n开方以内的数
        for (int i = 2; i <= m; i++) {
            // 已n开方以内的数的平方作为起点，步长加i
            for (int j = i * i; j <= n; j += i) {
                // 若为合数，设置为true
                vis[j - 1] = true;
            }
        }

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i])
                list.add(i + 1);
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                arr[i][j] = -1;
//            }
//        }

        System.out.println(f(0, 0));
    }

    static long f(int p, int s) {
        if (arr[p][s] != 0)
            return arr[p][s];
        if (s == 2019)
            return 1;
        if (p >= list.size() || s > 2019)
            return 0;
        long ans = 0;
        ans += f(p + 1, s);
        ans += f(p + 1, s + list.get(p));
        return arr[p][s] = ans;
    }
}
