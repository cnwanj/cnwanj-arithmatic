package org.gxuwz.arithmatic.dataStructures.Demo01_稀疏数组;

public class SparseArray {
    public static void main(String[] args) {
        // 1.创建一个原始的二维数组
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        // 2.输出原始数组
        System.out.println("原始二维数组：");
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 3.将原始数组转稀疏数组
        // 4.遍历原始数组得到有效个数
        int sum = 0;
        for (int[] row : arr)
            for (int i : row)
                if (i != 0) sum++;
        // 5.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 6.给稀疏数组存放有效值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 7.遍历二维数组将非0数存放到稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        // 8.输出稀疏数组
        System.out.println("稀疏数组：");
        for (int[] row : sparseArr) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
        // 9.将稀疏数组转换为二维数组
        int[][] arr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("转换后的二维数组：");
        for (int[] row : arr1) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
