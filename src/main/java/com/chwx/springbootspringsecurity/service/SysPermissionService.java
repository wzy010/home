package com.chwx.springbootspringsecurity.service;

import com.chwx.springbootspringsecurity.pojo.SysPermission;
import com.chwx.springbootspringsecurity.dao.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZY Wei
 * @date 2018/11/20 16:50
 */
@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 获取指定角色所有权限
     * @param roleId
     * @return
     */
    public List<SysPermission> listByRoleId(Integer roleId){
        return sysPermissionMapper.listByRoleId(roleId);
    }
}
