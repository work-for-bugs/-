package com.tedu.teamserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.teamserver.mapper.TeamCategoryMapper;
import com.tedu.teamserver.mapper.TeamMapper;
import com.tedu.teamserver.mapper.UserInfoMapper;
import com.tedu.teamserver.pojo.Team.TeamDAO;
import com.tedu.teamserver.pojo.Team.TeamInsertDTO;
import com.tedu.teamserver.pojo.Team.TeamUpdateDTO;
import com.tedu.teamserver.pojo.Team.TeamVO;
import com.tedu.teamserver.pojo.TeamCategory.TeamCategoryDAO;
import com.tedu.teamserver.pojo.UserInfo.UserInfoDAO;
import com.tedu.teamserver.service.TeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;

    @Autowired
    TeamCategoryMapper teamCategoryMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<TeamVO> selectFuzzily(String str) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("activity_name",str);
        List<TeamDAO> daoList = teamMapper.selectList(queryWrapper);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        if (voList.size() == 0)
        {
            throw new RuntimeException("没有找到相关的组队信息");
        }
        return voList;
    }

    @Override
    public TeamVO selectById(Integer id) {
        //select * from team where id=1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("team_id",id);
        TeamDAO teamDAO = teamMapper.selectOne(queryWrapper);

        //根据组队的分类编号查询分类名称
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("category_id",teamDAO.getCategoryId());

        TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

        //根据发起人的id查询发起人姓名
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("user_id",teamDAO.getUserId());

        UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

        //2.1创建TeamVO
        TeamVO teamVO = new TeamVO();
        teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
        teamVO.setUserName(userInfoDAO.getUserName());
        //2.2DAO中赋值给VO
        BeanUtils.copyProperties(teamDAO,teamVO);

        if (teamDAO == null)
        {
            throw new RuntimeException("没有该id的组队信息");
        }
        return teamVO;
    }

    @Override
    public List<TeamVO> selectByCategoryId(Integer categoryId) {
        //select * from team where categor_id=1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id",categoryId);
        List<TeamDAO> daoList = teamMapper.selectList(queryWrapper);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        if (voList.size() == 0)
        {
            throw new RuntimeException("没有找到相关的组队信息");
        }
        return voList;
    }

    @Override
    public List<TeamVO> selectByActivityName(String name) {
        //select * from team where activity_name = "数学建模"
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_name",name);
        List<TeamDAO> daoList = teamMapper.selectList(queryWrapper);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        if (voList.size() == 0)
        {
            throw new RuntimeException("没有找到相关的组队信息");
        }
        return voList;
    }

    @Override
    public List<TeamVO> selectByUserId(Integer userid) {
        //select * from team where user_id = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userid);
        List<TeamDAO> daoList = teamMapper.selectList(queryWrapper);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        if (voList.size() == 0)
        {
            throw new RuntimeException("没有找到相关的组队信息");
        }
        return voList;
    }

    @Override
    public List<TeamVO> selectByState(Integer state) {
        //select * from team where activity_state = 1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("activity_state",state);
        List<TeamDAO> daoList = teamMapper.selectList(queryWrapper);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        if (voList.size() == 0)
        {
            throw new RuntimeException("没有找到相关的组队信息");
        }
        return voList;
    }

    @Override
    public List<TeamVO> selectAll() {
        //select * from team
        //1.查出表中所有组队信息
        List<TeamDAO> daoList = teamMapper.selectList(null);

        ArrayList<TeamVO> voList=new ArrayList<>();
        //2.遍历 List<TeamDAO>
        for(TeamDAO teamDAO:daoList)
        {
            //根据组队的分类编号查询分类名称
            QueryWrapper queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("category_id",teamDAO.getCategoryId());

            TeamCategoryDAO teamCategoryDAO = teamCategoryMapper.selectOne(queryWrapper1);

            //根据发起人的id查询发起人姓名
            QueryWrapper queryWrapper2 = new QueryWrapper();
            queryWrapper2.eq("user_id",teamDAO.getUserId());

            UserInfoDAO userInfoDAO = userInfoMapper.selectOne(queryWrapper2);

            //2.1创建TeamVO
            TeamVO teamVO = new TeamVO();
            teamVO.setCategoryName(teamCategoryDAO.getCategoryName());
            teamVO.setUserName(userInfoDAO.getUserName());
            //2.2DAO中赋值给VO
            BeanUtils.copyProperties(teamDAO,teamVO);
            voList.add(teamVO);
        }

        //3.返回voList
        return voList;
    }

    @Override
    public boolean insert(TeamInsertDTO teamInsertDTO) {
        TeamDAO teamDAO = new TeamDAO();
        //拷贝属性
        BeanUtils.copyProperties(teamInsertDTO,teamDAO);
        int insertRow = teamMapper.insert(teamDAO);
        return insertRow>=1?true:false;
    }

    @Override
    public boolean update(TeamUpdateDTO teamUpdateDTO) {
        //update team set activity_name='' where id=1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("team_id",teamUpdateDTO.getTeamId());

        //将新数据放入DAO
        TeamDAO teamDAO = new TeamDAO();
        BeanUtils.copyProperties(teamUpdateDTO,teamDAO);

        int updateRow = teamMapper.update(teamDAO,queryWrapper);
        return updateRow>=1?true:false;
    }

    @Override
    public boolean delete(Integer id) {
        //delete from team where team_id=1
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("team_id",id);

        int deleteRow = teamMapper.delete(queryWrapper);

        return deleteRow>=1?true:false;
    }
}
