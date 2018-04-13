package com.Gaokao.service;

import com.Gaokao.entity.UserBaseInfo;

public interface UserInfoService {
    public UserBaseInfo isUserLegal(UserBaseInfo userBaseInfo);
    public UserBaseInfo getUserById(int id);
    public void addUser(UserBaseInfo userBaseInfo);
    public int updateUserInfo(int id,String loginName,String passwd);
}
