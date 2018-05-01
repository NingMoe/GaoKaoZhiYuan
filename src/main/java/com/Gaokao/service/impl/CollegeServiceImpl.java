package com.Gaokao.service.impl;

import com.Gaokao.dao.CollegeInfoMapper;
import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.service.CollegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeInfoService {
    @Autowired
    private CollegeInfoMapper collegeInfoMapper;

    @Override
    public List<CollegeInfo> getAllCollege() {
        return collegeInfoMapper.getAllCollege();
    }

    @Override
    public List getCollegeByName(String name) {
       List collegeList = collegeInfoMapper.getCollegeByName(name);
       return collegeList;
    }

    @Override
    public CollegeInfo getAppById(String id) {
        return collegeInfoMapper.getCollegeById(id);
    }
}
