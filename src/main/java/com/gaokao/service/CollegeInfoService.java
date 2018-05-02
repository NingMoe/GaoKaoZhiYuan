package com.gaokao.service;

import com.gaokao.entity.CollegeInfo;

import java.util.List;

public interface CollegeInfoService {
    public List<CollegeInfo> getAllCollege();
    public List getCollegeByName(String name);
    public CollegeInfo getAppById(String id);
}
