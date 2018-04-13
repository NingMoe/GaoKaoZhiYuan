package com.Gaokao.dao;

import com.Gaokao.entity.UserBaseInfo;

public interface UserBaseInfoMapper {
  public UserBaseInfo getUserByName(String username);
  public void addUser(UserBaseInfo userBaseInfo);
  public int updateUserInfo(int id,String loginName,String passwd);
  public UserBaseInfo getUserById(int id);
}
