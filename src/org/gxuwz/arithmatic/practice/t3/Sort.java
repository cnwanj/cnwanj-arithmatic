package org.gxuwz.arithmatic.practice.t3;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    static List<Student> f(List<Student> stuList, int n){//  list=10  n=8
        List<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int r = (int) (Math.random() * stuList.size());
            list.add(stuList.get(r));
            stuList.remove(r);
        }
        return list;
    }
    static void f1(int n){
        int[] arr = new int[]{1,2,4};
        for(int i=0; i<arr.length; i++){
            int r = (int)(Math.random()*n);
            for(int j=0; j<arr.length; j++){
                if(arr[j] == r){
//                    if(j == arr.length-1){
//                        arr[j+1] = r;
//                    }
                    continue;
                }
            }
            System.out.println();
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
//        List<Student> list = new ArrayList<>();
//        for(int i=0; i<10; i++){
//            Student stu = new Student(i+"", "张三"+i);
//            list.add(stu);
//        }
//        List<Student> students = f(list, 8);
//        for(Student s : students){
//            System.out.println(s);
//        }
        f1(5);
    }
}
