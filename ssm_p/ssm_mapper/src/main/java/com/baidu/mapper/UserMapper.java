package com.baidu.mapper;

import com.baidu.domain.Role;
import com.baidu.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import javax.sound.sampled.Line;
import java.util.List;

public interface UserMapper {

    //根据username查询用户    使用在登录
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.baidu.mapper.RoleMapper.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    //查询所有用户的信息
    @Select("select * from users")
    List<UserInfo> findAll();

    //查询用户详情
    @Select("select * from users where id =#{userid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,
                                many = @Many(select = "com.baidu.mapper.RoleMapper.findRoleByUserId"))
    })
    UserInfo findById(String userid);


    //添加一个用户
    @Insert("insert into users(email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    //为一个用户添加角色
    @Insert("insert into users_role(roleId,userId) values(#{roleId},#{userId})")
    void addRoleToUser(@Param("roleId") String roleId, @Param("userId") String userId) throws Exception;
}
