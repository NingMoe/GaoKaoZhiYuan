package com.gaokao.service;

import java.util.List;

public interface CollegeApplicationService {
    //添加志愿
    public boolean addApplication(int zsid,int uid);
    //删除志愿
    public boolean deleteApplication(int zsid,int uid);
    public List getApplicationByUid(int uid);
    //根据用户id获得所有志愿
    public List getApplicationAllByUid(int uid);

    /**更新志愿排序
     *
     * @param code  (上移or下移操作)
     * @param zsid （招生计划id）
     * @param uid  （用户id）
     * @return
     */
    public boolean updateApplicationRank(String code,int zsid,int uid);
}
