package com.baidu.service.impl;

import com.baidu.domain.Role;
import com.baidu.domain.UserInfo;
import com.baidu.mapper.UserMapper;
import com.baidu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder pe;

    //添加一个用户  这里面进行了加密
    @Override
    public void save(UserInfo userInfo) throws Exception{
        userInfo.setPassword(pe.encode(userInfo.getPassword()));
        userMapper.save(userInfo);
    }

    //查询用户详情
    @Override
    public UserInfo findById(String id) {
        return userMapper.findById(id);
    }

    //查询所有用户
    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    //登录时通过username验证
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo= userMapper.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;
    }


    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    //给用户分配未拥有的角色
    public void addRoleToUser(String[] ids, String userId) throws Exception{

        for (String roleId : ids) {
            userMapper.addRoleToUser(roleId,userId);
        }
    }

}
