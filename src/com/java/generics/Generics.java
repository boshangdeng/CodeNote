package com.java.generics;

import java.util.ArrayList;

public class Generics {
	public static void main(String[] args) {
		//java����ʹ�ò���ʵ�ֵģ�List<Integer>��List<String>ʹ��ʱ�ᱻ������List
		Class a=new ArrayList<String>().getClass();
		Class b=new ArrayList<Integer>().getClass();
		System.out.println(a==b);
	}
}