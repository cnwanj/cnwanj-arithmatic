package org.gxuwz.arithmatic.lanqiao;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws Exception {

        // 方法1：重写run方法，旧写法
        new Thread() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        }.start();

        // 重写run方法，lambda表达式写法，() -> {}：表示无参无返回值，(res) -> {return r}：表示有参有返回值
        new Thread(() -> {
            System.out.println("线程1");
        }).start();

        // 方法2：Runnable方法实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2");
            }
        }).start();

        // 方法3：Callable方法实现，有返回值
        Callable<Integer> callable = () -> {
            return 3;
        };
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(task.get());

    }
}






