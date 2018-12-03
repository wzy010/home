package com.chwx.springbootspringsecurity.common;

import com.chwx.springbootspringsecurity.pojo.SysPermission;
import com.chwx.springbootspringsecurity.service.SysPermissionService;
import com.chwx.springbootspringsecurity.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author ZY Wei
 * @date 2018/11/20 16:57
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        //获取loadUserByUsername()方法结果
        User user = (User) authentication.getPrincipal();
        //获取loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        //遍历所有的角色
        for (GrantedAuthority authority : authorities){
            String roleName = authority.getAuthority();
            Integer roleId = sysRoleService.selectByName(roleName);
            //得到角色所有的权限
            List<SysPermission> permissionList = sysPermissionService.listByRoleId(roleId);

            //遍历permissionList
            for(SysPermission sysPermission : permissionList){
                //获取权限集
                List permissions = sysPermission.getPermissions();
                //如果访问的url和权限用户符合的话,返回true
                if(o.equals(sysPermission.getUrl()) && permissions.contains(o1)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
