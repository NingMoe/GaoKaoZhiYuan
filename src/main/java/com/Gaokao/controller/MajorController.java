package com.Gaokao.controller;

import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.entity.MajorInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.service.MajorInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorInfoService majorInfoService;

    @RequestMapping("/selectAllMajor")
    @ResponseBody
     public Page selectAllMajor(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                                @RequestParam(value="name", defaultValue="")String majorName,
                                @RequestParam(value="data", defaultValue="")String data){
         List majorInfoList;
        Page pageInfo = new Page();
        
            if (majorName.equals("")) {
                majorInfoList = majorInfoService.getAllMaj();
            } else {
                //模糊查询
                majorInfoList = majorInfoService.getMajorByName(majorName);

            }
       

        pageInfo.setRow(majorInfoList,pageNum);
        List majorInfoPageList=new ArrayList();
        for (int i = pageInfo.getBeginIndex();i<= pageInfo.getEndIndex();i++) {
            MajorInfo maj = (MajorInfo) pageInfo.getRow().get(i);
            if(maj!=null) {
                majorInfoPageList.add(maj);
            }
        }
        pageInfo.setRow(majorInfoPageList);
        return pageInfo;
    }

    @RequestMapping("/addMajorInfo")
    @ResponseBody
    public String addMajorInfo( @RequestParam(value="data", defaultValue="")String data){

        JSONArray json = JSONArray.fromObject(data);
        MajorInfo majorInfo = new MajorInfo();
        Map collegeMap = new HashMap();
        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = json.getJSONObject(i);
                // 得到 每个对象中的属性值
                collegeMap.put(job.get("name"),job.get("value"));
            }
        }
        majorInfo.setId((String) collegeMap.get("id"));
        majorInfo.setName((String) collegeMap.get("name"));
       if( majorInfoService.addMajor(majorInfo)){
           return "success";
       }
        return "false";
    }

    @RequestMapping("/deleteMajorInfo")
    @ResponseBody
    public String deleteMajorInfo(@RequestParam(value="id", defaultValue="1")String id){
        majorInfoService.deleteMajor(id);
        return "success";
    }
}
