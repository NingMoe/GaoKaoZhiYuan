package com.Gaokao.entity;

/**
 * 专业实体类
 */
public class MajorInfo {
    private String id;
    private String name;
    private String type;

    public MajorInfo() {
    }

    public MajorInfo(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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
}
