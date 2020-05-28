package com.wuzx.boot.crud.desgin.mode.proxy;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.proxy
 * @ClassName: ZhaoLiu
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-26 17:27
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ZhaoLiu implements IPerson {
    @Override
    public void findLove() {
        System.out.println("赵六要求：有车有房学历高！");
    }

    public static void main(String[] args) {
        JdkMeipo jdkMeipo =new JdkMeipo();
        IPerson zhangsan = jdkMeipo.getInstance(new ZhangSan());
        zhangsan.findLove();

        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();

    }
}
