package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao7;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-27 13:26:59
 * @Description:
 *
 * 愤怒小鸟
 *
 * X星球愤怒的小鸟喜欢撞火车！
 *
 * 一根平直的铁轨上两火车间相距 1000 米
 *
 * 两火车 （不妨称A和B） 以时速 10米/秒 相对行驶。
 *
 * 愤怒的小鸟从A车出发，时速50米/秒，撞向B车，
 *
 * 然后返回去撞A车，再返回去撞B车，如此往复....
 *
 * 两火车在相距1米处停车。
 *
 * 问：这期间愤怒的小鸟撞 B 车多少次？
 *
 * 注意：需要提交的是一个整数（表示撞B车的次数），不要填写任何其它内容。
 *
 * 【思路】
 * v = d / s
 * 鸟飞行的距离 = 总距离 - 火车行走的路程
 * 50 * t = B - 10 * t
 * t = B / 60
 *
 * 【答案】9
 *
 */
public class Main1_愤怒小鸟 {
    // 记录撞击的总次数
    static int count = 0;
    static double B = 1000;

    public static void main(String[] args) {
        f(B);
        // 若为偶数需要/2，若为奇数/2 + 1
        System.out.println(count % 2 == 0 ? count / 2 : count / 2 + 1);
    }

    static void f(double B) {
        count ++;
        double t = B / 60;
        // 总距离减去火车行走的路程
        B -= 20 * t;
        if (B < 1) {
            return;
        }
        f(B);
    }
}
