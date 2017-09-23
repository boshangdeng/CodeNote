package com.designpattern.factory.polymorphic;

public interface ExportFactory {
	ExportFile factory(String type);
}
