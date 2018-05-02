package com.gaokao.dao;

import com.gaokao.entity.CollegeInfo;

import java.util.List;

public interface CollegeInfoMapper {
    public List<CollegeInfo> getAllCollege();
    public List getCollegeByName(String name);
    public CollegeInfo getCollegeById(String id);
}
