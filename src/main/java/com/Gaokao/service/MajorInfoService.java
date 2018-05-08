package com.Gaokao.service;

import com.Gaokao.entity.MajorInfo;

import java.util.List;

public interface MajorInfoService {
  public List<MajorInfo> getAllMaj();
  public List getMajorByName(String name);
  public boolean addMajor(MajorInfo majorInfo);
  public void deleteMajor(String id);
}
