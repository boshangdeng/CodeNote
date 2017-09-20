package com.java.concurrent.producerconsumer;

public class WaitNotifyBroker<T> implements Broker<T> {
	private final Object[] items;
	private int takeIndex;
	private int putIndex;
	private int count;

	public WaitNotifyBroker(int capacity) {
		this.items = new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T take() {
		T tmpObj = null;
		try {
			synchronized (items) {
				while (0 == count) {
					items.wait();
				}
				tmpObj = (T) items[takeIndex];
				if (++takeIndex == items.length) {
					takeIndex = 0;
				}
				count--;
				items.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return tmpObj;
	}

	@Override
	public void put(T obj) {
		try {
			synchronized (items) {
				while (items.length == count) {
					items.wait();
				}
				items[putIndex] = obj;
				if (++putIndex == items.length) {
					putIndex = 0;
				}
				count++;
				items.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
