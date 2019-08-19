package com.baidu.service.impl;

import com.baidu.domain.Role;
import com.baidu.mapper.RoleMapper;
import com.baidu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    //查询所有角色
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    //添加一个角色
    @Override
    public void save(Role role) throws Exception{
        roleMapper.save(role);
    }
    //查询一个用户没有的角色
    @Override
    public List<Role> findOtherRole(String userId) {
        return roleMapper.findOtherRole(userId);
    }
    //通过id查询一个角色
    public Role findById(String id){
        return roleMapper.findById(id);
    }

    @Override
    public void addPermissionToRole(String[] ids, String roleId) {
        for (String id : ids) {
            roleMapper.addPermissionToRole(id,roleId);
        }
    }
}
