package com.gaokao.dao;

import com.gaokao.entity.UserBaseInfo;

public interface UserBaseInfoMapper {
  public UserBaseInfo getUserByName(String loginName);
  public void addUser(UserBaseInfo userBaseInfo);
  public int updateUserInfo(int id,String loginName,String passwd);
  public UserBaseInfo getUserById(int id);
}
