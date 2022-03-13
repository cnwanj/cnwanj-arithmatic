package org.gxuwz.arithmatic.designPattern.main2_单例模式.test2;

/**
 * @author: cnwanj
 * @date: 2022-03-12 23:09:45
 * @version: 1.0
 * @desc: 单例模式-枚举
 */

public	enum Singleton {

	INSTANCE;

	public static void main(String[] args) {
		Singleton instance = Singleton.INSTANCE;
		Singleton instance1 = Singleton.INSTANCE;
		System.out.println(instance == instance1);
	}
}

