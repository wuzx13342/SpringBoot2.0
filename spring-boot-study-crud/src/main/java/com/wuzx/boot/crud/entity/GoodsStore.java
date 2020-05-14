package com.wuzx.boot.crud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 库存实体类
 * @author joelwu_1109
 */
@Data
public class GoodsStore implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private int store;

}
