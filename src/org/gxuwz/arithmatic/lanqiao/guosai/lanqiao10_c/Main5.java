package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10_c;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:13
 * @Description:
 *
 * 在一个5*5的方格上走边界点，其实也就是6*6的图，从左上角开始走，不走重复点且在12步之内走回左上角点
 *
 * 问方案数直接dfs,需要减掉 (0,0)->(1,0)->(0,0)和(0,0)->(0,1)->(0,0)，这两个路线都重合了
 *
 * 结果: 208-2=206
 *
 * 【思路】dfs从起点往右边位置(0, 1)遍历，遍历到起点的下方位置(1, 0)时算完成一次，得出结果乘与2
 *
 */
public class Main5 {

    static int N = 6, count = 0, num = 0;
    static int[][] a = new int[N][N], xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        a[0][0] = 1;
        dfs(0, 0);
        System.out.println(count * 2);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < xy.length; i++) {
            int o = x + xy[i][0];
            int p = y + xy[i][1];
            if (o >= 0 && o < N && p >= 0 && p < N && a[o][p] == 0) {
                // 步长不等于0 && 步长不超过12，因为只记到(1, 0)位置，所以为10步 && 位置为(1, 0)
                if (num != 0 && num <= 10 && (o == 1 && p == 0)) {
                    // 记录次数
                    count++;
                } else {
                    // 步长加一
                    num++;
                    a[o][p] = 1;
                    dfs(o, p);
                    // 回溯步长减一
                    num--;
                    a[o][p] = 0;
                }
            }
        }
    }
}
