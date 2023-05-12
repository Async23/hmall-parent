package com.itheima.service;

import com.itheima.pojo.Order;

public interface OrderService {

    /**
     * 根据订单 id 查询订单
     *
     * @param id
     * @return
     */
    Order queryById(Long id);
}
