package com.Gaokao.service;

import com.Gaokao.entity.UserBaseInfo;

import java.util.List;

public interface UserInfoService {
    /**判断用户是否合法
     *
     * @param userBaseInfo
     * @return
     */
    public UserBaseInfo isUserLegal(UserBaseInfo userBaseInfo);
    public UserBaseInfo getUserById(int id);
    public UserBaseInfo getUserByName(String loginName);
    public void addUser(UserBaseInfo userBaseInfo);
    public void deleteUser(int id);
    public int updateUserInfo(int id,String loginName,String passwd);
    public List<UserBaseInfo> getAllUser();
}
