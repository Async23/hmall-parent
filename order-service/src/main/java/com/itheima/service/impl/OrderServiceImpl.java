package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.client.UserClient;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.OrderService;
import org.apache.catalina.mbeans.UserMBean;
import org.bouncycastle.crypto.tls.UserMappingType;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 根据订单 id 查询订单
     *
     * @param id
     * @return
     */
    @Override
    public Order queryById(Long id) {
        Order order = orderMapper.queryById(id);
        order.setUser(userClient.queryById(order.getUserId()));
        return order;
    }

    /**
     * 模拟下单方法
     *
     * @param order
     * @return
     */
    @Override
    public String submit(Order order) {
        if (order == null || order.getUserId() == null || order.getPrice() == null) {
            return "下单失败";
        }

        rabbitTemplate.convertAndSend("hmall-parent-exchange", "order.user.submit", order);

        orderMapper.insert(order);

        // Order order = orderMapper.queryById(id);
        // order.setUser(userClient.queryById(order.getUserId()));


        return JSON.toJSON(order).toString();
    }
}
