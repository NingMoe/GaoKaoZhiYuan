package com.Gaokao.controller;

import com.Gaokao.service.CollegeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeInfoService collegeInfoService;

    @RequestMapping("/selectAllCollege")
    @ResponseBody
    public List selectAllCollege(Model model){
        List collegeList = collegeInfoService.getAllCollege();
       // model.addAttribute("collegeList",collegeList);
        return collegeList;
    }
}
