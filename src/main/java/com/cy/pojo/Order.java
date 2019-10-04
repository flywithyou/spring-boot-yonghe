package com.cy.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 12541
 * @date 2019/8/20 22:42
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private Integer doorId;
    private String orderNo;
    private String orderType;
    private Integer pnum;
    private String cashier;
    private Date orderTime;
    private Date payTime;
    private String payType;
    private Double price;
}
