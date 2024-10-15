package com.tedu.teamserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.teamserver.pojo.Team.TeamDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper//mybatis-plus为接口创建实现类，再创建对象，把对象放在spring容器中
public interface TeamMapper extends BaseMapper<TeamDAO>{
}

