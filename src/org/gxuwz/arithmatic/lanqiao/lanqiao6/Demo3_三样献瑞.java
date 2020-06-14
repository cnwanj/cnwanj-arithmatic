package org.gxuwz.arithmatic.lanqiao.lanqiao6;

import java.util.HashSet;
import java.util.Set;

/*

三羊献瑞

观察下面的加法算式：

      祥 瑞 生 辉
  +   三 羊 献 瑞
-------------------
   三 羊 生 瑞 气

      a b c d
  +   e f g b
-------------------
    e f c b h

(如果有对齐问题，可以参看【图1.jpg】)

其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。

请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。

 */
public class Demo3_三样献瑞 {

    public static void main(String[] args) {
        int a = 0, b = 0;
        int s = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        a = Integer.parseInt("" + i + j + k + l);
//                        sum = n + f();
                        for (int m = 1; m < 10; m++) {
                            for (int o = 0; o < 10; o++) {
                                for (int p = 0; p < 10; p++) {
                                    for (int q = 0; q < 10; q++) {
                                        b = Integer.parseInt("" + m + o + p + q);
                                        if (a % 1000 / 100 == b % 10) {
                                            //      a b c d
                                            //  +   e f g b
                                            //-------------------
                                            //    e f c b h
                                            //       9567
                                            //  +    1085
                                            //-------------------
                                            //      10652
                                            s = a + b;
                                            if (("" + s).length() == 5) {
                                                if (s % 100 / 10 == b % 10 && s % 1000 / 100 == a % 100 / 10 && s % 10000 / 1000 == b % 1000 / 100 && s / 10000 == b % 10000 / 1000) {
                                                    set.add(i);
                                                    set.add(j);
                                                    set.add(k);
                                                    set.add(l);
                                                    set.add(m);
                                                    set.add(o);
                                                    set.add(p);
                                                    set.add(q);
                                                    if (set.size() == 7)
                                                        System.out.println(a + "+" + b + "=" + s);
                                                    set.clear();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(f());
    }

    static int f() {
        int n = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        n = Integer.parseInt("" + i + j + k + l);
                        return n;
                    }
                }
            }
        }
        return n;
    }
}
