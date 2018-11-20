package com.chwx.springbootspringsecurity.common;

import com.chwx.springbootspringsecurity.pojo.SysRole;
import com.chwx.springbootspringsecurity.pojo.SysUser;
import com.chwx.springbootspringsecurity.pojo.SysUserRole;
import com.chwx.springbootspringsecurity.service.SysRoleService;
import com.chwx.springbootspringsecurity.service.SysUserRoleService;
import com.chwx.springbootspringsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //数据库获取用户信息
        SysUser user = userService.selectByName(username);
        //判断用户是否存在
        if (user == null){
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }

        //添加权限
        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (SysUserRole userRole : userRoles){
            SysRole role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //返回UserDeatils实现类
        return new User(user.getName(),user.getPassword(),authorities);
    }
}
