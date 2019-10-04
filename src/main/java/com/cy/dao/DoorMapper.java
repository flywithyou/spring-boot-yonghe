package com.cy.dao;

import java.util.List;

import com.cy.pojo.Door;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 12541
 * @date 2019/8/19 22:24
 */
@Mapper
public interface DoorMapper {
    /**
     * 1.查询所有门店信息
     */
    public List<Door> findAll();

    /**
     * 2.新增门店信息
     * @param door
     */
    public void addDoor(Door door);

    /**
     * 3.根据id删除指定的门店信息
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 4.1.根据id查询门店信息
     * @param id
     */
    public Door findById(Integer id);

    /**
     * 4.2.根据id更新门店信息
     * @param door
     */
    public void updateById(Door door);

}
