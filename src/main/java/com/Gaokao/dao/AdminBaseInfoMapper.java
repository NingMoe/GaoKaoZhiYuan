package com.Gaokao.dao;

import com.Gaokao.entity.AdminBaseInfo;
import org.apache.ibatis.annotations.Param;

public interface AdminBaseInfoMapper {
    public AdminBaseInfo getAdminByName(String loginName);
    public void addAdmin(AdminBaseInfo adminBaseInfo);
    public int updateAdminInfo(@Param(value = "id") int id, @Param(value = "loginName")String loginName, @Param(value = "passwd")String passwd);
    public AdminBaseInfo getAdminById(int id);
}
