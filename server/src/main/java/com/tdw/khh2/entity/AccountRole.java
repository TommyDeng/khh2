package com.tdw.khh2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
@Data
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String accountId;
    private String roleId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
