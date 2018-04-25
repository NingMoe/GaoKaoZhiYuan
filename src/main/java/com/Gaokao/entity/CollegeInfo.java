package com.Gaokao.entity;

/**
 * 院校基本信息实体类
 */
public class CollegeInfo {
    private String id;
    private String name;
    private String type;
    private String cc;
    private String sf;
    private String detail;

    public CollegeInfo() {
    }

    public CollegeInfo(String id, String name, String type, String cc, String sf, String detail) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cc = cc;
        this.sf = sf;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
