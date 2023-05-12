package com.itheima.Service;

import com.itheima.pojo.User;

public interface UserService {
    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    User queryById(Long id);
}
