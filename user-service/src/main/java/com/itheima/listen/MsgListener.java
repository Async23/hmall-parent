package com.itheima.listen;


import com.itheima.mapper.UserMapper;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.itheima.pojo.Order;

@Component
public class MsgListener {
    @Autowired
    private UserMapper userMapper;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "hmall-parent-exchange", type = ExchangeTypes.TOPIC),
            value = @Queue("order.user.queue1"),
            key = "order.user.submit"
    ))
    public void orderServiceSubmitListener(Order order) {
        // 恭喜您，您的订单: {用户 id ==> 用户信息}   {订单编号}  已经创建成功！！
        System.out.println("恭喜您，您的订单: {" + order.getUserId() + "==> " + order.getUser() + "}   {" + order.getId() + "}  已经创建成功！！");
    }
}
