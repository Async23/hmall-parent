package com.itheima;

import com.itheima.mapper.OrderMapper;
import com.itheima.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test(){
        Order order = orderMapper.queryById(101L);
        System.out.println(order);
    }
}
