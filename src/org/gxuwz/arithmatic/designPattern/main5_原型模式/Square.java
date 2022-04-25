package org.gxuwz.arithmatic.designPattern.main5_原型模式;

/**
 * @author: cnwanj
 * @date: 2022-04-19 22:41:41
 * @version: 1.0
 * @desc: 形状：四边形
 */
public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	void draw() {
		System.out.println("Square:draw");
	}
}
