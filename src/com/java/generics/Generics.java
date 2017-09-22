package com.java.generics;

import java.util.ArrayList;

public class Generics {
	public static void main(String[] args) {
		//java泛型使用擦除实现的，List<Integer>和List<String>使用时会被擦除成List
		Class a=new ArrayList<String>().getClass();
		Class b=new ArrayList<Integer>().getClass();
		System.out.println(a==b);
	}
}