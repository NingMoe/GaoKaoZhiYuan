package com.Gaokao.controller;

import com.Gaokao.entity.ExamScoreInfo;
import com.Gaokao.entity.Page;
import com.Gaokao.entity.UserBaseInfo;
import com.Gaokao.service.UserInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/changeInfo")
    public String changeInfo(String loginName, String passwd, HttpSession session){
        UserBaseInfo userBaseInfo = (UserBaseInfo) session.getAttribute("user");
        int id = userBaseInfo.getId();
        int flag = userInfoService.updateUserInfo(id,loginName,passwd);
        if(flag>0){
            userBaseInfo = userInfoService.getUserById(id);
        }
        session.setAttribute("user",userBaseInfo);
        return "changeInfo";
    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserBaseInfo getUserInfo(HttpSession session){
        UserBaseInfo userBaseInfo = (UserBaseInfo) session.getAttribute("user");
        return userBaseInfo;
    }
    @RequestMapping("/getAllUserInfo")
    @ResponseBody
    public Page getAllUserInfo(@RequestParam(value="pageNum", defaultValue="1")int pageNum,
                               @RequestParam(value="name", defaultValue="")String name,
                               @RequestParam(value="data", defaultValue="")String data){
        Page pageInfo = new Page();
       List<UserBaseInfo> userList = userInfoService.getAllUser();
        pageInfo.setRow(userList,pageNum);
        List userPageList=new ArrayList();
        for (int i = pageInfo.getBeginIndex();i<= pageInfo.getEndIndex();i++) {
            UserBaseInfo user = (UserBaseInfo) pageInfo.getRow().get(i);
            if(user!=null) {
                userPageList.add(user);
            }
        }
        pageInfo.setRow(userPageList);
        return pageInfo;
    }

    @RequestMapping("/addUserInfo")
    @ResponseBody
    public String addUserInfo( @RequestParam(value="data", defaultValue="")String data){

        //注意前端要保证分数非空，必修和选考分数不能为空
        JSONArray json = JSONArray.fromObject(data);
        List<ExamScoreInfo> examScoreInfoList = new ArrayList<>();
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        Map userMap = new HashMap();
        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = json.getJSONObject(i);
                // 得到 每个对象中的属性值
                userMap.put(job.get("name"),job.get("value"));
            }
        }
        ExamScoreInfo examMathScoreInfo = new ExamScoreInfo();
        examMathScoreInfo.setSubjectName("数学");
        examMathScoreInfo.setScore(Integer.parseInt((String) userMap.get("mathScore")));
        examScoreInfoList.add(examMathScoreInfo);
        ExamScoreInfo examChineseScoreInfo = new ExamScoreInfo();
        examChineseScoreInfo.setSubjectName("语文");
        examChineseScoreInfo.setScore(Integer.parseInt((String) userMap.get("chineseScore")));
        examScoreInfoList.add(examChineseScoreInfo);
        ExamScoreInfo examEnglishScoreInfo = new ExamScoreInfo();
        examEnglishScoreInfo.setSubjectName("英语");
        examEnglishScoreInfo.setScore(Integer.parseInt((String) userMap.get("englishScore")));
        examScoreInfoList.add(examEnglishScoreInfo);
        for(int i = 1;i <= 3;i++){
            ExamScoreInfo examScoreXkInfo = new ExamScoreInfo();
            String subName = "rankSelect"+i;
            String score = "xkkmScore"+i;
            examScoreXkInfo.setSubjectName((String) userMap.get(subName));
            examScoreXkInfo.setScore(Integer.parseInt((String) userMap.get(score)));
            examScoreInfoList.add(examScoreXkInfo);
        }
        userBaseInfo.setPhone((String) userMap.get("phone"));
        userBaseInfo.setAddress((String) userMap.get("address"));
        userBaseInfo.setRealName((String) userMap.get("realName"));
        userBaseInfo.setLoginName((String) userMap.get("loginName"));
        userBaseInfo.setPasswd((String) userMap.get("passwd"));
        userBaseInfo.setScoreList(examScoreInfoList);
        userInfoService.addUser(userBaseInfo);
        return "success";
    }

    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    public String deleteUserInfo(@RequestParam(value="id", defaultValue="1")int id){
        userInfoService.deleteUser(id);
        return "success";
    }
}
