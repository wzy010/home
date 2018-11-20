package com.chwx.springbootspringsecurity.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="sys_user_role")
public class SysUserRole implements Serializable {
    @Column(name="user_id")
    private  Integer userId;
    @Column(name="role_id")
    private Integer roleId;
}
