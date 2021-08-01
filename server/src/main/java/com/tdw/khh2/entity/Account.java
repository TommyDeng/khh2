package com.tdw.khh2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Table
@Entity
@Data
public class Account extends EntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;    //名字
    private String wxCode;  //微信号
    private String email;   //邮箱
    @JsonIgnore
    private String passwdEncrypt;   //加密后的密码
    private Long roleId;    //角色id
    private LocalDate registryDate; //注册日期
    private LocalDateTime latestLoginTime;//最近登陆时间
    private Boolean enable;

}
