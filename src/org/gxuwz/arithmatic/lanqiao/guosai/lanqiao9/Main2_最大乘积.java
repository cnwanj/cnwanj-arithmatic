package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: vovhh
 * @Date: 2020-11-06 12:39:37
 * @Description:
 *
 * 标题：最大乘积
 *
 * 把 1~9 这9个数字分成两组，中间插入乘号，
 * 有的时候，它们的乘积也只包含1~9这9个数字，而且每个数字只出现1次。
 *
 * 比如：
 * 984672 * 351 = 345619872
 * 98751 * 3462 = 341875962
 * 9 * 87146325 = 784316925
 * ...
 *
 * 符合这种规律的算式还有很多，请你计算在所有这些算式中，乘积最大是多少？
 *
 * 注意，需要提交的是一个整数，表示那个最大的积，不要填写任何多余的内容。
 * （只提交乘积，不要提交整个算式）
 *
 * 答案：839542176
 */
public class Main2_最大乘积 {

    static char[] a;
    static long max = 0;
    static Set<Long> res = new HashSet<Long>();

    public static void main(String[] args) {
        // , 4, 5, 6, 7, 8, 9
        a = "123456789".toCharArray();

        f(0);
        System.out.println(max);
    }

    static void f(int p) {
        if (p == a.length) {
            check();
            return;
        }
        for (int i = p; i < a.length; i++) {
            swap(i, p);
            f(1 + p);
            swap(i, p);
        }
    }

    static void swap (int i, int p) {
        char t = a[i];
        a[i] = a[p];
        a[p] = t;
    }

    static boolean check() {

        for (int i = 0; i < a.length - 1; i++) {
            long size = res.size();
            String s = String.valueOf(a);
            // 将s分割成左边和右边部分
            long left = Long.parseLong(s.substring(0, i + 1));
            long right = Long.parseLong(s.substring(i + 1, a.length));
            long result = left * right;

            // 将结果集存入set集合中
            res.add(result);
            // 若结果没有重复 && 长度为9
            if (res.size() != size && ("" + result).length() == a.length) {
                // 若该结果未存在
                if (isRepeat(result)) {
                    if (max < result)
                        max = result;
                }
            }
        }
        return true;
    }

    // 判断结果内的元素是否有重复元素
    static boolean isRepeat(long result) {
        String s = "" + result;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                return false;
            set.add(s.charAt(i));
        }
        return s.length() == set.size();
    }
}
