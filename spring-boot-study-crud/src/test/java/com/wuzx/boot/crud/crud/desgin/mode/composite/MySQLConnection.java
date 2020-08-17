package com.wuzx.boot.crud.crud.desgin.mode.composite;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.composite
 * @ClassName: MySQLConnection
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 17:48
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
