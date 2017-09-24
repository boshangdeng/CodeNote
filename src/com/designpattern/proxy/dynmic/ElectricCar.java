package com.designpattern.proxy.dynmic;

/**
 * 电能车类，实现Rechargable，Vehicle接口
 * 
 * @author wangbo
 *
 */
public class ElectricCar implements Vehicle, Rechargable {

	@Override
	public void recharge() {
		System.out.println("Electric Car is Recharging...");
	}

	@Override
	public void drive() {
		System.out.println("Electric Car is Moving silently...");
	}

}
