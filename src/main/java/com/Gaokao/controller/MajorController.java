package com.Gaokao.controller;

import com.Gaokao.entity.CollegeInfo;
import com.Gaokao.entity.MajorInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.service.MajorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
}
