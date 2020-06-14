package org.gxuwz.arithmatic.practice.t2;

/**
 * 把字符串s中出现的第一个数字返回
 * 如果找不到数字就返回-1
 */
public class Demo8 {
    public static int f(String str) {
        if (str == "" || str.length() == 0) {
            return -1;
        }
        int p = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                p = i;
                break;
            }
        }
        if (p == -1) {
            return p;
        } else {
            return str.charAt(p) - '0';
        }

    }

    public static void main(String[] args) {
        System.out.println(f("82445adb5"));
    }
}
