package com.baidu.controller;

import com.baidu.domain.Permission;
import com.baidu.domain.Role;
import com.baidu.domain.UserInfo;
import com.baidu.service.PermissionSrvice;
import com.baidu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleControlller {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionSrvice permissionSrvice;

    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<Role> role = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", role);
        mv.setViewName("role-list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //晚点在写
    //查询角色详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(String roleId){
        Role role = roleService.findById(roleId);
        ModelAndView mv=new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("");
        return mv;
    }


    //展示一个角色未拥有的资源权限
    @RequestMapping("/findRoleByIdAndAllpermission.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> permissionList = permissionSrvice.findOtherPermission(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色分配未拥有的资源权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String[] ids,String roleId) throws Exception{
        roleService.addPermissionToRole(ids,roleId);
        return "redirect:findAll.do";
    }
}


