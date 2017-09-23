package com.designpattern.factory.abstracts;
/**
 * 抽象工厂模式与工厂方法模式的最大区别就在于，工厂方法模式针对的是一个产品等级结构；而抽象工厂模式则需要面对多个产品等级结构。
 * @author wangbo
 * Created on 2017年9月23日 下午8:02:07
 */
public interface AbstractFactory {
	/**
	 * 创建CPU对象
	 * 
	 * @return CPU对象
	 */
	public Cpu createCpu();

	/**
	 * 创建主板对象
	 * 
	 * @return 主板对象
	 */
	public MainBoard createMainBoard();
}