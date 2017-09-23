package com.designpattern.decorate;

public class Client {
	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		// ��һ��д��
		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(bird);
		// �ڶ���д��
		// TheGreatestSage fish = new Fish(new Bird(sage));
		fish.move();
	}
}
