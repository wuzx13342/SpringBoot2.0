package com.wuzx.boot.crud.crud.netty.rpc.comsumer.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class RpcProxyHandler extends ChannelInboundHandlerAdapter {
	  
    private Object response;    
      
    public Object getResponse() {    
	    return response;    
	}    
  
    @Override    
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        response = msg;
    }    
        
    @Override    
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");    
    }    
} 
