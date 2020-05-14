package com.wuzx.boot.crud.entity;

import lombok.Data;

/**
 * Customer 实体类 {@link Customer}
 *
 * @author wuzx
 * @wx: 36567126
 */
@Data
public class Customer {

    private Integer id;
    private String cname;
    private Integer age;
    private String gender;

}
