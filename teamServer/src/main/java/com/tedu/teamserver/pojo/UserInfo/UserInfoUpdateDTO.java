package com.tedu.teamserver.pojo.UserInfo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_info")
public class UserInfoUpdateDTO {
    Integer userId; // id
    String userName; // name
    String gender; // gender
    Integer age; // age
    String userDescription; // personal description
    String signature; // signature

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
