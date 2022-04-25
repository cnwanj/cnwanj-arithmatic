package org.gxuwz.arithmatic.designPattern.main5_原型模式;

import java.util.Hashtable;

/**
 * @author: cnwanj
 * @date: 2022-04-19 22:43:12
 * @version: 1.0
 * @desc: 模拟从数据库获取实体类
 */
public class ShapeCache {

	private static Hashtable<Integer, Shape> shapeMap = new Hashtable<>();

	/**
	 * 获取克隆
	 * @param id
	 * @return
	 */
	public static Shape getShape(Integer id) {
		Shape shape = shapeMap.get(id);
		return (Shape) shape.clone();
	}

	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId(1);
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId(2);
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId(3);
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
