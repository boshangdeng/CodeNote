package com.designpattern.factory.abstracts;

public class IntelCpu implements Cpu {
	/**
	 * CPU�������
	 */
	private int pins = 0;

	public IntelCpu(int pins) {
		this.pins = pins;
	}

	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Intel CPU���������" + pins);
	}

}
