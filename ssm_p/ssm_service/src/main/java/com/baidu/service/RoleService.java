package com.baidu.service;

import com.baidu.domain.Role;

import java.util.List;

public interface RoleService {
    //查询所有角色
    List<Role> findAll();
    //添加一个角色
    void save(Role role) throws Exception;
    //通过userId查询user没有的角色
    List<Role> findOtherRole(String UserId);
    //通过id查询角色
    Role findById(String id);
    //给角色分配未拥有的资源权限
    void addPermissionToRole(String[] ids, String roleId);
}
