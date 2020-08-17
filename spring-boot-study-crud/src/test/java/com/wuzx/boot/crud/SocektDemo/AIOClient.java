package com.wuzx.boot.crud.SocektDemo;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel; import java.nio.channels.CompletionHandler;
/**
 * @PackgeName: com.wuzx.boot.crud.SocektDemo
 * @ClassName: AIOClient
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-20 10:55
 * project name: spring-boot-study-crud
 * @Version:
 * @Description:AIO客户端
 */
public class AIOClient {

    private final AsynchronousSocketChannel client;

    public AIOClient() throws Exception {
        client = AsynchronousSocketChannel.open();
    }

    public void connect(String host, int port){

        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                try {
                    client.write(ByteBuffer.wrap("这是一条测试数据".getBytes())).get();
                    System.out.println("已发送至服务器");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        final ByteBuffer bb = ByteBuffer.allocate(1024);
        client.read(bb, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result, Object attachment) {
                        System.out.println("IO 操作完成" + result);
                        System.out.println("获取反馈结果" + new String(bb.array()));
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        exc.printStackTrace();
                    }
                }
        );
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String args[]) throws Exception {
        String host ="localhost";
        new AIOClient().connect(host, 8000);
    }
}