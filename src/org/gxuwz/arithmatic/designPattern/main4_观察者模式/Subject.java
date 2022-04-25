package org.gxuwz.arithmatic.designPattern.main4_观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cnwanj
 * @date: 2022-04-15 23:02:25
 * @version: 1.0
 * @desc: 主题类
 */
public class Subject  {

	private List<Observer> observerList = new ArrayList<>();

	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObserverList();
	}

	public void attach(Observer observer) {
		observerList.add(observer);
	}

	private void notifyAllObserverList() {
		for (Observer observer : observerList) {
			observer.update();
		}
	}
}
