package com.baidu.service.impl;

import com.baidu.domain.Role;
import com.baidu.mapper.RoleMapper;
import com.baidu.service.RoleSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleSrviceImpl implements RoleSrvice {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) throws Exception{
        roleMapper.save(role);
    }
}
