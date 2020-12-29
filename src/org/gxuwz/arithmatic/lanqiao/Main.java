package org.gxuwz.arithmatic.lanqiao;

import java.util.HashMap;

public class Main extends HashMap {

    public static void main(String args[]) {
        Main map = new Main();
        map.put("zs", "zs1");
        map.put("ls", "ls1");
        map.put("ww", "ww1");
        map.put("abcd", "abcd1");
    }

//    static void put(String key, String val) {
//        System.out.println(key + "-" + val + "(哈希码：" + key.hashCode() + "，数组下标：" + Math.abs(key.hashCode() % 15) + ")");
//    }
}
