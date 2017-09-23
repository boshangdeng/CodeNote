package com.designpattern.factory.simple;

public class DomainLogin implements Login {

	@Override
	public boolean verify(String name, String password) {
		/**
		 * 具体业务逻辑
		 */
		return true;
	}

}
