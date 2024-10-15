package com.tedu.teamserver.service;

import com.tedu.teamserver.pojo.User.UserDAO;
import com.tedu.teamserver.pojo.User.UserDTO;
import com.tedu.teamserver.pojo.User.UserPasswordDTO;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param userDTO:用户输入，包含用户名和密码
     * @return 登陆成功返回用户id，登陆失败返回-1
     */
    public Integer login(UserDTO userDTO);

    /**
     * 用户注册
     * @param userDTO:用户输入，包含用户名和密码
     * @return 注册成功返回用户id，其他情况抛出异常
     */
    public Integer register(UserDTO userDTO);

    /**
     * 用户修改密码
     * @param userPasswordDTO:包括用户id，旧密码，新密码
     * @return true:修改成功 false:修改失败
     */
    public boolean changePassword(UserPasswordDTO userPasswordDTO);

    /**
     * 通过用户id获取用户对象
     * @param id 用户id
     * @return 用户对象DAO
     */
    public UserDAO getUserById(Integer id);

    /**
     * 获取全部用户信息
     * @return 返回用户信息列表
     */
    public List<UserDAO> selectAll();

    /**
     * 通过用户id删除用户信息
     * @param id 用户id
     * @return true:删除成功 false:删除失败
     */
    public boolean delete(Integer id);

    /**
     * 修改用户账户信息
     * @param userDAO 管理员端输入信息
     * @return true:修改成功 false:修改失败
     */
    public boolean update(UserDAO userDAO);
}
