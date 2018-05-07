package com.Gaokao.dao;

import com.Gaokao.entity.CollegeInfo;

import java.util.List;

public interface CollegeInfoMapper {
    public List<CollegeInfo> getAllCollege();
    public List getCollegeByName(String name);
    public CollegeInfo getCollegeById(String id);
    public void addCollege(CollegeInfo collegeInfo);
    public void deleteCollege(String id);
}
