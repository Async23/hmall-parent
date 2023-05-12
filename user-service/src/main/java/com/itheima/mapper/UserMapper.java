package com.itheima.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.itheima.pojo.User;

@Mapper
public interface UserMapper {
    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    User queryById(Long id);

    /**
     * 新增用户
     *
     * @param user
     */
    void insert(User user);
}
