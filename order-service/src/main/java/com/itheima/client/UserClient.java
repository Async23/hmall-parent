package com.itheima.client;

import com.itheima.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    User queryById(@PathVariable Long id);
}
