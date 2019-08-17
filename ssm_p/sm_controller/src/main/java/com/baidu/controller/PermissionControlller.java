package com.baidu.controller;



import com.baidu.domain.Permission;
import com.baidu.service.PermissionSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionControlller {

    @Autowired
    private PermissionSrvice permissionSrvice;

    //查询所有权限
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<Permission> permission = permissionSrvice.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList", permission);
        mv.setViewName("permission-list");
        return mv;
    }

    //添加权限
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionSrvice.save(permission);
        return "redirect:findAll.do";
    }
}


