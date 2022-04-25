package org.gxuwz.arithmatic.lanqiao;


public class Main {

    public static void main(String[] args) {
        System.out.println(f(2, 4,4, 4));
    }

    public static int f(int cur, int step, int aim, int n) {
        // 如果步数走完了，并且走到终点aim，则计一次路径，否则返回0
        if (step == 0) {
            return cur == aim ? 1 : 0;
        }
        // 若cur为1，只能走到2的位置
        if (cur == 1) {
            return f(2, step - 1, aim, n);
        }
        // 若cur为n，只能走到n-1的位置
        if (cur == n) {
            return f(n - 1, step - 1, aim, n);
        }
        // 如果在中间位置，则是左右两边都可以走
        return f(cur - 1, step - 1, aim, n) + f(cur + 1, step - 1, aim, n);
    }
}







