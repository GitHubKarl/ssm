package com.baidu.service;

import com.baidu.domain.Role;

import java.util.List;

public interface RoleSrvice {
    List<Role> findAll();
    void save(Role role) throws Exception;
}
