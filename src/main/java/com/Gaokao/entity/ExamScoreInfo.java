package com.Gaokao.entity;

/**
 * 高考各科成绩实体类
 */
public class ExamScoreInfo {
    private int subjectId;
    private String subjectName;
    private int score;

    public ExamScoreInfo() {
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
