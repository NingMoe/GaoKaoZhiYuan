package com.Gaokao.service;

import com.Gaokao.entity.UserBaseInfo;

public interface UserInfoService {
    public UserBaseInfo isUserLegal(UserBaseInfo userBaseInfo);
    public void addUser(UserBaseInfo userBaseInfo);
}
