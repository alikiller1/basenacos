package com.xiaowei.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaowei.service1.api.ConsumerService;

/**
 * Created with IntelliJ IDEA.
 * User：modderBUG
 * Date：2020/3/2215:02
 * Version:1.0
 * Desc:
 */
@RestController
@RequestMapping("/service")
public class ApplicationController {

    @org.apache.dubbo.config.annotation.Reference
    private ConsumerService consumerService;
    
    @Autowired
    private ConfigurableApplicationContext ct;

    @GetMapping
    String service(){
        String target=consumerService.service();
        return "application-1|test|"+target;
    }
    
    @GetMapping("getConfig")
    public String getConfig() {
    	String name=ct.getEnvironment().getProperty("common.name");
    	return "common.name="+name;
    }
}
