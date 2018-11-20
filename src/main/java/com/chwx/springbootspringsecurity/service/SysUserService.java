package com.chwx.springbootspringsecurity.service;

import com.chwx.springbootspringsecurity.dao.SysUserMapper;
import com.chwx.springbootspringsecurity.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser selectById(Integer id){
        return  sysUserMapper.selectById(id);
    }

    public SysUser selectByName(String name){
        return sysUserMapper.selectByName(name);
    }
}
