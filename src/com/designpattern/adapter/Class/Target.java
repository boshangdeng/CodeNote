package com.designpattern.adapter.Class;
/**
 * 目标接口
 * @author wangbo
 * Created on 2017年9月23日 下午8:43:20
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    public void sampleOperation1(); 
    /**
     * 这是源类Adapteee没有的方法
     */
    public void sampleOperation2(); 
}
