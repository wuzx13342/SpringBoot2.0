package com.wuzx.boot.crud.desgin.mode.composite;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.composite
 * @ClassName: OracleConnection
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 17:49
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Oracle数据库连接";
    }
}
