package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-10-30 19:14:39
 * @Description:
 *
 * 标题：小计算器
 *
 * 模拟程序型计算器，依次输入指令，可能包含的指令有
 *
 * 1. 数字：'NUM X'，X为一个只包含大写字母和数字的字符串，表示一个当前进制的数
 *
 * 2. 运算指令：'ADD','SUB','MUL','DIV','MOD'，分别表示加减乘，除法取商，除法取余
 *
 * 3. 进制转换指令：'CHANGE K'，将当前进制转换为K进制(2≤K≤36)
 *
 * 4. 输出指令：'EQUAL'，以当前进制输出结果
 *
 * 5. 重置指令：'CLEAR'，清除当前数字
 *
 * 指令按照以下规则给出：
 *
 * 数字，运算指令不会连续给出，进制转换指令，输出指令，重置指令有可能连续给出
 *
 * 运算指令后出现的第一个数字，表示参与运算的数字。且在该运算指令和该数字中间不会出现运算指令和输出指令
 *
 * 重置指令后出现的第一个数字，表示基础值。且在重置指令和第一个数字中间不会出现运算指令和输出指令
 *
 * 进制转换指令可能出现在任何地方
 *
 * 运算过程中中间变量均为非负整数，且小于2^63。
 *
 * 以大写的'A'~'Z'表示10~35
 *
 * [输入格式]
 *
 * 第1行：1个n，表示指令数量
 *
 * 第2..n+1行：每行给出一条指令。指令序列一定以'CLEAR'作为开始，并且满足指令规则
 *
 * [输出格式]
 *
 * 依次给出每一次'EQUAL'得到的结果
 *
 * [样例输入]
 *
 * 7
 * CLEAR
 * NUM 1024
 * CHANGE 2
 * ADD
 * NUM 100000
 * CHANGE 8
 * EQUAL
 *
 * [样例输出]
 *
 * 2040
 *
 * 补充说明：
 *
 * 1. n 值范围: 1 <= n < 50000
 *
 * 2. 初始默认的进制是十进制
 *
 * 资源约定：
 *
 * 峰值内存消耗 < 256M
 *
 * CPU消耗  < 1000ms
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 */
public class Main4_小计算器 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s;
        s = br.readLine();
        int now = 0;
        for (int i = 0; i < s.length(); i++) {
            now = now * 10 + (int) (s.charAt(i) - '0');
        }
        n = now;
        BigInteger now1 = BigInteger.valueOf(0);
        int nowk = 10;
        int pp = -1;
        while (n-- != 0) {
            s = br.readLine();
            if (s.substring(0, 3).compareTo("CLE") == 0) {
                pp = 5;
            } else if (s.substring(0, 3).compareTo("ADD") == 0) {
                pp = 0;
            } else if (s.substring(0, 3).compareTo("SUB") == 0) {
                pp = 1;
            } else if (s.substring(0, 3).compareTo("MUL") == 0) {
                pp = 2;
            } else if (s.substring(0, 3).compareTo("DIV") == 0) {
                pp = 3;
            } else if (s.substring(0, 3).compareTo("MOD") == 0) {
                pp = 4;
            } else if (s.substring(0, 3).compareTo("NUM") == 0) {
                BigInteger now2 = BigInteger.valueOf(0);
                for (int i = 4; i < s.length(); i++) {
                    if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
                        now2 = (now2.multiply(BigInteger.valueOf(nowk))).add(BigInteger.valueOf((int) (s.charAt(i) - '0')));
                    else
                        now2 = (now2.multiply(BigInteger.valueOf(nowk))).add(BigInteger.valueOf((int) (s.charAt(i) - 'A' + 10)));
                }
                if (pp == 5) now1 = now2;
                else if (pp == 0) now1 = now1.add(now2);
                else if (pp == 1) now1 = now1.subtract(now2);
                else if (pp == 2) now1 = now1.multiply(now2);
                else if (pp == 3) now1 = now1.divide(now2);
                else if (pp == 4) now1 = now1.mod(now2);
            } else if (s.substring(0, 3).compareTo("CHA") == 0) {
                int now2 = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) <= '9' && s.charAt(i) >= '0')
                        now2 = now2 * 10 + (int) (s.charAt(i) - '0');
                }
                nowk = now2;
            } else if (s.substring(0, 3).compareTo("EQU") == 0) {
                String str = new BigInteger(now1.toString()).toString(nowk);
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a')
                        System.out.print((char) (str.charAt(i) - 'a' + 'A'));
                    else System.out.print(str.charAt(i));
                }
                System.out.println();
            }
        }
    }
}
