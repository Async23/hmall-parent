package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 根据用户 id 查询用户
     *
     * @param id
     * @return
     */
    User queryById(Long id);
}
