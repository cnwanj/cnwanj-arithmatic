package org.gxuwz.arithmatic.nowcoder.main_练习;

public class Demo12_递增数组 {

    public long IncreasingArray (int[] array) {
        long p = 0;
        for (int i = 1; i < array.length; i++)
            if (array[i] <= array[i-1])
                p += array[i-1] - array[i] + 1;
        return p;
    }

    public static void main(String[] args) {
        Demo12_递增数组 d = new Demo12_递增数组();
        int[] arr = {1, 2, 1, 1};
        System.out.println(d.IncreasingArray(arr));
    }

}
