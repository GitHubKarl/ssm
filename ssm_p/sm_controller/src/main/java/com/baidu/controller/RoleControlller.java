package com.baidu.controller;

import com.baidu.domain.Role;
import com.baidu.domain.UserInfo;
import com.baidu.service.RoleSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleControlller {

    @Autowired
    private RoleSrvice roleSrvice;

    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<Role> role = roleSrvice.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", role);
        mv.setViewName("role-list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleSrvice.save(role);
        return "redirect:findAll.do";
    }
}


