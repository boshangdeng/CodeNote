package com.designpattern.factory.polymorphic;

public class ExportFinancialHtmlFile implements ExportFile {

	@Override
	public boolean export(String data) {
		/**
         * ҵ���߼�
         */
        System.out.println("���������HTML�ļ�");
		return true;
	}

}
