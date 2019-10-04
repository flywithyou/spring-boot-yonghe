package com.cy.controller;

import java.util.List;

import com.cy.dao.DoorMapper;
import com.cy.pojo.Door;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试类：测试springmvc、ssm开发环境
 * @author 12541
 * @date 2019/8/19 22:08
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "test";
    }

    /** 自动装配：由spring自动为属性赋值(对象)  */
    @Autowired
    DoorMapper mapper;

    @RequestMapping("/testssm")
    public String testSSM(){
        //1.调用findAll方法查询所有门店信息
        List<Door> list = mapper.findAll();
        //2.遍历所有门店信息
        for(Door door : list){
            System.out.println(door);
        }
        return "test";
    }

}

