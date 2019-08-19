package com.baidu.controller;

import com.baidu.domain.Role;
import com.baidu.domain.UserInfo;
import com.baidu.service.RoleService;
import com.baidu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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
    @RequestMapping("findById.do")
    @RolesAllowed("aa")
    public ModelAndView findById(String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    //展示用户未拥有的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        UserInfo user = userService.findById(id);
        List<Role> roleList = roleService.findOtherRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    //给用户分配未拥有的角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String[] ids,String userId) throws Exception{
        userService.addRoleToUser(ids,userId);
        return "redirect:findById.do?id="+userId;

    }
}


