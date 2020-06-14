package org.gxuwz.arithmatic.dataStructures.Demo05_递归;

/*
 * 八皇后问题：
 * 规则：
 *      同一行、同一列或者同一斜线不能有同一皇后
 */
public class Queen8 {
    // 不是共有多少个皇后
    int max = 8;
    /*
     * arr = {0, 4, 7, 5, 2, 6, 1,3}
     * 0：表示第一行， 第一列
     * 4：表示第二行， 第五列
     * 7：表示第三行， 第八列...
     */
    int[] arr = new int[max];
    public static void main(String[] args){
        Queen8 q = new Queen8();
        q.check(0);
    }
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        //遍历一行里面的每一列
        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(judge(n))
                check(n+1);
        }
    }
    // 判断皇后是否冲突
    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            // arr[i] == arr[n]若值相等，表示在同一列
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    // 打印
    private void print(){
        for(int a : arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
