package com.Gaokao.controller;

import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.service.CollegeInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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
    @RequestMapping("/addCollegeInfo")
    @ResponseBody
    public String addCollegeInfo( @RequestParam(value="data", defaultValue="")String data){

        JSONArray json = JSONArray.fromObject(data);
        CollegeInfo collegeInfo = new CollegeInfo();
        Map collegeMap = new HashMap();
        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = json.getJSONObject(i);
                // 得到 每个对象中的属性值
                collegeMap.put(job.get("name"),job.get("value"));
            }
        }
        collegeInfo.setId((String) collegeMap.get("id"));
        collegeInfo.setName((String) collegeMap.get("name"));
        collegeInfo.setSf((String) collegeMap.get("sf"));
        collegeInfo.setDetail((String) collegeMap.get("detail"));
        collegeInfoService.addCollege(collegeInfo);
        return "success";
    }

    @RequestMapping("/deleteCollegeInfo")
    @ResponseBody
    public String deleteCollegeInfo(@RequestParam(value="id", defaultValue="1")String id){
        collegeInfoService.deleteCollege(id);
        return "success";
    }
}
