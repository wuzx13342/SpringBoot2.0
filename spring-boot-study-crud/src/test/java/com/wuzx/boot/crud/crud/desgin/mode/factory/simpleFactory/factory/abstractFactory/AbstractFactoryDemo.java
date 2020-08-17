package com.wuzx.boot.crud.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.factory.simpleFactory.factory.abstractFactory
 * @ClassName: AbstractFactoryDemo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-29 14:43
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {

        AppleFactory appleFactory = new AppleFactory();
        appleFactory.producePhone().call();
        appleFactory.produceComputer().work();

        HuaweiFactory huaweiFactory =new HuaweiFactory();
        huaweiFactory.producePhone().call();
        huaweiFactory.produceComputer().work();

        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = LocalDate.of(2019, 9, 10);

        int year = localDate.getYear();
        int year1 =localDate.get(ChronoField.YEAR);

        System.out.println(year);

        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String s3 = localDate.format(dateTimeFormatter);

        System.out.println(s3);



    }

}
