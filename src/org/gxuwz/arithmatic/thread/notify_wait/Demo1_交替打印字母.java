package org.gxuwz.arithmatic.thread.notify_wait;

public class Demo1_交替打印字母 {

    public static void main(String[] args) {
        Task task = new Task();

        // 线程1执行
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 97; i < 123; i++) {
                    task.print(i);
                }
            }
        });
        t1.setName("线程1");
        t1.start();

        // 线程2
        Thread t2 = new Thread(new Runnable() {
           public void run() {
               for (int i = 65; i < 91; i++) {
                   task.print(i);
               }
           }
        });
        t2.setName("线程2");
        t2.start();
    }
}

class Task {
    public synchronized void print(int i) {
        try {
            this.notify();
            System.out.println(Thread.currentThread().getName()+ ": " + (char)i);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
