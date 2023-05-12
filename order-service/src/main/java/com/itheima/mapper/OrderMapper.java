package com.itheima.mapper;


import com.itheima.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    /**
     * 根据订单 id 查询订单
     *
     * @param id
     * @return
     */
    Order queryById(Long id);

    /**
     * 新增订单
     *
     * @param order
     */
    void insert(Order order);
}
