package com.Gaokao.service;

import com.Gaokao.entity.AdminBaseInfo;

public interface AdminInfoService {
    //判断用户是否合法
    public AdminBaseInfo isAdminLegal(AdminBaseInfo adminBaseInfo);
    public AdminBaseInfo getAdminById(int id);
    public AdminBaseInfo getAdminByName(String loginName);
    public void addAdmin(AdminBaseInfo adminBaseInfo);
    public int updateAdminInfo(int id,String loginName,String passwd);
}
