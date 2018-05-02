package com.gaokao.dao;

import com.gaokao.entity.CollegeApplicationInfo;

import java.util.List;

public interface CollegeApplicationMapper {
    public CollegeApplicationInfo getAppInfo(int zsid,int uid);
    public void addApplication(int zsid,int uid,int px);
    public void deleteApplication(int zsid,int uid);
    public int getApplicationRank();
    public List getApplicationByUid(int uid);
    public List getApplicationAllByUid(int uid);
    //上移下移更新排序
    public void updateApplicationRank(int px,int zsid,int uid);
    public CollegeApplicationInfo getRankClose(String code,int zsid,int uid);
}
