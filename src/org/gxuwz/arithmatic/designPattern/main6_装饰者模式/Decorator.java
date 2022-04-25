package org.gxuwz.arithmatic.designPattern.main6_装饰者模式;

/**
 * @author: cnwanj
 * @date: 2022-04-20 21:32:39
 * @version: 1.0
 * @desc: 装饰者模式（结构型模式）
 */
public class Decorator {

	/**
	 * 动物接口
	 */
	interface Animal {
		void eat();
	}

	/**
	 * 猪类
	 */
	static class Pig implements Animal {

		@Override
		public void eat() {
			System.out.println("Pig: eat");
		}
	}

	/**
	 * 鸭类
	 */
	static class Duck implements Animal {

		@Override
		public void eat() {
			System.out.println("Duck: eat");
		}
	}

	/**
	 * 动物装饰器类实现动物接口
	 */
	static abstract class AnimalDecorator implements Animal {
		// 动物实现接口
		protected Animal animal;
		// 用于实例化，触发实现该接口的类
		public AnimalDecorator(Animal animal) {
			this.animal = animal;
		}
	}

	/**
	 * 继承装饰器类，用于扩展功能
	 */
	static class OtherAnimalDecorator extends AnimalDecorator {

		// 实例化的时候传入对应的动物，用于调用对应的方法
		public OtherAnimalDecorator(Animal animal) {
			super(animal);
		}

		// 给传入的动物赋予其他功能
		@Override
		public void eat() {
			animal.eat();
			fly();
			run();
		}

		public void fly() {
			System.out.println("Animal: fly");
		}

		public void run() {
			System.out.println("Animal: run");
		}
	}

	static class AllDecorator extends Pig {
		Animal animal;
		public AllDecorator(Animal animal) {
			this.animal = animal;
		}
		void all() {
			animal.eat();
			fly();
			run();
		}
		void fly() {
			System.out.println("Animal: fly");
		}
		void run() {
			System.out.println("Animal: run");
		}
	}

	/**
	 * 使用OtherAnimalDecorator装饰AnimalDecorator类
	 */
	static class DecoratorTest {

		public static void main(String[] args) {
			Animal pig = new Pig();
			Animal duck = new Duck();

			AnimalDecorator otherPig = new OtherAnimalDecorator(pig);
			AnimalDecorator otherDuck = new OtherAnimalDecorator(duck);

			System.out.println("===========pig==========");
			pig.eat();
			System.out.println("===========duck==========");
			duck.eat();
			System.out.println("===========otherPig==========");
			otherPig.eat();
			System.out.println("===========otherDuck==========");
			otherDuck.eat();
		}
	}
}
