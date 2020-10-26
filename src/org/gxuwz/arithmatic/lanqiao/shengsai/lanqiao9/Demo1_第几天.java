package org.gxuwz.arithmatic.lanqiao.shengsai.lanqiao9;

import java.util.Calendar;

/**
 * @description:
 *
 * 标题：第几天
 *
 * 2000年的1月1日，是那一年的第1天。
 * 那么，2000年的5月4日，是那一年的第几天？
 *
 * 注意：需要提交的是一个整数，不要填写任何多余内容。
 *
 * 【答案】：125
 *
 * @author: 韦永恒
 * @date: 2020-10-14 17:11:19
 */
public class Demo1_第几天 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2020, 0, 1);
        for (int i = 1; i <= 170; i++) {
            c.add(Calendar.DAY_OF_YEAR, 1);
            if (c.get(Calendar.MONTH) == 4 && c.get(Calendar.DATE) == 4) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
