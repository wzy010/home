package com.chwx.springbootspringsecurity.service;

import com.chwx.springbootspringsecurity.dao.SysUserRoleMapper;
import com.chwx.springbootspringsecurity.pojo.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId){
        return  sysUserRoleMapper.listByUserId(userId);
    }
}
