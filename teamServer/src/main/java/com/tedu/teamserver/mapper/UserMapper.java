package com.tedu.teamserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.teamserver.pojo.User.UserDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {
}
