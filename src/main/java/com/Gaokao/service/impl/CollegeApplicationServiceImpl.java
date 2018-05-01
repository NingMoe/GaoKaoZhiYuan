package com.Gaokao.service.impl;

import com.Gaokao.dao.CollegeApplicationMapper;
import com.Gaokao.dao.CollegePlanMapper;
import com.Gaokao.entity.CollegeApplicationInfo;
import com.Gaokao.entity.CollegePlanInfo;
import com.Gaokao.service.CollegeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CollegeApplicationServiceImpl implements CollegeApplicationService {
    @Autowired
    private CollegePlanMapper collegePlanMapper;
    @Autowired
    private CollegeApplicationMapper collegeApplicationMapper;

    @Override
    public boolean addApplication(int zsid,int uid) {
        CollegePlanInfo collegePlanInfo = collegePlanMapper.getPlanById(zsid);
        int px = collegeApplicationMapper.getApplicationRank();
        px = px==0?1:px+1;
        collegeApplicationMapper.addApplication(collegePlanInfo.getZsId(),uid,px);
        return true;
    }

    @Override
    public boolean deleteApplication(int zsid,int uid) {
        collegeApplicationMapper.deleteApplication(zsid,uid);
        return true;
    }

    @Override
    public List getApplicationByUid(int uid) {
        return collegeApplicationMapper.getApplicationByUid(uid);
    }

    @Override
    public List getApplicationAllByUid(int uid) {
        return collegeApplicationMapper.getApplicationAllByUid(uid);
    }

    @Override
    public boolean updateApplicationRank(String code,int zsid, int uid) {
      CollegeApplicationInfo rank = collegeApplicationMapper.getRankClose(code,zsid,uid);
      CollegeApplicationInfo co= collegeApplicationMapper.getAppInfo(zsid,uid);
      int pxTemp;
      if(rank!=null){
          pxTemp = co.getPx();
          collegeApplicationMapper.updateApplicationRank(rank.getPx(),co.getZsid(),co.getUid());
          collegeApplicationMapper.updateApplicationRank(pxTemp,rank.getZsid(),rank.getUid());
          return true;
      }
      return false;
    }
}
