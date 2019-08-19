package com.baidu.service;

import com.baidu.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  extends UserDetailsService {
    //查询所有用户
    List<UserInfo> findAll();

    //查询用户详情
    UserInfo findById(String id);

    //添加一个用户
    void save(UserInfo user) throws Exception;

    //给用户分配未拥有的角色
    void addRoleToUser(String[] ids,String userId) throws Exception;
}
