package com.cy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 门店实体类
 * @author 12541
 * @date 2019/8/19 22:18
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Door {
    private Integer id;
    private String name;
    private String tel;
    private String addr;

}      
