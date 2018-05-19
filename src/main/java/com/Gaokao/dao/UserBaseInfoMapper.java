package com.Gaokao.dao;

import com.Gaokao.entity.UserBaseInfo;

import java.util.List;

public interface UserBaseInfoMapper {
  public UserBaseInfo getUserByName(String loginName);
  public void addUser(UserBaseInfo userBaseInfo);
  public void deleteUser(int id);
  public void addUserGetId(UserBaseInfo userBaseInfo);
  public int updateUserInfo(int id,String loginName,String passwd);
  public UserBaseInfo getUserById(int id);
  public List<UserBaseInfo> getAllUser();
}
