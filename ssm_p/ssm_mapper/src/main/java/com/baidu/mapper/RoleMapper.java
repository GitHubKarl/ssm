package com.baidu.mapper;

import com.baidu.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="roleName",property="roleName"),
            @Result(column="roleDesc",property="roleDesc"),
            @Result(column="id",property="permissions",javaType=List.class,
                    many=@Many(select="com.baidu.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String userId);

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll();

    //添加一个角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;
}