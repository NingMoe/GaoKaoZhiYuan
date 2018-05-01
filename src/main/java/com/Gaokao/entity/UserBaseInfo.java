package com.Gaokao.entity;

import java.util.List;

/**
 * 用户基本信息实体类
 */
public class UserBaseInfo {
    private int id;
    private String loginName;
    private String passwd;
    private String realName;
    private String address;
    private String phone;
    private String sex;
    private List scoreList;

    public UserBaseInfo() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List getScoreList() {
        return scoreList;
    }

    public void setScoreList(List scoreList) {
        this.scoreList = scoreList;
    }
}
