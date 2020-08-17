package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory
 * @ClassName: Drinks
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 11:07
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 抽象产品饮料类 并且有抽象方法produce
 *
 * 简单工厂的优点：
 * 1.不需要关心类的创建细节。
 * 2.减轻类之间的耦合依赖，具体类的实现只是依赖于简单工厂，而不依赖其他类。
 *
 * 简单工厂的缺点：
 * 1.扩展复杂，当简单工厂需要生产出另外一种产品的时候，需要扩展工厂的内部创建逻辑，比较有可能引起较大的故障
 * 2.由于工厂类集中了所有实例的创建逻辑，违反了高内聚责任分配原则，将全部创建逻辑集中到了一个工厂类中
 */
public abstract class Drinks {

    protected abstract void produce();
}
