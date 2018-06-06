package com.Gaokao.service.impl;

import com.Gaokao.dao.ExamScoreInfoMapper;
import com.Gaokao.dao.UserBaseInfoMapper;
import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Autowired
    private ExamScoreInfoMapper examScoreInfoMapper;

    @Override
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
            userBaseInfoMapper.addUserGetId(userBaseInfo);
            if(userBaseInfo.getScoreList()!=null){
                for(ExamScoreInfo examScoreInfo:userBaseInfo.getScoreList()){
                    int cid = examScoreInfoMapper.getScoreCidByName(examScoreInfo.getSubjectName());
                    examScoreInfo.setSubjectId(cid);
                    examScoreInfoMapper.addExamScore(examScoreInfo.getSubjectId(),examScoreInfo.getSubjectName(),userBaseInfo.getId(),examScoreInfo.getScore());
                }

            }
        }

    }

    @Override
    public void deleteUser(int id) {
        userBaseInfoMapper.deleteUser(id);
    }

    @Override
    public int updateUserInfo(int id, String loginName, String passwd) {
        return userBaseInfoMapper.updateUserInfo(id,loginName,passwd);
    }

    @Override
    public List<UserBaseInfo> getAllUser() {
        return userBaseInfoMapper.getAllUser();
    }

    @Override
    public List<ExamScoreInfo> getExamScoreByUid(int uid) {
        return examScoreInfoMapper.getScoreByUid(uid);
    }
}
