package com.Gaokao.service.impl;

import com.Gaokao.dao.ExamScoreInfoMapper;
import com.Gaokao.dao.UserBaseInfoMapper;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Autowired
    private ExamScoreInfoMapper examScoreInfoMapper;

    public UserBaseInfo isUserLegal(UserBaseInfo userBaseInfo){
       UserBaseInfo userInfo = userBaseInfoMapper.getUserByName(userBaseInfo.getLoginName());
       if(userInfo!=null){
           if(userInfo.getPasswd().equals(userBaseInfo.getPasswd())){
               List scoreList = null;
               scoreList = examScoreInfoMapper.getScoreByUid(userInfo.getId());
               userInfo.setScoreList(scoreList);
               return userInfo;
           }
       }
       return null;
    }

    @Override
    public UserBaseInfo getUserById(int id) {
        return userBaseInfoMapper.getUserById(id);
    }

    @Override
    public UserBaseInfo getUserByName(String loginName) {
        return userBaseInfoMapper.getUserByName(loginName);
    }

    @Override
    public void addUser(UserBaseInfo userBaseInfo) {
        UserBaseInfo userInfo = userBaseInfoMapper.getUserByName(userBaseInfo.getLoginName());
        if(userInfo==null){
            userBaseInfoMapper.addUser(userBaseInfo);
        }

    }

    @Override
    public int updateUserInfo(int id, String loginName, String passwd) {
        return userBaseInfoMapper.updateUserInfo(id,loginName,passwd);
    }
}
