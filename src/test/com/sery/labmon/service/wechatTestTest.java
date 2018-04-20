package com.sery.labmon.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class wechatTestTest {

    public static void main(String args[]){
        //测试使用quartz是否成功
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }
}