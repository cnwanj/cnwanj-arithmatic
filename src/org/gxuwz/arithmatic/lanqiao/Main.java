package org.gxuwz.arithmatic.lanqiao;

public class Main {

    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3000; j++) {
                    num++;
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(num);
    }
}


