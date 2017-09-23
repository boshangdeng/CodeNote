package com.designpattern.factory.abstracts;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {
		return new IntelCpu(938);
	}

	@Override
	public MainBoard createMainBoard() {
		return new IntelMainBoard(938);
	}

}
