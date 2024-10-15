package com.tedu.teamserver.controller;

import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import com.tedu.teamserver.pojo.Team.*;
import com.tedu.teamserver.pojo.User.UserDAO;
import com.tedu.teamserver.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin
public class TeamController extends HttpServlet {
    @Autowired
    TeamService teamService;

    @RequestMapping("/team/selectFuzzily")
    public ServerResult selectFuzzily(String str)
    {
        List<TeamVO> list = teamService.selectFuzzily(str);
        ServerResult serverResult = new ServerResult(0,"成功",list);
        return serverResult;
    }

    @RequestMapping("/team/selectById")
    //http://localhost:9003/doc.html
    public ServerResult selectById(Integer id)
    {
        TeamVO teamVO = teamService.selectById(id);
        return new ServerResult(0,"成功",teamVO);
    }

    @RequestMapping("/team/selectByCategoryId")
    public ServerResult selectByCategoryId(Integer categoryId)
    {
        List<TeamVO> list = teamService.selectByCategoryId(categoryId);
        ServerResult serverResult = new ServerResult(0,"成功",list);
        return serverResult;
    }

    @RequestMapping("/team/selectByUserId")
    public ServerResult selectByUserId(Integer userid)
    {
        List<TeamVO> list = teamService.selectByUserId(userid);
        ServerResult serverResult = new ServerResult(0,"成功",list);
        return serverResult;
    }

    @RequestMapping("/team/selectByState")
    public ServerResult selectByState(Integer state)
    {
        List<TeamVO> list = teamService.selectByState(state);
        ServerResult serverResult = new ServerResult(0,"成功",list);
        return serverResult;
    }

    @RequestMapping("/team/selectAll")
    public ServerResult selectAll()
    {
        List<TeamVO> voList = teamService.selectAll();
        return new ServerResult(0,"查询成功",voList);
    }

    @RequestMapping("/team/insert")
    public ServerResult insert(TeamInsertDTO teamInsertDTO)
    {
        boolean isSuccess = teamService.insert(teamInsertDTO);
        if(isSuccess)
        {
            return new ServerResult(0,"添加成功",null);
        }
        else{
            return new ServerResult(301,"添加失败",null);
        }
    }

    @RequestMapping("/team/update")
    public ServerResult update(TeamUpdateDTO teamUpdateDTO)
    {
        boolean isSuccess = teamService.update(teamUpdateDTO);
        if(isSuccess)
        {
            return new ServerResult(0,"修改成功",null);
        }
        else{
            return new ServerResult(302,"修改失败",null);
        }
    }

    @RequestMapping("/team/delete")
    public ServerResult delete(Integer id)
    {
        boolean isSuccess = teamService.delete(id);
        if(isSuccess)
        {
            return new ServerResult(0,"删除成功",null);
        }
        else{
            return new ServerResult(303,"删除失败",null);
        }
    }







}
