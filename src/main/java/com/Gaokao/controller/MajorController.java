package com.Gaokao.controller;

import com.Gaokao.entity.MajorInfo;
import com.Gaokao.service.MajorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorInfoService majorInfoService;

    @RequestMapping("/selectAllMajor")
    @ResponseBody
     public List selectAllMajor(Model model){
        List majorList = majorInfoService.getAllMaj();
        //model.addAttribute("majorList",majorList);
        return majorList;
     }
}
