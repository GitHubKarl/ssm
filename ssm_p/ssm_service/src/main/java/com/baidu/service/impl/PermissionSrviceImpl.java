package com.baidu.service.impl;


import com.baidu.domain.Permission;
import com.baidu.mapper.PermissionMapper;
import com.baidu.mapper.RoleMapper;
import com.baidu.service.PermissionSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionSrviceImpl implements PermissionSrvice {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionMapper.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return permissionMapper.findOtherPermission(id);
    }
}
