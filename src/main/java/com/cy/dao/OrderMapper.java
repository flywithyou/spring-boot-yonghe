package com.cy.dao;

import java.util.List;

import com.cy.pojo.Order;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 12541
 * @date 2019/8/20 22:41
 */
@Mapper
public interface OrderMapper {
    /**
     * 1.查询所有门店信息
     */
    public List<Order> findAll();

    /**
     * 2.新增门店信息
     * @param order
     */
    public void addOrder(Order order);

    /**
     * 3.根据id删除指定的门店信息
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 4.1.根据id查询门店信息
     * @param id
     */
    public Order findById(Integer id);

    /**
     * 4.2.根据id更新门店信息
     * @param order
     */
    public void updateById(Order order);

    void orderDeleteById(Integer id);
}
