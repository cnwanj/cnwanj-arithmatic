package org.gxuwz.arithmatic.dataStructures.algorithm.Demo02_背包问题;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
背包问题：有一个背包，容量为4磅 ， 现有如下物品

物品	重量	价格
吉他(G)	 1	    1500
音响(S)	 4	    3000
电脑(L)	 3	    2000

v[i][j]：i：第几个物品；j：背包容量
 0  1     2     3     4
0 [0, 0,    0,    0,    0]
1 [0, 1500, 1500, 1500, 1500]
2 [0, 1500, 1500, 1500, 3000]
3 [0, 1500, 1500, 2000, 3500]
1、要求达到的目标为装入的背包的总价值最大，并且重量不超出
2、要求装入的物品不能重复

 */
public class Knapsack {

    public static void main(String[] args) {
        // 每个物品的重量
        int[] w = {1, 4, 3};
        // 每个物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包的容量
        int m = 4;
        // 物品个数
        int n = val.length;
        // v[i][j]: 表示前i个物品中能够装入容量为j的最大价值
        int v[][] = new int[n + 1][m + 1];
        // 记录放入物品的情况
        int[][] path = new int[n + 1][m + 1];

        // 初始化第一行和第一列为0
        // i: 第几个物品； j: 第几列（规定的背包重量）
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                // 若新增的重量大于指向的当前单元格的重量，直接将上一个单元格赋值给当前单元格
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // 若当前行的重量小于当前列规定的重量
                    // max(上一个单元格重量, 当前单元格最大重量)
                    // v[i][j] = Math.max(v[i-1][j], val[i-1] + v[i-1][j - w[i-1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }

//        for (int i = 0; i < path.length; i++) {
//            System.out.println(Arrays.toString(path[i]));
//        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }


    }
}
