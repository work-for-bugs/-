package com.tedu.teamserver.service;

import com.tedu.teamserver.pojo.TeamCategory.TeamCategoryDAO;

import java.util.List;

public interface TeamCategoryService {
    public List<TeamCategoryDAO> selectAll();
    public TeamCategoryDAO selectById(Integer id);
}
