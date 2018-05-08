package com.Gaokao.service;

import com.Gaokao.entity.CollegeInfo;

import java.util.List;

public interface CollegeInfoService {
    public List<CollegeInfo> getAllCollege();
    public List getCollegeByName(String name);
    public CollegeInfo getAppById(String id);
    public void addCollege(CollegeInfo collegeInfo);
    public void updateCollege(CollegeInfo collegeInfo);
    public void deleteCollege(String id);
}
