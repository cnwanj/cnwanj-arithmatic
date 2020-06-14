package org.gxuwz.arithmatic.lanqiao;

import java.util.*;

/*
1  2  3  4
5  6  7  8
9  10 11 12
 */
public class Main {

    static int a[] = new int[5];

    public static void main(String[] args) {
        int count = 0;
        for (a[0] = 0; a[0] < 12; a[0]++) {
            for (a[1] = a[0] + 1; a[1] < 12; a[1]++) {
                for (a[2] = a[1] + 1; a[2] < 12; a[2]++) {
                    for (a[3] = a[2] + 1; a[3] < 12; a[3]++) {
                        for (a[4] = a[3] + 1; a[4] < 12; a[4]++) {
                            count++;
                            if (judge()) {
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean judge() {
        boolean visit[] = new boolean[5];
        dfs(visit, 0);
        return visit[0] && visit[1] && visit[2] && visit[3] && visit[4];
    }

    private static void dfs(boolean[] visit, int i) {
        visit[i] = true;
        for (int j = 0; j < visit.length; j++) {
            if (!visit[j] && (a[i] / 4 == a[j] / 4) && (a[i] == a[j] + 1 || a[i] == a[j] - 1)) {
                dfs(visit, j);
            }
            if (!visit[j] && (a[i] == a[j] + 4 || a[i] == a[j] - 4)) {
                dfs(visit, j);
            }
        }
    }
}

