package org.gxuwz.arithmatic.nowcoder;

/**
 *
 */
public class Demo14_最少素数拆分 {

    static int MinPrimeSum(int N) {
        if (N <= 1)
            return 0;
        if (N == 2)
            return 1;
        if (N % 2 == 0)
            return 2;
        int a = 0;
        int b = 0;
        /**
         * 遍历奇数，只遍历到该数的开平方就可以
         *
         * 其实不需要计算到n/2，只需要i*i<n就行，因为如果n可以被一个数整除，
         * 那么其中一个数一定小于等于n开方，另一个大于等于n的开方，所以只需要算到这儿，到后面就是多余的了
         */
        for (int i = 3; i < Math.sqrt(N); i += 2) {
            // 判断是否为素数
            if (N % i == 0)
                a = 1;
            // 判断该数的上一个奇数是否为素数
            if ((N - 2) % i == 0)
                b = 1;
        }
        if (a == 0)
            return 1;
        else if (a == 1 && b == 0)
            return 2;
        else
            return 3;
    }

    public static void main(String[] args) {
        System.out.println(MinPrimeSum(221));
    }
}
