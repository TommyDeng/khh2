package com.tdw.khh2.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntityBase {
    protected LocalDateTime createTime;
    private LocalDateTime updateTime;
}
