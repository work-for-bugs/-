package com.tedu.teamserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.teamserver.pojo.Message.MessageDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<MessageDAO> {
}
