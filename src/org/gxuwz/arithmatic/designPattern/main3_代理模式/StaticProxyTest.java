package org.gxuwz.arithmatic.designPattern.main3_代理模式;

/**
 * @author: cnwanj
 * @date: 2022-03-05 13:23:14
 * @version: 1.0
 * @desc: 静态代理，只能代理固定的对象
 */
interface ClothFactory {

	void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

	private ClothFactory clothFactory;

	public ProxyClothFactory(ClothFactory clothFactory) {
		this.clothFactory = clothFactory;
	}

	@Override
	public void produceCloth() {
		System.out.println("生产前...");
		clothFactory.produceCloth();
		System.out.println("生产后...");
	}
}

class AntaClothFactory implements ClothFactory {

	@Override
	public void produceCloth() {
		System.out.println("生产安踏...");
	}
}

public class StaticProxyTest {
	public static void main(String[] args) {
		// 通过代理工厂去生产安踏
		ClothFactory clothFactory = new ProxyClothFactory(new AntaClothFactory());
		clothFactory.produceCloth();
	}
}
