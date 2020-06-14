package org.gxuwz.arithmatic.dataStructures.Demo05_递归;

/**
 * 递归，解决迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        // 创建一个二维数组
        int[][] map = new int[8][7];
        // 将第一行和最后一行设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 将第一列和最后一列设置为1
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 添加障碍物
        map[3][1] = 1;
        map[3][2] = 1;

        // 遍历常见好的二维数组
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        // 遍历输出走过的二维数组
        System.out.println("输出走过的二维数组:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1、map[1][1]为小球的起始位置
     * 2、map[6][7]为小球的终点
     * 3、小球走过的位置设置为2
     * 路径寻找策略：下->右->上->左
     *
     * @param map 地图
     * @param i   横坐标
     * @param j   纵坐标
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //找到终点
            return true;
        } else {
            if (map[i][j] == 0) { // 若为0，则该路没有走过
                // 将该位置设置为2
                map[i][j] = 2;
                // 路径寻找策略：下->右->上->左
                if (setWay(map, i + 1, j)) {// 下
                    return true;
                } else if (setWay(map, i, j + 1)) {// 右
                    return true;
                } else if (setWay(map, i - 1, j)) {// 上
                    return true;
                } else if (setWay(map, i, j - 1)) {// 左
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {// 否则为1,2,3
                return false;
            }
        }
    }

    // 右上左下
    public static boolean setWay1(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 终点
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay1(map, i, j + 1)) {
                    return true;
                } else if (setWay1(map, i - 1, j)) {
                    return true;
                } else if (setWay1(map, i, j - 1)) {
                    return true;
                } else if (setWay1(map, i + 1, j)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    // 左下右上
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 终点
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay2(map, i, j - 1)) {
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    return true;
                } else if (setWay2(map, i - 1, j)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
