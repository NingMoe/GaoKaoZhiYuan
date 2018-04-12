package com.Gaokao.service.impl;

import com.Gaokao.dao.MajorInfoMapper;
import com.Gaokao.entity.MajorInfo;
import com.Gaokao.service.MajorInfoService;
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
}
