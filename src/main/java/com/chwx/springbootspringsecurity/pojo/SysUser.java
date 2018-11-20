package com.chwx.springbootspringsecurity.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="sys_user")
public class SysUser implements Serializable {

    @Id
    private Integer id;
    private String name;
    private String password;
}
