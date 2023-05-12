package com.itheima.web;

import com.itheima.pojo.Order;
import com.itheima.result.Result;
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
    public Result<Order> queryById(@PathVariable Long id) {
        Order order = orderService.queryById(id);
        return Result.success(order);
    }

    /**
     * 模拟下单方法
     *
     * @param order
     * @return
     */
    @PostMapping("/submit")
    public Result<String> submit(@RequestBody Order order) {
        if (orderService.submit(order)) {
            return Result.success();
        }
        return Result.error("下单失败");
    }
}
