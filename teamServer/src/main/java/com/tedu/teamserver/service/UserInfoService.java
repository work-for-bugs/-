package com.tedu.teamserver.service;


import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDTO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoUpdateDTO;

public interface UserInfoService {
    UserInfoDAO selectById(Integer id);
    boolean insert(UserInfoDAO userInfoDAO);
    boolean update(UserInfoUpdateDTO userInfoUpdateDTO);
}
