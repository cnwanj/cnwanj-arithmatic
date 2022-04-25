package org.gxuwz.arithmatic.designPattern.main4_观察者模式;

/**
 * @author: cnwanj
 * @date: 2022-04-15 23:02:36
 * @version: 1.0
 * @desc: 观察者抽象类
 */
public abstract class Observer {

	protected Subject subject;

	public abstract void update();
}
