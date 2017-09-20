package com.java.concurrent.producerconsumer;

public interface Broker<T> {

	T take();

	void put(T obj);
}
