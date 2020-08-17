package com.wuzx.boot.crud.crud.netty.rpc.provider;

import com.wuzx.boot.crud.netty.rpc.api.IRpcHelloService;

/**
 * @PackgeName: com.wuzx.boot.crud.netty.rpc.provider
 * @ClassName: RpcHelloServiceImpl
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-20 11:31
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class RpcHelloServiceImpl implements IRpcHelloService {

    public String hello(String name) {
        return "Hello " + name + "!";
    }

}

