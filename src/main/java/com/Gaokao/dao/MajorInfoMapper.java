package com.Gaokao.dao;

import com.Gaokao.entity.MajorInfo;

import java.util.List;

public interface MajorInfoMapper {
    public List<MajorInfo> getAllMaj();
    public List getMajorByName(String name);
}
