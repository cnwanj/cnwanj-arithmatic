package org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer;

import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Observer;
import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Subject;

/**
 * @author: cnwanj
 * @date: 2022-04-18 21:44:51
 * @version: 1.0
 * @desc: 观察者3
 */
public class ThreeObserver extends Observer {

	public ThreeObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("ThreeObserver：" + Integer.toBinaryString(subject.getState()));
	}
}
