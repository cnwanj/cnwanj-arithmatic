package org.gxuwz.arithmatic.lanqiao.lanqiao9;

import java.util.*;

/*
 * 标题：日志统计
 *
 * 小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：
 *
 * ts id
 *
 * 表示在ts时刻编号id的帖子收到一个"赞"。
 *
 * 现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。
 *
 * 具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。
 *
 * 给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
 *
 * 【输入格式】
 * 第一行包含三个整数N、D和K。
 * 以下N行每行一条日志，包含两个整数ts和id。
 *
 * 对于50%的数据，1 <= K <= N <= 1000
 * 对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
 *
 * 【输出格式】
 * 按从小到大的顺序输出热帖id。每个id一行。
 *
 * 【输入样例】
 7 10 2
 0   1
 0   10
 10  10
 10  1
 9   1
 100 3
 100 3
 *
 * 【输出样例】
 * 1
 * 3
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo8_日志统计 {

    static class R {
        int ts;
        int id;

        public R() {
        }

        public R(int ts, int id) {
            this.ts = ts;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt(), k = sc.nextInt();
        R[] rs = new R[n];
        for (int i = 0; i < n; i++) {
            R r = new R(sc.nextInt(), sc.nextInt());
            rs[i] = r;
        }

        // 对id进行排序
        Arrays.sort(rs, new Comparator<R>() {
            @Override
            public int compare(R r1, R r2) {
                return r1.id - r2.id;
            }
        });

        t(d, k, rs);
//        System.out.println();
//        for (int i = 0; i < rs.length; i++) {
//            System.out.println(rs[i].ts+"-"+rs[i].id);
//        }
    }

    /*
     * @param d  时间间隔
     * @param k  点赞数量
     * @param R  数据
     */
    static void t(int d, int k, R[] rs) {
        // 存放每个编号的点赞数量
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 存放每一段编号相等的数据
        Vector<R> v = new Vector<R>();

        // 存放结果
        Vector<Integer> res = new Vector<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        v.add(rs[0]);
        int p = v.get(0).id;
        // 将排好序的每一段编号分出来
        for (int i = 1; i < rs.length; i++) {
            // 若相邻的编号相等
            if (p == rs[i].id) {
                v.add(rs[i]);
            } else {
                if (v.size() >= k) {
                    list = put(list, v);
                    get(k, d, list, v.get(0).id);

                }
                list.clear();
                v.clear();
                v.add(rs[i]);
                p = rs[i].id;
            }
        }
        list = put(list, v);
        get(k, d, list, v.get(0).id);
    }

    // 循环遍历当前编号内的时间是否符合
    static void get(int k, int d, List<Integer> list, int id) {
        int l = 0, r = 0;
        // 判断是否符合d时间内获k赞
        while (l <= r && r < list.size()) {
            // 若两指针的区间在k范围内
            if (r - l + 1 <= k) {
                // 若在时间d内
                if (list.get(r) - list.get(l) < d) {
                    // 输出编号
                    System.out.println(id);
                    break;
                } else {
                    l++;
                }
            } else {
                // 若超出k范围，右指针+1
                r++;
            }
        }
    }

    static List<Integer> put(List<Integer> list, Vector<R> v) {
        // 将时间放入list集合中，并排序
        for (int j = 0; j < v.size(); j++) {
            list.add(v.get(j).ts);
        }
        // 排序时间
        Collections.sort(list);
        return list;
    }
}
