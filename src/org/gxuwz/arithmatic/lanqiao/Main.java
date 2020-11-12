package org.gxuwz.arithmatic.lanqiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Integer> map = new HashMap<String, Integer>();
    static int n;

    /**
     * 4
     * ***
     * L**L
     * L**L***L
     * L*****L
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            char[] ch = sc.nextLine().toCharArray();
            System.out.println(f(ch));
        }
    }

    static int f(char[] ch) {
        int tag = -1;
        String s = String.valueOf(ch);
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.contains("LOL"))
            return -1;
        else if (!s.contains("*")) {
            tag = 0;
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '*') {
                ch[i] = 'L';
                int res = f(ch);
                map.put(new String(ch), res);
                ch[i] = '*';
                if (res == -1)
                    return 1;
                if (res == 0)
                    tag = 0;
                ch[i] = 'O';
                res = f(ch);
                map.put(new String(ch), res);
                ch[i] = '*';
                if (res == -1)
                    return 1;
                if (res == 0)
                    tag = 0;
            }
        }
        return tag;
    }
}
