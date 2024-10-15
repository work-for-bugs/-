package com.tedu.teamserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.tedu.teamserver.pojo.TeamCategory.TeamCategoryDAO;
import org.apache.ibatis.annotations.Mapper;

//数据访问层
//操作TeamCategory表
@Mapper//自动为接口创建实现类，再创建对象，对象放在spring容器中
public interface TeamCategoryMapper extends BaseMapper<TeamCategoryDAO> {

}
