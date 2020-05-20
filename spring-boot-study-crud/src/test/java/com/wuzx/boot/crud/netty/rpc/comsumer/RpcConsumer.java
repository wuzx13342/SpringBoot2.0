package com.wuzx.boot.crud.netty.rpc.comsumer;

import com.wuzx.boot.crud.netty.rpc.api.IRpcHelloService;
import com.wuzx.boot.crud.netty.rpc.api.IRpcService;
import com.wuzx.boot.crud.netty.rpc.comsumer.proxy.RpcProxy;

public class RpcConsumer {
	
    public static void main(String [] args){  
        IRpcHelloService rpcHello = RpcProxy.create(IRpcHelloService.class);
        
        System.out.println(rpcHello.hello("Tom老师"));

        IRpcService service = RpcProxy.create(IRpcService.class);
        
        System.out.println("8 + 2 = " + service.add(8, 2));
        System.out.println("8 - 2 = " + service.sub(8, 2));
        System.out.println("8 * 2 = " + service.mult(8, 2));
        System.out.println("8 / 2 = " + service.div(8, 2));
    }
    
}
