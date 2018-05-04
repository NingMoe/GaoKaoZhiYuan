package com.Gaokao.service.impl;

import com.Gaokao.dao.AdminBaseInfoMapper;
import com.Gaokao.entity.AdminBaseInfo;
import com.Gaokao.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Autowired
    private AdminBaseInfoMapper adminBaseInfoMapper;

    @Override
    public AdminBaseInfo isAdminLegal(AdminBaseInfo adminBaseInfo) {
        AdminBaseInfo adminInfo = adminBaseInfoMapper.getAdminByName(adminBaseInfo.getLoginName());
        if(adminInfo!=null){
            if(adminInfo.getPasswd().equals(adminBaseInfo.getPasswd())){
                return adminInfo;
            }
        }
        return null;
    }

    @Override
    public AdminBaseInfo getAdminById(int id) {
        return adminBaseInfoMapper.getAdminById(id);
    }

    @Override
    public AdminBaseInfo getAdminByName(String loginName) {
        return adminBaseInfoMapper.getAdminByName(loginName);
    }

    @Override
    public void addAdmin(AdminBaseInfo adminBaseInfo) {
        AdminBaseInfo adminInfo = adminBaseInfoMapper.getAdminByName(adminBaseInfo.getLoginName());
        if(adminInfo==null){
            adminBaseInfoMapper.addAdmin(adminBaseInfo);
        }
    }

    @Override
    public int updateAdminInfo(int id, String loginName, String passwd) {
        return adminBaseInfoMapper.updateAdminInfo(id,loginName,passwd);
    }
}
