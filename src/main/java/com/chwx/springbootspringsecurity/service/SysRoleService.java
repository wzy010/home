package com.chwx.springbootspringsecurity.service;

import com.chwx.springbootspringsecurity.dao.SysRoleMapper;
import com.chwx.springbootspringsecurity.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    public SysRole selectById(Integer id){
        return sysRoleMapper.selectById(id);
    }
}
