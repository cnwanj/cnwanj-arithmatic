package org.gxuwz.arithmatic.designPattern.main4_观察者模式;

import org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer.OneObserver;
import org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer.ThreeObserver;
import org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer.TwoObserver;

/**
 * @author: cnwanj
 * @date: 2022-04-15 23:03:43
 * @version: 1.0
 * @desc: 观察者模式（行为模式）
 */
public class ObserverTest {

	public static void main(String[] args) {

		Subject subject = new Subject();

		new OneObserver(subject);
		new TwoObserver(subject);
		new ThreeObserver(subject);

		System.out.println("==15==");
		subject.setState(15);
	}
}
