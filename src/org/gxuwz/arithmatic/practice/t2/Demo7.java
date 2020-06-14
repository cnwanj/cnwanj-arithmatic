package org.gxuwz.arithmatic.practice.t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 手里拿着一套扑克牌
 * 从前拿一张放到后面
 * 再从前面拿一张放到桌子上...
 * 如此的循环操作，求最后扑克牌的顺序
 */
public class Demo7 {
    public static List f(List a) {
        List b = new ArrayList();
        for (; ; ) {
            if (a == null) {
                return null;
            }
            a.add(a.remove(0));
            b.add(a.remove(0));
        }
//        List c = new ArrayList();

    }

    public static List moveCard(List src) {
        if (src == null)
            return null;
        List dst = new ArrayList();
        for (; ; ) {                            //死循环相当于：while(true){}
            if (src.size() == 0)             //当手里的牌为空时，退出循环
                break;
            src.add(src.remove(0));  //将扑克牌放后面
            dst.add(src.remove(0));  //将扑克牌放桌面
        }
        return dst;
    }

    public static void main(String[] args) {
        List a = new ArrayList();
        //addAll:将集合中的每一个元素添加到另一个集合中
        //Arrays.asList():将数组转换为集合
        String[] str = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        a.addAll(Arrays.asList(str));
        System.out.println(moveCard(a));
    }
}
