package org.gxuwz.arithmatic.lanqiao.guosai.lanqiao10;

/**
 * @Author: 韦永恒
 * @Date: 2020-10-28 13:58:13
 * @Description:
 *
 * 在一个5*5的方格上走边界点，其实也就是6*6的图，从左上角开始走，不走重复点且在12步之内走回左上角点，问方案数
 * 直接dfs,需要减掉 (0,0)->(1,0)->(0,0)和(0,0)->(0,1)->(0,0)，这两个路线都重合了
 * 结果: 208-2=206
 *
 */
public class Main5 {
}
