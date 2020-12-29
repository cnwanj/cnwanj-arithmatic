package org.gxuwz.arithmatic.interview.sourcecode.map;

//import java.util.HashMap;
//import java.util.Map;
/**
 * @Author: vovhh
 * @Date: 2020-12-29 18:12:49
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < 1000000; i++) {
//
//            map.put("zl" + i, "abc" + i);
//        }
//        System.out.println(map);
        map.put("zs", "18");
        map.put("ls", "19");
        map.put("ww", "20");
        map.put("zl", "21");
        System.out.println(map.get("zs"));
        System.out.println(map.get("ls"));
        System.out.println(map.get("ww"));
        System.out.println(map.get("zl"));
    }
}
