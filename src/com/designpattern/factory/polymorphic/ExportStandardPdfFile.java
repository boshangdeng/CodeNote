package com.designpattern.factory.polymorphic;

public class ExportStandardPdfFile implements ExportFile {

	@Override
	public boolean export(String data) {
		/**
		 * ҵ���߼�
		 */
		System.out.println("������׼PDF�ļ�");
		return true;
	}

}
