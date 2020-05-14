package com.wuzx.boot.crud.mapper;

import com.wuzx.boot.crud.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Customer 数据访问接口 {@link CustomerMapper}
 *  - 不建议将 SQL 写入到 mapper 接口中
 *  - 建议使用 xml 方式来进行 sql 的编写
 *
 * @author wuzx
 * @wx: 36567126
 */
@Repository
public interface CustomerMapper {
    /**
     * 保存 Customer
     * @param customer
     */
    public void save (Customer customer);

    /**
     * 更新 Customer
     * @param customer
     */
    public void update (Customer customer);

    /**
     * 删除 Customer
     * @param id
     */
    public void delete (Integer id);

    /**
     * 查询 Customer
     * @param id
     * @return
     */
    public Customer query (Integer id);

    /**
     * 查询 Customer 列表
     * @return
     */
    public List<Customer> queryForList ();
}
