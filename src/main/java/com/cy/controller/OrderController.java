package com.cy.controller;

import java.util.List;

import com.cy.dao.DoorMapper;
import com.cy.dao.OrderMapper;
import com.cy.pojo.Door;
import com.cy.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单信息管理
 * @author 12541
 * @date 2019/8/20 22:41
 */
@Controller
public class OrderController {
    @Autowired
    private DoorMapper doorMapper;
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 1.查询所有订单
     * @param model
     * @return
     */
    @RequestMapping("/orderList")
    public String orderList(Model model){
        //查询所有订单
        List<Order> orderList = orderMapper.findAll();
        model.addAttribute("orderList",orderList);
        List<Door> doorList = doorMapper.findAll();
        model.addAttribute("doorList",doorList);
        return "order_list";
    }

    /**
     * 2.1.新增订单
     * @return
     */
    @RequestMapping("/findAllDoorToOrder_add")
    public String findAllDoorToOrder_add(Model model){
        //查询所有门店集合
        List<Door> doorList = doorMapper.findAll();
        //将门店集合存入model中
        model.addAttribute("doorList",doorList);
        return "order_add";
    }

    /**
     * 2.2新增订单
     * @return
     */
    @RequestMapping("/orderAdd")
    public String orderAdd(Order order){
        //添加订单到数据库
        orderMapper.addOrder(order);
        return "forward:orderList";
    }

    /**
     * 3.根据ID删除订单
     * @param id
     * @return
     */
    @RequestMapping("/orderDelete")
    public String orderDeleteById(Integer id){
        orderMapper.orderDeleteById(id);
        return "forward:orderList";
    }

    /**
     * 4.1.根据ID查询订单信息
     * @param id
     * @return
     */
    @RequestMapping("/orderInfo")
    public String orderInfo(Integer id ,Model model){
       Order order =  orderMapper.findById(id);
       model.addAttribute("order",order);
        List<Door> doorList = doorMapper.findAll();
        model.addAttribute("doorList",doorList);
        return "order_update";
    }

    /**
     * 4.2根据id更新订单信息
     * @param order
     * @return
     */
    @RequestMapping("/orderUpdate")
    public String orderUpdateById(Order order){
        orderMapper.updateById(order);
        return "forward:orderList";
    }
}
