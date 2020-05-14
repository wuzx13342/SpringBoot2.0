package com.wuzx.boot.crud.service.impl;

import com.wuzx.boot.crud.entity.Customer;
import com.wuzx.boot.crud.mapper.CustomerMapper;
import com.wuzx.boot.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Customer 业务接口实现类 {@link CustomerServiceImpl}
 *
 * @author wuzx
 * @wx: 36567126
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    // 属性注入，有警告，不推荐使用
//    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 构造注入
     *  - 强依赖的情况使用
     * @param customerMapper
     */
    @Autowired
    public CustomerServiceImpl (CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * 添加 Customer
     * @param customer
     */
    @Override
    public void saveCustomer(Customer customer) {
        customerMapper.save(customer);
    }

    /**
     * 修改 Customer
     * @param customer
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.update(customer);
    }

    /**
     * 删除 Customer
     * @param id
     */
    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.delete(id);
    }

    /**
     * 查询 Customer
     * @param id
     * @return
     */
    @Override
    public Customer queryCustomer(Integer id) {
        return customerMapper.query(id);
    }

    /**
     * 查询 Customer 列表
     * @return
     */
    @Override
    public List<Customer> queryCustomers() {
        return customerMapper.queryForList();
    }
}
