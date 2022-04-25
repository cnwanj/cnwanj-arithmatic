package org.gxuwz.arithmatic.designPattern.main4_观察者模式.observer;

import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Observer;
import org.gxuwz.arithmatic.designPattern.main4_观察者模式.Subject;

/**
 * @author: cnwanj
 * @date: 2022-04-15 23:03:10
 * @version: 1.0
 * @desc: 观察者1
 */
public class OneObserver extends Observer {

	public OneObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("OneObserver：" + Integer.toBinaryString(subject.getState()));
	}
}
