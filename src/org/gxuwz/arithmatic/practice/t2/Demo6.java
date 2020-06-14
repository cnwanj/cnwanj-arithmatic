package org.gxuwz.arithmatic.practice.t2;

import java.util.Stack;

/**
 * 判断一个串中的字符是否匹配
 * 所谓的匹配是指不同类型的括号必须左右呼应
 * 可以相互白喊，但不可以交叉
 * 1.判断左边括号，若存在将对应的右边括号压入栈中
 * 2.判断右边括号，若与栈中的括号相同，则弹出
 */
public class Demo6 {
    public static boolean f() {
        return true;
    }

    public static boolean isGoodBracket(String s) {
        Stack<Character> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                a.push(')');
            if (c == '[')
                a.push(']');
            if (c == '{')
                a.push('}');
            if (c == ')' || c == ']' || c == '}') {
                if (a.size() == 0)
                    return false;
                if (a.pop() != c)
                    return false;
            }
        }
        if (a.size() != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isGoodBracket("...(..[.)..].{.(..).}..."));
        char a = '9';
        int b = a;
    }
}
