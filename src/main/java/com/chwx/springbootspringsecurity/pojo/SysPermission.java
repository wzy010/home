package com.chwx.springbootspringsecurity.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Table(name = "sys_permission")
@Data
public class SysPermission implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String url;

    @Column(name = "role_id")
    private Integer roleId;

    private String permission;

    @Transient
    private List permissions;

    // 省略除permissions外的getter/setter

    public List<String> getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }
}


