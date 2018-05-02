package com.Gaokao.dao;

import com.Gaokao.entity.CollegePlanInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegePlanMapper {
    public List getAllCollegePlan();
    public List getPlanByCollegeName(String collegeName);
    //弃用
    public List getCollegeRankByType(String type);
    //弃用
    public List getAllPlan(String collegeName,String type);
    public List getAllSuitPlan(@Param("xkkm1") String xkkm1,@Param("xkkm2") String xkkm2,@Param("xkkm3") String xkkm3,@Param("bxkm") String bxkm,@Param("collegeName") String collegeName,@Param("type") String type);
    public CollegePlanInfo getPlanById(int zsid);
}
