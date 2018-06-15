package com.Gaokao.dao;

import com.Gaokao.entity.CollegePlanInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegePlanMapper {
    public List getAllCollegePlan();
    public List getPlanByCollegeName(String collegeName);
    //弃用
    public List getCollegeRankByType(String type);

    /**
     * 获得所有招生计划
     * @param collegeName
     * @param majorName
     * @param type
     * @param prior
     * @param pageSize
     * @param offset
     * @return
     */
    public List getAllPlan(@Param("collegeName")String collegeName,@Param("majorName")String majorName,@Param("type")String type,
                           @Param("prior")int prior,@Param("pageSize")int pageSize,@Param("offset")int offset);

    /**
     *考生获得满足条件的招生计划
     * @param xkkm1
     * @param xkkm2
     * @param xkkm3
     * @param bxkm
     * @param collegeName
     * @param type
     * @param pageSize
     * @param offset
     * @return
     */
    public List getAllSuitPlan(@Param("xkkm1") String xkkm1,@Param("xkkm2") String xkkm2,@Param("xkkm3") String xkkm3,
                               @Param("bxkm") String bxkm,@Param("collegeName") String collegeName,@Param("type") String type,
                               @Param("pageSize") int pageSize,@Param("offset") int offset,@Param("totalScore") int totalScore,
                               @Param("majorName") String majorName,@Param("prior") int prior,@Param("area")int area);
    public CollegePlanInfo getPlanById(int zsid);

    public void addPlan(CollegePlanInfo collegePlanInfo);

    public void updatePlan(CollegePlanInfo collegePlanInfo);

    public void deletePlan(int id);
}
