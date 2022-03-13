package org.gxuwz.arithmatic.designPattern.main2_单例模式.test1;

/**
 * @author: cnwanj
 * @date: 2022-03-12 23:06:55
 * @version: 1.0
 * @desc: 单例模式-静态内部类
 */
public class Singleton {
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
}
