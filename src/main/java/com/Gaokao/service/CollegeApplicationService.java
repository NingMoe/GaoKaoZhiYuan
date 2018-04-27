package com.Gaokao.service;

import com.Gaokao.entity.CollegeApplicationInfo;

import java.util.List;

public interface CollegeApplicationService {
    public boolean addApplication(int zsid,int uid);
    public boolean deleteApplication(int zsid,int uid);
    public List getApplicationByUid(int uid);
    public List getApplicationAllByUid(int uid);
    public boolean updateApplicationRank(String code,int zsid,int uid);
}
