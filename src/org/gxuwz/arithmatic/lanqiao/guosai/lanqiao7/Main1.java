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
 * 【答案】34
 *
 */
public class Main1 {

    public static void main(String[] args) {
        double d = 1000, A = 10, B = 10, b = 60, count = 0;
        // 秒
        double s = 0.00001;

//        for (;;) {
//            System.out.println(s + " " + d);
//            if (d <= 1) {
//                break;
//            }
//            d -= (A + B) * 2;
//            s ++;
//        }

        for (double i = 0; i < 26; i += 0.00001) {
            if (b * s >= d) {
                b += 10;
                count ++;
                s = 0.00001;
            }
            if (d <= 1) {
                break;
            }
            d -= (A + B) * 2 * 0.00001;
            s += 0.00001;
        }
        System.out.println(count);
    }
}
