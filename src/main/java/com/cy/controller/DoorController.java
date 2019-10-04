package com.cy.controller;

import java.util.List;

import com.cy.dao.DoorMapper;
import com.cy.pojo.Door;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller  作用1： 将当前对象的创建交给spring管理
 *              作用2：作为控制层代码的标识
 * @author 12541
 * @date 2019/8/19 23:19
 */
@Controller
public class DoorController {
    @Autowired    //自动注入(由spring创建当前对象并为属性赋值)
    private DoorMapper doorMapper;


    /**
     * 查询所有的门店信息
     * @param model
     * @return
     */
    @RequestMapping("/doorList")
    public String doorList(Model model){
        //调用service层的findAll方法，查询所有的门店信息
        List<Door> list = doorMapper.findAll();

        //将所有门店信息的list集合存入model中，带到JSP显示
        model.addAttribute("list", list);

        return "door_list";
    }
    /**
     * 2.新增门店信息
     */
    @RequestMapping("/doorAdd")
    public String doorAdd(Door door){
        //1.调用service层的addDoor方法，新增门店信息
        doorMapper.addDoor(door);
        //2.重定向到门店列表页面, 显示所有门店信息
        return "redirect:/doorList";
    }

    /**
     * 删除指定id的门店信息
     * @param id
     * @return
     */
    @RequestMapping("/doorDelete")
    public String doorDelete(Integer id){
        //1.调用service层的deleteById方法，删除指定id的门店信息
        doorMapper.deleteById(id);
        //2.重定向到门店列表页面, 显示所有门店信息
        return "redirect:/doorList";
    }

    /**
     * 4.根据id查询门店信息
     */
    @RequestMapping("/doorInfo")
    public String doorInfo(Integer id, Model model){
        //1.调用service层的findById方法，根据id查询门店信息
        Door door = doorMapper.findById(id);
        //2.将门店信息保存到Model中
        model.addAttribute("door", door);
        //3.将门店信息带到door_update.jsp进行回显
        return "door_update";
    }

    /** 5.根据id更新门店信息 */
    @RequestMapping("/doorUpdate")
    public String doorUpdate(Door door){
        //1.调用service层的updateById方法，根据id跟新门店信息
        doorMapper.updateById(door);
        //2.重定向到门店列表页面, 显示所有门店信息
        return "redirect:/doorList";
    }

}
