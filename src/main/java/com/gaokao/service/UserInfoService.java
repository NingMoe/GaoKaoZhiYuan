package com.gaokao.service;

import com.gaokao.entity.UserBaseInfo;

public interface UserInfoService {
    //判断用户是否合法
    public UserBaseInfo isUserLegal(UserBaseInfo userBaseInfo);
    public UserBaseInfo getUserById(int id);
    public UserBaseInfo getUserByName(String loginName);
    public void addUser(UserBaseInfo userBaseInfo);
    public int updateUserInfo(int id,String loginName,String passwd);
}
