package com.chwx.springbootspringsecurity.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="sys_role")
public class SysRole implements Serializable {
    @Id
    private Integer id;
    private String name;
}
