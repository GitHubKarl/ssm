package com.baidu.mapper;

import com.baidu.domain.Permission;
import com.baidu.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);

    //查询所有权限
    @Select("select * from permission")
    List<Permission> findAll();

    //添加一个权限
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission)throws Exception;

    //通过一个role的id查询其没有的资源权限
    @Select("Select * from permission where id not in (select permissionId from role_permission where roleId =#{id})")
    List<Permission> findOtherPermission(String id);
}
