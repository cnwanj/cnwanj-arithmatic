package org.gxuwz.arithmatic.lanqiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Section> array = new ArrayList<Section>();

    /**
     * 2
     * 10 5010
     * 4980 9980
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            array.add(new Section(sc.nextInt() * 2, sc.nextInt() * 2));
        }
        sc.close();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }

        int left = 0, right = 20000;

        // 二分法
        while (left < right) {
            // 获取中间值
            int mid = (left + right) / 2;
            if (check(mid)) {
                // 取左边
                right = mid;
            } else {
                // 取右边
                left = mid + 1;
            }
        }
        if (left % 2 == 0) {
            System.out.print(left / 2);
        } else {
            System.out.print(left * 1.0 / 2);
        }

    }

    static boolean check(int mid) {
        ArrayList<Section> temp = new ArrayList<Section>(array);
        // 从0开始填充数轴,k为区间覆盖区域的右边界
        int k = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < temp.size(); i++) {
                // 获取左区间
                int start = temp.get(i).start;
                // 获取右区间
                int end = temp.get(i).end;

                // 符合区间移动条件
                if (start - mid <= k && end + mid >= k) {
                    if (start + mid >= k) {
                        // 即将填充的区间，没有覆盖已填充区域，则右边界k+整个区间
                        k += end - start;
                    } else {
                        // 即将填充的区间，覆盖部分已填充区域，则右边界k=end+mid
                        k = end + mid;
                    }
                    flag = true;
                    // 删除已填充的区间
                    temp.remove(i);
                    break;
                }
            }
            // 若没有移动或超出范围
            if (!flag || k >= 20000)
                break;
        }
        return k >= 20000;
    }

    static class Section implements Comparable<Section> {
        private int start;
        private int end;

        public Section(int a, int b) {
            this.start = a;
            this.end = b;
        }

        @Override
        public int compareTo(Section o2) {
            // TODO Auto-generated method stub
            if (this.end != o2.end)
                return this.end < o2.end ? -1 : 1;
            else
                return this.start < o2.start ? -1 : 1;
        }

        @Override
        public String toString() {
            return this.start + " " + this.end;
        }
    }
}
