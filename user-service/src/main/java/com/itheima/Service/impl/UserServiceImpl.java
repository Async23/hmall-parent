package com.itheima.Service.impl;

import com.itheima.Service.UserService;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.pojo.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    @Override
    public User queryById(Long id) {
        return userMapper.queryById(id);
    }
}
