package org.gxuwz.arithmatic.lanqiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    /**
     * 6 5
     * 1 2
     * 1 3
     * 2 5
     * 3 6
     * 3 4
     * 1 1
     * 1 4
     * 2 6
     * 5 2
     * 6 4
     */
    static int N, Q, u, v, x, y;
    static ArrayList<Integer>[] next = new ArrayList[100010];
    static ArrayList<Integer>[] child = new ArrayList[100010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            next[i] = new ArrayList<Integer>();
            child[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < N; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            next[u].add(v);
        }
        child[1] = getChild(1);
        while (Q-- > 0) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (child[x].contains(y)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static ArrayList<Integer> getChild(Integer root) {
        int size = next[root].size();
        for (int i = 0; i < size; i++) {
            child[root].addAll(getChild(next[root].get(i)));
        }
        child[root].add(root);
        return child[root];
    }
}
