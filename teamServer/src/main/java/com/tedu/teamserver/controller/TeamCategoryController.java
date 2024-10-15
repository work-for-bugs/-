package com.tedu.teamserver.controller;


import com.tedu.teamserver.pojo.ServerResult.ServerResult;
import com.tedu.teamserver.pojo.TeamCategory.TeamCategoryDAO;
import com.tedu.teamserver.service.TeamCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TeamCategoryController {
    @Autowired
    TeamCategoryService teamCategoryService;

    @RequestMapping("/team_category/selectAll")
    public ServerResult selectAll(){
        List<TeamCategoryDAO> list = teamCategoryService.selectAll();
        return new ServerResult(0, "TeamCategory selectAll success!", list);
    }

    @RequestMapping("/team_category/selectById")
    public ServerResult selectById(Integer id){
        TeamCategoryDAO teamCategoryDAO = teamCategoryService.selectById(id);
        if(teamCategoryDAO!=null){
            return new ServerResult(0, "TeamCategory selectById success!", teamCategoryDAO);
        }else{
            return new ServerResult(302, "TeamCategory selectById failed!", null);
        }
    }

}
