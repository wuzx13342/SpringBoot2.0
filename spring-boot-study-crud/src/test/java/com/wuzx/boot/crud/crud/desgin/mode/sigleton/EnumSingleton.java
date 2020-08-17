package com.wuzx.boot.crud.crud.desgin.mode.sigleton;

import lombok.Data;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.sigleton
 * @ClassName: EnumSingleton
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 11:24
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 枚举实现单例
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
