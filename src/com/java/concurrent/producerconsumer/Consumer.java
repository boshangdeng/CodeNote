package com.java.concurrent.producerconsumer;

public class Consumer implements Runnable {

	private final Broker<Integer> broker;
	private final String name;

	public Consumer(Broker<Integer> broker, String name) {
		this.broker = broker;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			for (Integer message = broker.take(); message != -1; message = broker.take()) {
				System.out.format("%s consumed: %s%n", name, message);
				Thread.sleep(1000);
			}
			System.out.println("received termination signal");
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
	}

}
