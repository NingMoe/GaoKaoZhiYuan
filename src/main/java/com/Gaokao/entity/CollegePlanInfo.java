package com.Gaokao.entity;

/**
 * 招生计划实体类
 */
public class CollegePlanInfo {
    private int zsId;
    private String collegeId;
    private String collegeName;
    private String sf;
    private String majorId;
    private String majorName;
    private String xkkm1;
    private String xkkm2;
    private String xkkm3;
    private int pc;
    //计划招生人数
    private int jhzsrs;
    //分数线
    private int scoreLine;
    //位次
    private int num;
    //分差
    private int poor;
    //位次差
    private int dislocation;
    private int totalRecord;


    public CollegePlanInfo() {
    }

    public int getZsId() {
        return zsId;
    }

    public void setZsId(int zsId) {
        this.zsId = zsId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getXkkm1() {
        return xkkm1;
    }

    public void setXkkm1(String xkkm1) {
        this.xkkm1 = xkkm1;
    }

    public String getXkkm2() {
        return xkkm2;
    }

    public void setXkkm2(String xkkm2) {
        this.xkkm2 = xkkm2;
    }

    public String getXkkm3() {
        return xkkm3;
    }

    public void setXkkm3(String xkkm3) {
        this.xkkm3 = xkkm3;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public int getJhzsrs() {
        return jhzsrs;
    }

    public void setJhzsrs(int jhzsrs) {
        this.jhzsrs = jhzsrs;
    }

    public int getScoreLine() {
        return scoreLine;
    }

    public void setScoreLine(int scoreLine) {
        this.scoreLine = scoreLine;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPoor() {
        return poor;
    }

    public void setPoor(int poor) {
        this.poor = poor;
    }

    public int getDislocation() {
        return dislocation;
    }

    public void setDislocation(int dislocation) {
        this.dislocation = dislocation;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
}
