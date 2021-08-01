package com.tdw.khh2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;    //角色名字

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
