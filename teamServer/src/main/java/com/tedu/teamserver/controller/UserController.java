package com.tedu.teamserver.controller;

import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.service.UserInfoService;
import com.tedu.teamserver.service.UserService;
import com.tedu.teamserver.pojo.User.UserDAO;
import com.tedu.teamserver.pojo.User.UserDTO;
import com.tedu.teamserver.pojo.User.UserPasswordDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
public class UserController extends HttpServlet{
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("/user/login")
    public ServerResult login(UserDTO userDTO){
        Integer id = userService.login(userDTO);
        if(id >= 1){
            UserDAO userDAO = new UserDAO();
            BeanUtils.copyProperties(userDTO,userDAO);
            userDAO.setUserId(id);
            return new ServerResult(0,"登陆成功",id);
        }
        return new ServerResult(101,"登陆失败",null);
    }

    @RequestMapping("/user/register")
    public ServerResult register(UserDTO userDTO){
        Integer id = userService.register(userDTO);
        UserInfoDAO userInfoDAO = new UserInfoDAO();
        userInfoDAO.setUserId(id);
        userInfoDAO.setUserName("未更新");
        userInfoDAO.setAge(0);
        userInfoDAO.setGender("男");
        boolean isSuccess = userInfoService.insert(userInfoDAO);
        if(isSuccess)
            return new ServerResult(0,"注册成功",id);
        return new ServerResult(106,"注册失败",-1);
    }

    @RequestMapping("/user/changePassword")
    public ServerResult changePassword(UserPasswordDTO userPasswordDTO){
//        UserDAO userDAO = (UserDAO) request.getSession().getAttribute("user");
//        if(userDAO == null){
//            return new ServerResult(110,"请先登录",null);
//        }
//        else if(!Objects.equals(userDAO.getUserAccount(), userPasswordDTO.getUserAccount())){
//            return new ServerResult(111,"所要修改的用户名与已登录的用户名不一致",null);
//        }

        boolean isSuccess = userService.changePassword(userPasswordDTO);

        if(isSuccess){
            return new ServerResult(0,"修改密码成功",null);
        }
        else{
            return new ServerResult(102,"修改密码失败",null);
        }
    }

    @RequestMapping("/user/getUserById")
    public ServerResult getUserById(Integer id){
        UserDAO userDAO = userService.getUserById(id);
        return new ServerResult(0,"查询成功",userDAO);
    }

    @RequestMapping("/user/selectAll")
    public ServerResult selectAll(){
        List<UserDAO> list = userService.selectAll();
        return new ServerResult(0,"查询成功",list);
    }

    @RequestMapping("/user/delete")
    public ServerResult delete(Integer id){
        boolean isSuccess = userService.delete(id);

        if(isSuccess){
            return new ServerResult(0,"删除成功",null);
        }
        else{
            return new ServerResult(103,"删除失败",null);
        }
    }

    @RequestMapping("/user/update")
    public ServerResult update(UserDAO userDAO){
        boolean isSuccess = userService.update(userDAO);
        if(isSuccess){
            return new ServerResult(0,"修改成功",null);
        }
        else{
            return new ServerResult(104,"修改失败",null);
        }
    }
}
