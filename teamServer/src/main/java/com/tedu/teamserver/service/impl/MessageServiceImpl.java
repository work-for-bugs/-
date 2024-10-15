package com.tedu.teamserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.teamserver.mapper.MessageMapper;
import com.tedu.teamserver.mapper.TeamMapper;
import com.tedu.teamserver.mapper.UserInfoMapper;
import com.tedu.teamserver.pojo.Message.*;
import com.tedu.teamserver.pojo.Team.TeamDAO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    TeamMapper teamMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public MessageDAO selectById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("message_id", id);

        MessageDAO messageDAO = messageMapper.selectOne(queryWrapper);
        if(messageDAO == null)
        {
            throw new RuntimeException("查询数据错误");
        }

        return messageDAO;
    }

    @Override
    public List<MessageVO> selectByReceiveId(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("receive_user_id", id);
        queryWrapper.eq("handle_state", 0);

        List<MessageDAO> list = messageMapper.selectList(queryWrapper);
        if(list == null)
        {
            throw new RuntimeException("查询数据错误");
        }

        ArrayList<MessageVO> voList = new ArrayList<>();
        for (MessageDAO messageDAO:list) {
            MessageVO messageVO = new MessageVO();
            messageVO.setMessageId(messageDAO.getMessageId());
            QueryWrapper queryWrapperTeam = new QueryWrapper();
            queryWrapperTeam.eq("team_id", messageDAO.getTeamId());
            TeamDAO teamDAO = teamMapper.selectOne(queryWrapperTeam);
            messageVO.setTeamName(teamDAO.getActivityName());
            messageVO.setExamine(teamDAO.getExamine());
            QueryWrapper queryWrapperUser = new QueryWrapper();
            queryWrapperUser.eq("user_id", messageDAO.getSendUserId());
            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapperUser);
            messageVO.setSendUserName(userInfoDAO.getUserName());
            voList.add(messageVO);
        }

        return voList;
    }

    @Override
    public boolean insert(MessageInsertDTO messageInsertDTO) {
        MessageDAO messageDAO = new MessageDAO();
        BeanUtils.copyProperties(messageInsertDTO,messageDAO);

        int insertRow = messageMapper.insert(messageDAO);

        return insertRow >= 1 ? true : false;
    }

    @Override
    public boolean update(MessageUpdateDTO messageUpdateDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("message_id",messageUpdateDTO.getMessageId());

        MessageDAO messageDAO = new MessageDAO();
        BeanUtils.copyProperties(messageUpdateDTO,messageDAO);

        int updateRow = messageMapper.update(messageDAO,queryWrapper);

        return updateRow >= 1 ? true : false;
    }
}
