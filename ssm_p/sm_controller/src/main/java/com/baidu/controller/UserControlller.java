package com.baidu.controller;

import com.baidu.domain.UserInfo;
import com.baidu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserService userService;

    //查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<UserInfo> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    //查询用户详情
    @RequestMapping("findById")
    public ModelAndView findById(String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }
}


