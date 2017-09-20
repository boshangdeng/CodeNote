package com.java.concurrent.producerconsumer;

public class Main {

	public static void main(String[] args) {
		Broker<Integer> broker = new WaitNotifyBroker<Integer>(5);
		// Broker<Integer> broker = new LockConditionBroker<Integer>(5);
		// Broker<Integer> broker = new BlockingQueueBroker<Integer>();

		new Thread(new Producer(broker, "prod 1")).start();
		new Thread(new Consumer(broker, "cons 1")).start();
		new Thread(new Consumer(broker, "cons 2")).start();
		
	}

}
