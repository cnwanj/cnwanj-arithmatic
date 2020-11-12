package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao5;

/**
 * @Author: vovhh
 * @Date: 2020-11-12 10:48:10
 * @Description:
 *
 * 标题：国王的遗产
 *
 * X国是个小国。国王K有6个儿子。在临终前，K国王立下遗嘱：国王的一批牛作为遗产要分给他的6个儿子。
 * 其中，大儿子分1/4，二儿子1/5，三儿子1/6，....
 * 直到小儿子分1/9。
 * 牛是活的，不能把一头牛切开分。
 *
 * 最后还剩下11头牛，分给管家。
 *
 * 请计算国王这批遗产中一共有多少头牛。
 *
 * 这是一个整数，请通过浏览器提交答案，不要填写任何多余的内容（比如说明性的文字）
 *
 */
public class Main1_国王的遗产 {

    public static void main(String[] args) {
        int n = 9;
        while (true) {
            if (n % 8 == 0 && n % 7 == 0 && n % 6 == 0 && n % 5 == 0) {
                break;
            }
            n += 9;
        }
        System.out.println(n);
        // 2520
        // System.out.println(n / 9 + n / 8 + n / 7 + n / 6 + n / 5 + n / 4);

    }
}
