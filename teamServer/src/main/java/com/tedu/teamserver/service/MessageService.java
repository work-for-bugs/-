package com.tedu.teamserver.service;

import com.tedu.teamserver.pojo.Message.*;

import java.util.List;

public interface MessageService {
    public MessageDAO selectById(Integer id);
    public List<MessageVO> selectByReceiveId(Integer id);
    public boolean insert(MessageInsertDTO messageInsertDTO);
    public boolean update(MessageUpdateDTO messageUpdateDTO);
}
