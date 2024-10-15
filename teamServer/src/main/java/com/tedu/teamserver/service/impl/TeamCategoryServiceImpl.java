package com.tedu.teamserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.teamserver.mapper.TeamCategoryMapper;
import com.tedu.teamserver.pojo.TeamCategory.TeamCategoryDAO;
import com.tedu.teamserver.service.TeamCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamCategoryServiceImpl implements TeamCategoryService {
    @Autowired
    TeamCategoryMapper teamCategoryMapper;


    @Override
    public List<TeamCategoryDAO> selectAll() {
        List<TeamCategoryDAO> list = teamCategoryMapper.selectList(null);
        return list;
    }

    @Override
    public TeamCategoryDAO selectById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", id);

        TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper);
        return teamCategoryDAO;
    }
}
