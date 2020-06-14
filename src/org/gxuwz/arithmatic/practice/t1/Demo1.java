package org.gxuwz.arithmatic.practice.t1;

public class Demo1 {
    public static void binaryNum() {
        String s = "";
        for (int i = 3; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        System.out.println(s);
    }

    //判断是否是回文
    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("abcba"));

    }
}
