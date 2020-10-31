package org.gxuwz.arithmatic.lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Point {    // 代表细胞

    public int x;    // 行
    public int y;    // 列

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point newPoint = (Point) obj;
        return this.x == newPoint.x && this.y == newPoint.y;
    }
}

/**
 * ......................................
 * .........................X............
 * .......................X.X............
 * .............XX......XX............XX.
 * ............X...X....XX............XX.
 * .XX........X.....X...XX...............
 * .XX........X...X.XX....X.X............
 * ...........X.....X.......X............
 * ............X...X.....................
 * .............XX.......................
 * ......................................
 */
public class Main1 {

    static int row = 11;
    static int rank = 38;
    static List<Integer> saveCellNum = new ArrayList<Integer>();    // 存放每一代的细胞数
    static List<Point> livingCell = new ArrayList<Point>();    // 存放活细胞
    static List<Point> nextLivingCell;    // 存放下一代的活细胞
    static int dirX[] = {-1, -1, -1, 0, 0, 1, 1, 1};    // 八个方向，左上、上、右上、左、右、左下、下、右下
    static int dirY[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String args[]) {

        Scanner reader = new Scanner(System.in);
        char tmp[][] = new char[row][rank];
        for (int i = 0; i < row; i++) {
            String str = reader.nextLine();
            tmp[i] = str.toCharArray();
            for (int j = 0; j < rank; j++) {
                if (tmp[i][j] == 'X') {
                    // 加入活细胞
                    livingCell.add(new Point(i, j));
                }
            }
        }
        saveCellNum.add(livingCell.size());    //加入第0代活细胞数目

        for (int loop = 1; loop <= 100; loop++) {    //循环100次观察规律
            nextLivingCell = new ArrayList<Point>();
            for (int i = 0; i < livingCell.size(); i++) {    //遍历当前代的所有活细胞
                Point curPoint = (Point) livingCell.get(i);
                int nigorCells = 0;    //周围八个细胞的存活数目
                for (int j = 0; j < 8; j++) {
                    int dx = curPoint.x + dirX[j];
                    int dy = curPoint.y + dirY[j];
                    // 判断周围是否有存活的细胞
                    if (livingCell.contains(new Point(dx, dy))) {
                        nigorCells++;
                    } else {    //只有在活细胞旁边的死亡细胞才存在存活的可能
                        if (!nextLivingCell.contains(new Point(dx, dy))) {    //需要注意，不同的活细胞周围可能存在同一个死亡细胞
                            int nigorhPoint = 0;
                            for (int k = 0; k < 8; k++) {    //同样判断此白细胞
                                int dxx = dx + dirX[k];
                                int dyy = dy + dirY[k];
                                if (livingCell.contains(new Point(dxx, dyy))) {
                                    nigorhPoint ++;
                                }
                            }
                            if (nigorhPoint == 3) {    //死亡细胞复活
                                nextLivingCell.add(new Point(dx, dy));
                            }
                        }
                    }
                }
                if (nigorCells == 2 || nigorCells == 3) {    //活细胞延续
                    nextLivingCell.add(curPoint);
                }
            }
            //至此上一代的已经更新完毕
            saveCellNum.add(nextLivingCell.size());
            livingCell = nextLivingCell;
        }
        for (int i = 0; i < saveCellNum.size(); i++) {
            System.out.println(saveCellNum.get(i));
        }
//        System.out.println();
//        for(int i=1;i<saveCellNum.size();i++){
//            System.out.println(saveCellNum.get(i)-saveCellNum.get(i-1));
//        }
    }

}
