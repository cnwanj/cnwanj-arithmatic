package org.gxuwz.arithmatic.designPattern.main5_原型模式;

/**
 * @author: cnwanj
 * @date: 2022-04-19 22:41:49
 * @version: 1.0
 * @desc: 形状：圆形
 */
public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	@Override
	void draw() {
		System.out.println("Circle:draw");
	}
}
