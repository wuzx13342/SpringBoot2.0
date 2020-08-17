package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory
 * @ClassName: DrinksFactory
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 11:11
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:简单工厂 通过构造方法注入抽象类 向外暴露produceDrink方法来获取产品的实例
 */
public class DrinksFactory {

    public Drinks produceDrink(Class className) {
        try {
            return (Drinks) Class.forName(className.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
