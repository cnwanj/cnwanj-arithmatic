package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao11_校选;

/**
 * @description:
 * @author: 韦永恒
 * @date: 2020-10-16 20:47:31
 *
 * 4.（填空题15分）现假设有一根足够长的面筋，
 *
 * 假设我们第1次先将面筋对折1次后切半，那么我们将得到3根面筋，
 *
 * 第2次我们将3根面筋分别连续对折2次后切半，那么我们将得到15根面筋，
 *
 * 以此类推，第7次操作后我们将得到多少根面筋。
 *
 * 注意：需要提交的是一个整数，不要填写任何多余内容。
 *
 * 【答案】
 * 635037975
 *
 * 【思路】
 * 先计算一条面筋被对折后相切后得到的面筋数sum，再乘与上一次切得的面筋数
 */
public class Demo4_切面筋 {
    /**
     * 对于每根面筋进行连续对折n次后切半得到的面筋根数
     * @param n 连续对折次数
     * @return 得到的面筋根数
     */
    public static int calculateGlutenForN(int n){
        int num = 2;
        for (int i = 0; i < n; i++) {
            num = num * 2 - 1;
        }
        return num;
    }

    /**
     * 递归计算进行n次操作后面筋的总根数
     * @param current 当前操作次数
     * @param target 目标操作次数
     * @param gluten 当前面筋根数
     * @return n次操作后面筋的总根数
     */
    public static int calculateGluten(int current,int target,int gluten){
        if (current > target){
            // 达到目标操作次数，返回面筋总根数
            System.out.println(gluten);
            return gluten;
        }

        // 计算对于当前操作每根面筋进行current次连续对折并切半后得到的面筋根数
        int i = calculateGlutenForN(current);
        System.out.println(i);
        // 乘以当前可进行操作的面筋根数
        gluten = gluten * i;
        // 继续递归
        return calculateGluten(current + 1,target,gluten);

    }
    public static void main(String[] args) {
        calculateGluten(1,7,1);
    }
}

// 方法二
class Demo4_切面筋1 {
    public static void main(String[] args) {
        long sum = 1, num = 2;
        for (int i = 1; i <= 7; i++) {
            num = num * 2 - 1;
            sum = sum * num;
        }
        System.out.println(sum);
    }

    // 先计算一条面筋被对折后相切后得到的面筋数Num
    static int cutNum(int n) {
        if (n == 1)
            return 3;
        return n * n + 1;
    }
}
