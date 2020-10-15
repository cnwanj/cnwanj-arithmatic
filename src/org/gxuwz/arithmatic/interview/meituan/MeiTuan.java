package org.gxuwz.arithmatic.interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: 韦永恒
 * @date: 2020-10-14 12:52:15
 */
public class MeiTuan {
    /**
     * 时间限制： 3000MS
     * 内存限制： 589824KB
     * 题目描述：
     * 小团的蛋糕铺长期霸占着美团APP中“蛋糕奶茶”栏目的首位，因此总会吸引各路食客前来探店。
     *
     * 小团一天最多可以烤n个蛋糕，每个蛋糕有一个正整数的重量。
     *
     * 早上，糕点铺已经做好了m个蛋糕。
     *
     * 有一个顾客要来买两个蛋糕，他希望买这一天糕点铺中最重的和最轻的蛋糕，并且希望这两个蛋糕的重量恰好为a和b。剩余的n-m个蛋糕可以现烤，请问小团能否满足他的要求？
     *
     *
     *
     * 输入描述
     * 输入包含多组数据，每组数据两行。
     *
     * 每组数据的第一行包含4个整数，n,m,a,b，空格隔开。这里不保证a和b的大小关系。
     *
     * 接下来一行m个数，空格隔开，代表烤好的蛋糕重量。
     *
     * 1≤n,m,a,b≤1000 , m≤n , 蛋糕重量不会超过1000
     *
     * 输出描述
     * 对于每一组数据，如果可以办到顾客的要求，输出YES，否则输出NO
     */
    public static void main1(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);

            String[] input = scanner.nextLine().split(" ");


            //还可以产出个数
            int num = Integer.parseInt(input[0]) - Integer.parseInt(input[1]);


            //已经生产的质量
            String[] weight = scanner.nextLine().split(" ");
            //当前最大和最小值
            int max = Integer.parseInt(weight[0]), min = Integer.parseInt(weight[0]);
            for (int i = 0; i < weight.length; i++) {
                if (max < Integer.parseInt(weight[i])) {
                    max = Integer.parseInt(weight[i]);
                }
                if (min > Integer.parseInt(weight[i])) {
                    min = Integer.parseInt(weight[i]);
                }
            }

            //希望的重量
            int inputMin = Integer.min(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            int inputMax = Integer.max(Integer.parseInt(input[2]), Integer.parseInt(input[3]));

            if (inputMin <= min && inputMax >= max ) {
                if (inputMin < min && inputMax > max && num>=2) {
                    System.out.println("YES");
                }else if (inputMax == max && inputMin == min){
                    System.out.println("YES");
                }else if ((inputMax == max && num >=1) || (inputMin == min && num >= 1)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }


    /**
     * 小团是某综艺节目的策划，他为某个游戏环节设计了一种晋级规则，已知在这个游戏环节中每个人最后都会得到一个分数score_i，显而易见的是，游戏很有可能出现同分的情况，小团计划该环节晋级人数为x人，则将所有人的分数从高到低排序，所有分数大于等于第x个人的分数且得分不为0的人都可以晋级。
     *
     * 请你求出本环节的实际晋级人数。显然这个数字可能是0，如果所有人的得分都是0，则没有人满足晋级条件。
     *
     *
     *
     * 输入描述
     * 输入第一行包含两个正整数n和x，分别表示参加本环节的人数，和小团指定的x。
     *
     * 输入第二行包含n个整数，每个整数表示一位选手的得分。
     *
     * 输出描述
     * 输出仅包含一个整数，表示实际晋级人数
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //n参加人数,x指定数字
        String[] input = scanner.nextLine().split(" ");

        int count = Integer.parseInt(input[0]);//人数
        int num = Integer.parseInt(input[0]);//指定的数字

        String[] score = scanner.nextLine().split(" ");

        //排序
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (Integer.parseInt(score[i])>Integer.parseInt(score[j])){
                    String tmp = score[i];
                    score[i] = score[j];
                    score[j] = tmp;
                }
            }
        }

        int xsocre = Integer.parseInt(score[num-1]);
        int result = 0;

        for (int i = 0; i < num; i++) {
            if (Integer.parseInt(score[i])>xsocre&&Integer.parseInt(score[i])!=0){
                result++;
            }
        }
        System.out.println(result);
    }

    /**
     * 小美请小团吃回转寿司。转盘上有N盘寿司围成一圈，第1盘与第2盘相邻，第2盘与第3盘相邻，…，第N-1盘与第N盘相邻，第N盘与第1盘相邻。
     *
     * 小团认为第i盘寿司的美味值为A[i]（可能是负值，如果小团讨厌这盘寿司）。
     *
     * 现在，小团要在转盘上选出连续的若干盘寿司，使得这些寿司的美味值之和最大（允许不选任何寿司，此时美味值总和为0）。
     *
     *
     *
     * 输入描述
     * 第一行输入一个整数T（1<=T<=10），表示数据组数。
     *
     * 每组数据占两行，第一行输入一个整数N（1<=N<=10^5）；
     *
     * 第二行输入N个由空格隔开的整数，表示A[1]到A[N]（-10^4<=A[i]<=10^4）。
     *
     * 输出描述
     * 每组数据输出占一行，输出一个整数，表示连续若干盘寿司的美味值之和的最大值。
     * @param args
     */
    public static void main3(String[] args) {

    }

    /**
     * 小团找到一颗有n个节点的苹果树，以1号节点为根，且每个节点都有一个苹果，苹果都有一个颜色，但是这棵树被施加了咒术，这使得小团只能从某一个节点的子树中选取某一种颜色的拿。小团想要拿到数量最多的那种颜色的所有苹果，请帮帮她。每次她会指定一个节点t，如果小团只能从节点t的子树中选取某一种颜色的苹果，选取什么颜色能拿到最多的苹果？如果有多种颜色都可以拿同样多的苹果，输出颜色编号最小的那个对应的编号。
     *
     *
     *
     * 节点x的子树定义为所有将x当作祖先的节点，x也视为x的子树的一部分。
     *
     *
     *
     * 输入描述
     * 第一行一个正整数 n 表示这颗树上节点的个数。
     *
     * 接下来n-1行，每行两个正整数x­­i , yi,表示树上第i条边连接的两个节点。
     *
     * 接下来一行n个正整数c­i，分别表示从1~n号节点上的苹果的颜色。
     *
     * 接下来一行一个正整数q,表示接下来有q次独立的询问。
     *
     * 接下来q行，每行一个正整数t表示询问：如果小团只能从节点t的子树中选取某一种颜色的苹果，选取什么颜色能拿到最多的苹果？如果有多种颜色都可以拿同样多的苹果，输出颜色编号最小的那个对应的编号。
     *
     * n ≤ 5000,  1≤xi,yi,t≤n,  ci≤1000000000,  q≤10000
     *
     * 输出描述
     * 输出q行，每行一个整数，表示答案。
     * @param args
     */
    public static void main4(String[] args) {

    }
}
