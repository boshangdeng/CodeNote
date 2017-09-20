package com.java.concurrent.producerconsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionBroker<T> implements Broker<T> {
	private final ReentrantLock lock;
	private final Condition notFull;
	private final Condition notEmpty;
	private final int capacity;
	private LinkedList<T> items;

	public LockConditionBroker(int capacity) {
		this.lock = new ReentrantLock();
		this.notFull = lock.newCondition();
		this.notEmpty = lock.newCondition();
		this.capacity = capacity;
		items = new LinkedList<T>();
	}

	@Override
	public T take() {
		T tmpObj = null;
		lock.lock();
		try {
			while (items.size() == 0) {
				notEmpty.await();
			}

			tmpObj = items.poll();
			notFull.signalAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return tmpObj;
	}

	@Override
	public void put(T obj) {
		lock.lock();
		try {
			while (items.size() == capacity) {
				notFull.await();
			}
			items.offer(obj);
			notEmpty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
