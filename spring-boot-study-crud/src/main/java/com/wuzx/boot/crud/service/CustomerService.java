package com.wuzx.boot.crud.service;

import com.wuzx.boot.crud.entity.Customer;

import java.util.List;

/**
 * Customer 业务接口 {@link CustomerService}
 *
 * @author wuzx
 * @email wuzhixiang.ithz@gmail.com
 */
public interface CustomerService {
    /**
     * 保存 Customer
     * @param customer
     */
    public void saveCustomer (Customer customer);

    /**
     * 更新 Customer
     * @param customer
     */
    public void updateCustomer (Customer customer);

    /**
     * 删除 Customer
     * @param id
     */
    public void deleteCustomer (Integer id);

    /**
     * 查询 Customer
     * @param id
     * @return
     */
    public Customer queryCustomer (Integer id);

    /**
     * 查询 Customer 列表
     * @return
     */
    public List<Customer> queryCustomers ();
}
