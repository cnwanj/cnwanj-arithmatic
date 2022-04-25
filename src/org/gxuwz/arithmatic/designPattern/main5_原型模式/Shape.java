package org.gxuwz.arithmatic.designPattern.main5_原型模式;

/**
 * @author: cnwanj
 * @date: 2022-04-19 22:30:18
 * @version: 1.0
 * @desc: 原型模式（创建者模式）
 */
public abstract class Shape implements Cloneable {

	private Integer id;

	protected String type;

	abstract void draw();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
