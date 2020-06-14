package org.gxuwz.arithmatic.nowcoder;

import java.util.Scanner;

public class Demo13_迷失的括号序列 {

    public static String MissingBrackets(String brackets) {
        if (brackets.length() % 2 != 0)
            return "Impossible";
        // 记录左括号的数量
        int left = 0;
        for (int i = 0; i < brackets.length(); i++)
            if (brackets.charAt(i) == '(')
                left++;
        if (left > brackets.length() / 2)
            return "Impossible";
        // 记录多余的右括号数量
        int p = brackets.length() / 2 - left;
        StringBuffer sf = new StringBuffer(brackets);
        for (int i = 0; i < sf.length(); i++) {
            if (sf.charAt(i) == '?') {
                if (p-- > 0)
                    sf.setCharAt(i, '(');
                else
                    sf.setCharAt(i, ')');
            }
        }
        int k = 0;
        for (int i = 0; i < sf.length(); i++) {
            if (sf.charAt(i) == '(')
                k++;
            else {
                k--;
                if (k < 0)
                    return "Impossible";
            }
        }
        return sf.toString();
    }

    public static void main(String[] args) {
//        String s = "(()(()?)";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(MissingBrackets(s));
//        String[] s1 = s.split("");
//        Stack<String> stack = new Stack<>();
//        stack.push(s1[0]);
//        for (int i = 1; i < s1.length; i++) {
//            if ("?".equals(s1[i])) {
//
//            }
//            if (stack.peek().equals(s1[i-1])) {
//
//            }
//            System.out.println(stack);
//        }

    }
}
