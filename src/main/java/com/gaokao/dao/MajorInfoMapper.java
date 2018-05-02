package com.gaokao.dao;

import com.gaokao.entity.MajorInfo;

import java.util.List;

public interface MajorInfoMapper {
    public List<MajorInfo> getAllMaj();
    public List getMajorByName(String name);
}
