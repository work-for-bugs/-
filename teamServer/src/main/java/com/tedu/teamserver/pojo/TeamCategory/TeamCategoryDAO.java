package com.tedu.teamserver.pojo.TeamCategory;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("team_category")
public class TeamCategoryDAO {
    Integer categoryId; // category id
    String categoryName; // category name

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
