package com.gaokao.service.impl;

import com.gaokao.dao.MajorInfoMapper;
import com.gaokao.entity.MajorInfo;
import com.gaokao.service.MajorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorInfoService {
    @Autowired
    private MajorInfoMapper majorInfoMapper;
    @Override
    public List<MajorInfo> getAllMaj() {
        return majorInfoMapper.getAllMaj();
    }

    @Override
    public List getMajorByName(String name) {
        return majorInfoMapper.getMajorByName(name);
    }
}
