package com.Gaokao.dao;

import com.Gaokao.entity.CollegeApplicationInfo;

import java.util.List;

public interface CollegeApplicationMapper {
    public void addApplication(int zsid,int uid,int px);
    public void deleteApplication(int zsid,int uid);
    public int getApplicationRank();
    public List getApplicatonByUid(int uid);
}
