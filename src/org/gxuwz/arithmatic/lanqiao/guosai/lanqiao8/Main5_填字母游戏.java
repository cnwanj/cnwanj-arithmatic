package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: vovhh
 * @Date: 2020-10-30 19:14:39
 * @Description:
 *
 * 标题：填字母游戏
 *
 * 小明经常玩 LOL 游戏上瘾，一次他想挑战K大师，不料K大师说：
 * “我们先来玩个空格填字母的游戏，要是你不能赢我，就再别玩LOL了”。
 *
 * K大师在纸上画了一行n个格子，要小明和他交替往其中填入字母。
 *
 * 并且：
 *
 * 1. 轮到某人填的时候，只能在某个空格中填入L或O
 * 2. 谁先让字母组成了“LOL”的字样，谁获胜。
 * 3. 如果所有格子都填满了，仍无法组成LOL，则平局。
 *
 * 小明试验了几次都输了，他很惭愧，希望你能用计算机帮他解开这个谜。
 *
 * 本题的输入格式为：
 * 第一行，数字n（n<10），表示下面有n个初始局面。
 * 接下来，n行，每行一个串，表示开始的局面。
 *   比如：“******”, 表示有6个空格。
 *   “L****”,   表示左边是一个字母L，它的右边是4个空格。
 *
 * 要求输出n个数字，表示对每个局面，如果小明先填，当K大师总是用最强着法的时候，小明的最好结果。
 * 1 表示能赢
 * -1 表示必输
 * 0 表示可以逼平
 *
 *
 * 例如，
 * 输入：
 * 4
 * ***
 * L**L
 * L**L***L
 * L*****L
 *
 * 则程序应该输出：
 * 0
 * -1
 * 1
 * 1
 *
 * 资源约定：
 * 峰值内存消耗 < 256M
 * CPU消耗  < 1000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 */
public class Main5_填字母游戏 {
    // count 奇数是小明
    static int n = 0, m = 9, count = 0;
    static char[][] a;
    static char[] lo = {'L', 'O'};
    // true 小明、false K大师
    static boolean who;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            f(a[i], 0);
        }
    }

    /**
     * 1
     * L**L
     */
    static void f(char[] a1, int p) {
        if (p > a1.length - 1) {
            return;
        }
        if (a1[p] == 'L' || a1[p] == 'O') {
            p ++;
        }
        for (int i = 0; i < lo.length; i++) {
            count ++;
            a1[p] = lo[i];
            // 填入的元素至少要有三个以上，即下标为2
            if (p >= 2) {
                // 每填一个字母都进行判断
//                System.out.print(count + " " + count % 2 + " " + check(a1, p) + " ");
                System.out.println(Arrays.toString(a1));
                return;
            }
            System.out.println(Arrays.toString(a1));

            f(a1, 1 + p);
            count --;
            a1[p] = '*';
        }
    }

    /**
     * 每填一个字母都进行判断
     * @param a1    对已经填有的字母进行判断
     * @param p     填入的下标
     * @return      1 小明赢、-1 小明输、0 平局
     */
    static int check(char[] a1, int p) {
        int c = 0;
        // 判断是否已经组成LOL字样，即当前玩家p开始往后遍历
        for (int i = p; i < a1.length; i++) {
            if (a1[i] == '*')
                break;
            if (a1[i] == 'L' && a1[i - 1] == 'O' && a1[i - 2] == 'L') {
                if (count % 2 == 1) {
                    // 小明赢
                    c = 1;
                } else {
                    c = -1;
                }
            }
        }
        return c;
    }
}

class Main5_填字母游戏1 {

    static Map<String, Integer> map;
    static int n;

    public static void main(String[] args) {
        map = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            char[] ch = sc.nextLine().toCharArray();
            System.out.println(f(ch));
        }
        sc.close();
    }

    /**
     * 4
     * ***
     * L**L
     * L**L***L
     * L*****L
     */
    static int f(char[] ch) {
        int tag = -1;
        String s = String.valueOf(ch);
        if (map.containsKey(s))
            return map.get(s);
        if (s.contains("LOL")) {        // 已经存在LOL，表示输了
            return -1;
        } else if (!s.contains("*")) {  // 若不包含空位，表示平局
            tag = 0;
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '*') {
                ch[i] = 'L';
                // 递归
                int res = f(ch);
                // 通过map进行记忆化，防止重复递归
                map.put(String.valueOf(ch), res);
                ch[i] = '*';
                if (res == -1)
                    return 1;
                if (res == 0)
                    tag = 0;

                ch[i] = 'O';
                res = f(ch);
                map.put(String.valueOf(ch), res);
                ch[i] = '*';
                if (res == -1)
                    return 1;
                if (res == 0)
                    tag = 0;
            }
        }
        return tag;
    }
}
