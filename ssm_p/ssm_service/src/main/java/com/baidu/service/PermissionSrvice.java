package com.baidu.service;


import com.baidu.domain.Permission;

import java.util.List;

public interface PermissionSrvice {
    List<Permission> findAll();
    void save(Permission permission) throws Exception;
}
