package com.wuzx.boot.crud.entity;

import lombok.Data;

/**
 * Customer 实体类 {@link Customer}
 *
 * @author wuzx
 * @email wuzhixiang.ithz@gmail.com
 */
@Data
public class Customer {

    private Integer id;
    private String cname;
    private Integer age;
    private String gender;

}
