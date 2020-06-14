package org.gxuwz.arithmatic.practice.t4;

public class Demo2_2 {
    /**
     * 字符翻转
     * @return
     */
    static String f1(String str, int end){
        if(end == 0){
            return str.charAt(0)+"";
        }
        //切第一刀+剩下交给函数切
        return str.charAt(end )+f1(str, end-1);
    }
    public static void main(String[] args){
        System.out.println(f1("abcdef", 5));
    }
}
