package org.gxuwz.arithmatic.thread.notify_wait;

public class Demo2_交替打印字母 {

    public static void main(String[] args) {
        Work work = new Work();

        Thread1 t1 = new Thread1(work);
        t1.setName("线程1");
        t1.start();

        Thread2 t2 = new Thread2(work);
        t2.setName("线程2");
        t2.start();
    }
}

class Thread1 extends Thread {

    private Work work;

    public Thread1(Work work) {
        this.work = work;
    }

    public void run() {
        for (int i = 97; i < 123; i++) {
            work.print(i);
        }
    }
}

class Thread2 extends Thread {

    private Work work;

    public Thread2(Work work) {
        this.work = work;
    }

    public void run() {
        for (int i = 65; i < 91; i++) {
            work.print(i);
        }
    }
}

class Work {
    public synchronized void print(int i) {
        try {
            this.notify();
            System.out.println(Thread.currentThread().getName() + ": " + (char) i);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
