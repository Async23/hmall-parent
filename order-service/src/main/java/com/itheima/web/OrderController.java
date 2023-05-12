package com.itheima.web;

import com.itheima.pojo.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 根据订单 id 查询订单
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Order queryById(@PathVariable Long id) {
        return orderService.queryById(id);
    }

    /**
     * 模拟下单方法
     *
     * @param id
     * @return
     */
    @GetMapping("/submit/{id}")
    public String submit(@PathVariable Long id) {
        return orderService.submit(id);
    }
}
