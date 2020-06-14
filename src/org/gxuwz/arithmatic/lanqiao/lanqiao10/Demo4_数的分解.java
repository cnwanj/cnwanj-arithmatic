package org.gxuwz.arithmatic.lanqiao.lanqiao10;

import java.util.HashSet;
import java.util.Set;

/**
 * 1 2 3
 */
public class Demo4_数的分解 {
    public static void main(String[] args) {
//        int count = 0;
//        Set<Integer> s = new HashSet<>();
//        for (int i = 1; i <= 2019; i++) {
//            if ((i + "").indexOf("2") == -1 && ((i + "").indexOf("4") == -1)) {
//                for (int j = 1; j < 2019; j++) {
//                    if ((j + "").indexOf("2") == -1 && ((j + "").indexOf("4") == -1)) {
//                        int k = 2019 - i - j;
//                        if ((k + "").indexOf("2") != -1 || (k + "").indexOf("4") != -1)
//                            continue;
//                        if (k >= 1) {
//                            s.add(i);
//                            s.add(j);
//                            s.add(k);
//                            if (s.size() == 3) {
//                                count++;
//                            }
//                            s.clear();
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(count / 6);

        f();
    }

    public static boolean check(int i) {
        if (("" + i).contains("2") || ("" + i).contains("4")) {
            return true;
        }
        return false;
    }

    public static void f() {
        int n = 2019, count = 0;
        for (int i = 1; i < n; i++) {
            if (check(i))
                continue;

            for (int j = 1; j < n; j++) {
                if (check(j))
                    continue;

                int k = n - i - j;
                if (check(k))
                    continue;

                if (i == j || j == k || i == k)
                    continue;

                if (k > 0)
                    count ++;
            }
        }
        System.out.println(count / 6);
    }
}
