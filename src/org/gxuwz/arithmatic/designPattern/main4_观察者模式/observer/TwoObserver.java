package org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer;

import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Observer;
import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Subject;

/**
 * @author: cnwanj
 * @date: 2022-04-15 23:03:30
 * @version: 1.0
 * @desc: 观察者2
 */
public class TwoObserver extends Observer {

	public TwoObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("TwoObserver：" + Integer.toBinaryString(subject.getState()));
	}
}
