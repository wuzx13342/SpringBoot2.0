package com.wuzx.boot.crud.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @PackgeName: com.wuzx.boot.crud.netty.rpc.protocol
 * @ClassName: InvokerProtocol
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-20 11:29
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 自定义传输协议
 */
/**
 * 自定义传输协议
 */
@Data
public class InvokerProtocol implements Serializable {

    private String className;//类名
    private String methodName;//函数名称
    private Class<?>[] parames;//形参列表
    private Object[] values;//实参列表

}