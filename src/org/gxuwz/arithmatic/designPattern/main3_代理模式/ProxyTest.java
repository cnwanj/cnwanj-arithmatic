package org.gxuwz.arithmatic.designPattern.main3_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: cnwanj
 * @date: 2022-03-05 15:54:57
 * @version: 1.0
 * @desc: 动态代理
 */
interface Human {

	String study();

	void eat(String food);

}

class SuperMan implements Human {

	@Override
	public String study() {
		return "我要学习变强";
	}

	@Override
	public void eat(String food) {
		System.out.println("我今天吃" + food);
	}
}

class ProxyFactory {

	// 获取动态代理实例对象
	public static Object getProxyInstance(Object object) {
		// 类加载器、类接口、代理放大类对象
		return Proxy.newProxyInstance(
			object.getClass().getClassLoader(),
			object.getClass().getInterfaces(),
			new MyInvocation(object));
	}
}

// 自定义代理调度器，用于获取被代理对象的方法
class MyInvocation implements InvocationHandler {

	private Object object;

	public MyInvocation(Object object) {
		this.object = object;
	}

	// 通过代理对象掉用方法时，就会自动调用invoke()方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("执行方法前调用...");
		Object invoke = method.invoke(object, args);
		System.out.println("执行方法后调用...");
		return invoke;
	}
}

public class ProxyTest {

	public static void main(String[] args) {
		// 获取superman的代理对象
		Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMan());
		System.out.println(proxyInstance.study());
		proxyInstance.eat("饺子");
		System.out.println("----------------------------");
		// 代理衣服工厂
		ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(new AntaClothFactory());
		clothFactory.produceCloth();
	}
}
