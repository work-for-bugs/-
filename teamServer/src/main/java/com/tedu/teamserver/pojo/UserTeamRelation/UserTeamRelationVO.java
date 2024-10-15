package com.tedu.teamserver.pojo.UserTeamRelation;

public class UserTeamRelationVO {
	public Integer joinId;
	public Integer userId;
	public Integer teamId;

	public String getTeamName() {
		return teamName;
	}

	public String teamName;

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getJoinId() {
		return joinId;
	}

	public void setJoinId(Integer joinId) {
		this.joinId = joinId;
	}

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
