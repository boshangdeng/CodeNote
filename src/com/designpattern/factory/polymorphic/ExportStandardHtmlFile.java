package com.designpattern.factory.polymorphic;

public class ExportStandardHtmlFile implements ExportFile {

	@Override
	public boolean export(String data) {
		/**
		 * ҵ���߼�
		 */
		System.out.println("������׼HTML�ļ�");
		return true;
	}

}
