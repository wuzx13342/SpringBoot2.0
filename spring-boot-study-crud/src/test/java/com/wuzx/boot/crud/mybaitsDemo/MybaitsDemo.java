package com.wuzx.boot.crud.mybaitsDemo;

import com.wuzx.boot.crud.entity.Customer;
import com.wuzx.boot.crud.mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @PackgeName: com.wuzx.boot.crud.mybaitsDemo
 * @ClassName: MybaitsDemo
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-18 15:55
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class MybaitsDemo {

    public static void main(String[] args) throws IOException {

        String resource = "classpath:/application.yml";
        InputStream inputStream =Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.query(1);
        System.out.println(customer);
        session.close();
    }
}
