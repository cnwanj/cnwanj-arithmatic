package org.gxuwz.arithmatic.practice.t1;

/**
 * 冒泡排序
 */
public class Demo2 {
    public static void f(int[] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length-i-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,1,5,3};
        f(a);
    }
}
