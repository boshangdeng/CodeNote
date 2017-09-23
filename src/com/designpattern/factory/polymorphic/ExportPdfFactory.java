package com.designpattern.factory.polymorphic;

public class ExportPdfFactory implements ExportFactory {

    @Override
    public ExportFile factory(String type) {
        if("standard".equals(type)){
            
            return new ExportStandardPdfFile();
            
        }else if("financial".equals(type)){
            
            return new ExportFinancialPdfFile();
            
        }else{
            throw new RuntimeException("û���ҵ�����");
        }
    }

}
