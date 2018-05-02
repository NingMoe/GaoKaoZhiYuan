package com.gaokao.dao;

import com.gaokao.entity.CollegePlanInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegePlanMapper {
    public List getAllCollegePlan();
    public List getPlanByCollegeName(String collegeName);
    //弃用
    public List getCollegeRankByType(String type);
    //弃用
    public List getAllPlan(String collegeName,String type);

    /**
     *
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
                               @Param("pageSize") int pageSize,@Param("offset") int offset);
    public CollegePlanInfo getPlanById(int zsid);
}
