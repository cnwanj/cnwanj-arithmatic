package org.gxuwz.arithmatic.designPattern.main5_原型模式;

/**
 * @author: cnwanj
 * @date: 2022-04-19 23:01:08
 * @version: 1.0
 * @desc: 原型模式（创建型模式）
 */
public class PrototypeTest {
	public static void main(String[] args) {
		ShapeCache.loadCache();

		System.out.println(ShapeCache.getShape(1).getType());
		System.out.println(ShapeCache.getShape(2).getType());
		System.out.println(ShapeCache.getShape(3).getType());
	}
}
