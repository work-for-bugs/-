package com.tedu.teamserver.pojo.UserTeamRelation;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : team
//  @ File Name : UserTeamRelationInsertDTO.java
//  @ Date : 2022/7/6
//  @ Author : 
//
//

/**
 * Function:添加用户组队信息时，封装的数据
 * Time:2022/7/6
 */

public class UserTeamRelationInsertDTO {
	public Integer userId;
	public Integer teamId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
}