package com.java.concurrent.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueBroker<T> implements Broker<T> {

	private final BlockingQueue<T> queue;

	public BlockingQueueBroker() {
		this.queue = new LinkedBlockingQueue<T>();
	}

	@Override
	public T take() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void put(T obj) {
		try {
			queue.put(obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
