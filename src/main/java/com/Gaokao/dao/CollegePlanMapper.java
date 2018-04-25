package com.Gaokao.dao;

import java.util.List;

public interface CollegePlanMapper {
    public List getAllCollegePlan();
    public List getPlanByCollegeName(String collegeName);
    public List getCollegeRankByType(String type);
    public List getAllPlan(String collegeName,String type);
}
