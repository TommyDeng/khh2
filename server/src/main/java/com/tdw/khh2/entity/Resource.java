package com.tdw.khh2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
@Data
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer seq;    //排序
    private String name;    //资源名字
    private String type;    //资源类型
    private String content;    //资源内容
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
