package com.gaokao.service;

import com.gaokao.entity.MajorInfo;

import java.util.List;

public interface MajorInfoService {
  public List<MajorInfo> getAllMaj();
  public List getMajorByName(String name);
}
