package com.java.generics;

public class Product<T> {
	public <F extends Factory<T>> Product(F factory) {
		factory.create();
	}

}
