package org.gxuwz.arithmatic.designPattern.main5_原型模式;

/**
 * @author: cnwanj
 * @date: 2022-04-19 22:41:31
 * @version: 1.0
 * @desc: 形状：三角形
 */
public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	void draw() {
		System.out.println("Rectangle:draw");
	}
}
