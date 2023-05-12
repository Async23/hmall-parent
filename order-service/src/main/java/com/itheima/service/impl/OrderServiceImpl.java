package com.itheima.service.impl;

import com.itheima.client.UserClient;
import com.itheima.mapper.OrderMapper;
import com.itheima.pojo.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    /**
     * 根据订单 id 查询订单
     *
     * @param id
     * @return
     */
    @Override
    public Order queryById(Long id) {
        Order order = orderMapper.queryById(id);
        // TODO: 2023/5/12 使用 feign 调用 userservice
        order.setUser(userClient.queryById(order.getUserId()));
        return order;
    }
}
