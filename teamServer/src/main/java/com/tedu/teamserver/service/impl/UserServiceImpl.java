package com.tedu.teamserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.teamserver.mapper.UserMapper;
import com.tedu.teamserver.service.UserService;
import com.tedu.teamserver.pojo.User.UserDAO;
import com.tedu.teamserver.pojo.User.UserDTO;
import com.tedu.teamserver.pojo.User.UserPasswordDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer login(UserDTO userDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_account",userDTO.getUserAccount());
        queryWrapper.eq("user_password", userDTO.getUserPassword());

        UserDAO userDAO = userMapper.selectOne(queryWrapper);

        //判断是否登陆成功
        if(userDAO != null){
            return userDAO.getUserId();
        }
        return -1; // 登陆失败
    }

    @Override
    public Integer register(UserDTO userDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_account",userDTO.getUserAccount());
        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO == null){
            UserDAO insertUserDAO = new UserDAO();
            BeanUtils.copyProperties(userDTO,insertUserDAO);
            int insertRow = userMapper.insert(insertUserDAO);
            if(insertRow == 0){
                throw new RuntimeException("注册时数据库保存失败");
            }
            else{
                QueryWrapper selectQueryWrapper =  new QueryWrapper();
                selectQueryWrapper.eq("user_account",userDTO.getUserAccount());
                selectQueryWrapper.eq("user_password",userDTO.getUserPassword());
                UserDAO selectUserDAO = userMapper.selectOne(selectQueryWrapper);
                return selectUserDAO.getUserId();
            }
        }
        throw  new RuntimeException("注册时用户名已存在");
    }

    @Override
    public boolean changePassword(UserPasswordDTO userPasswordDTO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_account",userPasswordDTO.getUserAccount());
        queryWrapper.eq("user_password",userPasswordDTO.getOldPassword());

        UserDAO userDAO = new UserDAO();
        userDAO.setUserPassword(userPasswordDTO.getNewPassword());

        int updateRow = userMapper.update(userDAO,queryWrapper);
        return updateRow >= 1;
    }

    @Override
    public UserDAO getUserById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);

        UserDAO userDAO = userMapper.selectOne(queryWrapper);
        if(userDAO == null)
            throw new RuntimeException("没有该id的用户");
        return userDAO;
    }

    @Override
    public List<UserDAO> selectAll() {
        List<UserDAO> list = userMapper.selectList(null);
        return list;
    }

    @Override
    public boolean delete(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        int deleteRow = userMapper.delete(queryWrapper);
        return deleteRow >= 1;
    }

    @Override
    public boolean update(UserDAO userDAO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userDAO.getUserId());
        int updateRow = userMapper.update(userDAO, queryWrapper);
        return updateRow>=1;
    }
}
