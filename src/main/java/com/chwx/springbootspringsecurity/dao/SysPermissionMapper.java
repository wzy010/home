package com.chwx.springbootspringsecurity.dao;

import com.chwx.springbootspringsecurity.pojo.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZY Wei
 * @date 2018/11/20 16:49
 */
@Mapper
public interface SysPermissionMapper {
    @Select("select * from sys_permission where role_id = #{roleId}")
    List<SysPermission> listByRoleId(Integer roleId);
}
