package com.tedu.teamserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.teamserver.mapper.UserInfoMapper;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDTO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoUpdateDTO;
import com.tedu.teamserver.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public UserInfoDAO selectById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);

        UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper);
        return userInfoDAO;
    }

    @Override
    public boolean insert(UserInfoDAO userInfoDAO) {
        int insertRow = userInfoMapper.insert(userInfoDAO);
        return insertRow >= 1;
    }

    @Override
    public boolean update(UserInfoUpdateDTO userInfoUpdateDTO) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userInfoUpdateDTO.getUserId());
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        BeanUtils.copyProperties(userInfoUpdateDTO, userInfoDAO);
        int updateRow = userInfoMapper.update(userInfoDAO, queryWrapper);
        return updateRow>=1?true:false;
    }
}
