package com.java.concurrent.producerconsumer;

public class Producer implements Runnable {
	private final Broker<Integer> broker;
	private final String name;

	public Producer(Broker<Integer> broker, String name) {
		this.broker = broker;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				broker.put(i);
				System.out.format("%s produced: %s%n", name, i);
				Thread.sleep(1000);
			}
			broker.put(-1);
			System.out.println("produced termination signal");
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
	}

}
