package com.wuzx.boot.crud.crud.netty.rpc.provider;

import com.wuzx.boot.crud.netty.rpc.api.IRpcService;

/**
 * @PackgeName: com.wuzx.boot.crud.netty.rpc.provider
 * @ClassName: RpcServiceImpl
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-20 11:32
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class RpcServiceImpl implements IRpcService {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

}