package org.gxuwz.arithmatic.lanqiao.lanqiao8;


import java.util.*;

/*

标题：日期问题

小明正在整理一批历史文献。这些历史文献中出现了很多日期。
小明知道这些日期都在1960年1月1日至2059年12月31日。
令小明头疼的是，这些日期采用的格式非常不统一，
有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。

比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。

给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？

输入
----
一个日期，格式是"AA/BB/CC"。  (0 <= A, B, C <= 9)

输入
----
输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。

样例输入
----
02/03/04

样例输出
----
2002-03-04
2004-02-03
2004-03-02

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo7_日期问题 {

    // 默认存放有序序列
    private static TreeSet<Integer> set = new TreeSet<Integer>();

    private static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("/");

        f(s[0], s[1], s[2]);
        f(s[2], s[1], s[0]);
        f(s[2], s[0], s[1]);

        list.addAll(set);
        for (int i = 0; i < list.size(); i++) {
            String ss = "" + list.get(i);
            System.out.println(ss.substring(0, 4) + "-" + ss.substring(4, 6) + "-" + ss.substring(6, 8));
        }
    }

    static void f(String year, String mon, String day) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(mon);
        int d = Integer.parseInt(day);

        // 1、判断是19开头还是20开头
        if (y <= 59)
            y += 2000;
        else
            y += 1900;

        // 2、判断是否为闰年，能够被400整除，能被4整除不能被100整除
        // 平年
        if (y % 4 != 0 && m == 2 && d <= 28)
            set.add(Integer.parseInt("" + y + mon + day));
        // 闰年
        if ((y % 400 == 0) || (y % 100 != 0 && y % 4 == 0) && m == 2 && d <= 29)
            set.add(Integer.parseInt("" + y + mon + day));

        // 3、判断不是二月的
        // 月份天数30
        if ((m == 4 || m == 6 || m == 9 || m == 11) && d <= 30)
            set.add(Integer.parseInt("" + d + mon + day));
        // 月份天数31
        if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && d <= 31)
            set.add(Integer.parseInt("" + y + mon + day));
    }
}
