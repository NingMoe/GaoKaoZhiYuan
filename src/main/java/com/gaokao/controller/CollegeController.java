package com.gaokao.controller;

import com.gaokao.entity.CollegeInfo;
import com.gaokao.entity.Page;
import com.gaokao.service.CollegeInfoService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeInfoService collegeInfoService;

    @RequestMapping("/selectAllCollege")
    @ResponseBody
    public Page selectAllCollege(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                 @RequestParam(value="name", defaultValue="")String collegeName,
                                 @RequestParam(value="data", defaultValue="")String data){
        List collegeInfoList=new ArrayList();
        Page pageInfo = new Page();
        JSONObject jsonObject = JSONObject.fromObject(data);

        if (jsonObject.isEmpty()) {
            if (StringUtils.isBlank(collegeName)) {
                collegeInfoList = collegeInfoService.getAllCollege();

            } else {
                //模糊查询
                collegeInfoList = collegeInfoService.getCollegeByName(collegeName);

            }
        } else {
            String ids =  jsonObject.get("ids")==null?"":(String)jsonObject.get("ids");
            //对比查询
            //删除末尾","
            if (ids.endsWith(",")) {
                ids = ids.substring(0, ids.length() - 1);
            }
            String[] b = ids.split(",");
            for (int i = 0; i < b.length; i++) {
                CollegeInfo collegeInfo = collegeInfoService.getAppById(b[i]);
                collegeInfoList.add(collegeInfo);
            }


        }

        pageInfo.setRow(collegeInfoList,pageNum);
        List collegeInfoPageList=new ArrayList();
        for (int i = pageInfo.getBeginIndex();i<= pageInfo.getEndIndex();i++) {
            CollegeInfo col = (CollegeInfo) pageInfo.getRow().get(i);
            if(col!=null) {
                collegeInfoPageList.add(col);
            }
        }
        pageInfo.setRow(collegeInfoPageList);
        return pageInfo;
    }
}
