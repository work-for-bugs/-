package com.tedu.teamserver.controller;


import com.tedu.teamserver.pojo.Message.*;
import com.tedu.teamserver.pojo.Message.MessageDAO;
import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import com.tedu.teamserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/message/selectById")
    public ServerResult selectById(Integer id) {
        MessageDAO messageDAO = messageService.selectById(id);
        ServerResult serverResult = new ServerResult(0,"success", messageDAO);
        return serverResult;
    }

    @RequestMapping("/message/selectByReceiveId")
    public ServerResult selectByReceiveId(Integer id) {
        List<MessageVO> list = messageService.selectByReceiveId(id);
        ServerResult serverResult = new ServerResult(0,"success", list);
        return serverResult;
    }

    @RequestMapping("/message/insert")
    public ServerResult insert(MessageInsertDTO messageInsertDTO) {
        boolean isSuccess = messageService.insert(messageInsertDTO);
        if (isSuccess){
            return new ServerResult(0,"添加成功",null);
        }else{
            return new ServerResult(301,"添加失败",null);
        }

    }

    @RequestMapping("/message/update")
    public ServerResult update(MessageUpdateDTO messageUpdateDTO) {
        boolean isSuccess = messageService.update(messageUpdateDTO);
        if (isSuccess){
            return new ServerResult(0,"消息信息修改成功",null);
        }else{
            return new ServerResult(303,"消息信息修改失败",null);
        }

    }
}
