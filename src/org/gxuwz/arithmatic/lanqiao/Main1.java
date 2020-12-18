package org.gxuwz.arithmatic.lanqiao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main1 {

    public static void main(String[] args) {

//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        for (Integer s : set) {
//            System.out.println(s);
//        }
        String s = new String("1");
        System.out.println(s.hashCode());
//        set.forEach(System.out::println);

//        ArrayList<String> l2 = new ArrayList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
//        l1.add(1);
//        l1.add(2);
//        System.out.println(l1);

//        Thread t = new Thread();
//        t.sleep(1);
//        t.wait();

//        LocalDateTime dt = LocalDateTime.now();
//        System.out.println(dt.getYear());
//        System.out.println(dt.getMonthValue());
//        System.out.println(dt.getDayOfMonth());
//        System.out.println(dt.getHour());
//        System.out.println(dt.getMinute());
//        System.out.println(dt.getSecond());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dt.format(dtf));

//        Date d = new Date("1970-01-01 00:00:00");
//        System.out.println(d.getTime());

//        StringBuilder sb = new StringBuilder("123");
//        System.out.println(sb.reverse());

//        String a = "123";
//        System.out.println(a.valueOf(12));
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++) {
//                    s.append("a");
//                }
//            }).start();
//        }

//        System.out.println(s.length());

//        Object[] o = new Object[5];
//        Arrays.fill(o, 1);
//        System.out.println(Arrays.toString(o));
//        o = Arrays.copyOf(o, o.length + 1);
//        System.out.println(Arrays.toString(o));
//        int p = 1;
//        System.arraycopy(o, 1, o, p + 1, o.length - (p + 1));
//        o[p] = 2;
//        System.out.println(Arrays.toString(o));

//        l2.add("a");
//        ArrayList<String> l3 = (ArrayList<String>) l2.clone();
//        System.out.println(l3);

//        System.out.println(f("abcdef"));
    }

    static String f(String s) {
        if (s == null || s.length() <= 1)
            return s;
        return f(s.substring(1)) + s.charAt(0);
    }
}
