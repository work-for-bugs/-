package com.tedu.teamserver.service;

import com.tedu.teamserver.pojo.Team.TeamDAO;
import com.tedu.teamserver.pojo.Team.TeamInsertDTO;
import com.tedu.teamserver.pojo.Team.TeamUpdateDTO;
import com.tedu.teamserver.pojo.Team.TeamVO;

import java.util.List;

public interface TeamService {
    /**
     * 按照名称模糊查询
     * @param str
     * @return
     */
    public List<TeamVO> selectFuzzily(String str);
    /**
     * 按照id查找
     * @return
     */
    public TeamVO selectById(Integer id);

    /**
     * 按照类型号查找
     * @param categoryid
     * @return
     */
    public List<TeamVO> selectByCategoryId(Integer categoryid);

    /**
     * 按照活动名称查找
     * @param name
     * @return
     */
    public List<TeamVO> selectByActivityName(String name);

    /**
     * 按照发起人查找
     * @param userid
     * @return
     */
    public List<TeamVO> selectByUserId(Integer userid);

    /**
     * 按照状态查找
     * @param state
     * @return
     */
    public List<TeamVO> selectByState(Integer state);

    /**
     * 查找所有组队活动
     * @return
     */
    public List<TeamVO> selectAll();

    /**
     * 增加新组队活动
     * @param teamInsertDTO
     * @return
     */
    public boolean insert(TeamInsertDTO teamInsertDTO);

    /**
     * 修改活动信息
     * @param teamUpdateDTO
     * @return
     */
    public boolean update(TeamUpdateDTO teamUpdateDTO);

    /**
     * 删除一个活动
     * @param id
     * @return
     */
    public boolean delete(Integer id);


}
