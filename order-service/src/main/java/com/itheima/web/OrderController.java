package com.itheima.web;

import com.itheima.pojo.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param order
     * @return
     */
    @PostMapping("/submit")
    public String submit(@RequestBody Order order) {
        return orderService.submit(order);
    }
}
