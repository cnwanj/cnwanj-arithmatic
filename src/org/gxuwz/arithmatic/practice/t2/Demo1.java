package org.gxuwz.arithmatic.practice.t2;

import java.util.Scanner;
import java.util.Vector;

/**
 * 字符排序
 * 算法是这样的：
 * 给定N个不同字符，将这N个字符进行全排列，
 * 最终的结果将会是N!种。
 * 如：给定A、B、C三个不同的字符，
 * 则结果为：ABC、ACB、BAC、BCA、CAB、CBA一共3!=3*2=6种情况。
 */
public class Demo1 {
    public static long count = 0;
    public static void fullPermutation(Vector<Character> source, Vector<Character> result){
        if(source.size() == 0){
            for(int i=0; i<result.size(); i++){
                System.out.print(result.elementAt(i));
            }
            System.out.println();
            count++;
        }
        for(int i=0; i<source.size(); i++){
            Vector<Character> tsource = new Vector<>(source);   //将输入的字符复制到新的集合中
            Vector<Character> tresult = new Vector<>(result);   //将集合结果复制到新的集合中
            tresult.add(source.elementAt(i));       //将字符元素添加到新的结果集合中
            tsource.remove(i);                      //去除掉数组的字符元素
            fullPermutation(tsource, tresult);      //先执行完递归再执行for循环
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Vector<Character> source = new Vector<>();
        Vector<Character> result = new Vector<>();
        for(int i=0; i<n; i++){
            source.add((char)('A'+i));
        }
        fullPermutation(source, result);
        System.out.println(count);

//        Vector<Character> tsource = new Vector<>(source);
//        for(int i=0; i<n; i++){
//            System.out.print(tsource.elementAt(i));
//        }
    }
}
