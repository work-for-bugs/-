package com.tedu.teamserver.controller;


import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoUpdateDTO;
import com.tedu.teamserver.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/user_info/selectById")
    public ServerResult selectById(Integer id){
        UserInfoDAO userInfoDAO = userInfoService.selectById(id);
        if(userInfoDAO!=null) {
            ServerResult serverResult = new ServerResult(0, "UserInfo selectedById success!", userInfoDAO);
            return serverResult;
        }else{
         return new ServerResult(302, "UserInfo is not in database!", null);
        }
    }

    @RequestMapping("/user_info/update")
    public ServerResult update(UserInfoUpdateDTO userInfoUpdateDTO){
        boolean isSuccess = userInfoService.update(userInfoUpdateDTO);
        if(isSuccess){
            return new ServerResult(0, "userInfo update success!", null);
        }else{
            return new ServerResult(302, "userInfo update failed!", null);
        }
    }

    @RequestMapping("/user_info/insert")
    public ServerResult insert(UserInfoDAO userInfoDAO){
        boolean isSuccess = userInfoService.insert(userInfoDAO);
        if(isSuccess){
            return new ServerResult(0,"插入成功",null);
        }
        else{
            return new ServerResult(303,"插入失败",null);
        }
    }
}
