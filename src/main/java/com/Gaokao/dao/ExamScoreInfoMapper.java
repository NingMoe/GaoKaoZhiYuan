package com.Gaokao.dao;

import com.Gaokao.entity.ExamScoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamScoreInfoMapper {
    public List getScoreByUid(int uid);
    public int getScoreCidByName(String cname);
    public void addExamScore(@Param(value = "subjectId") int subjectId,
                             @Param(value = "subjectName")String subjectName,
                             @Param(value = "uid")int uid,
                             @Param(value = "score")int score);
}
