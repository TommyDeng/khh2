package com.tdw.khh2.controller;

import com.tdw.khh2.common.RestReply;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonCtl {

    @GetMapping("/")
    public RestReply index(){
        return RestReply.success(
                "Server OK!");
    }

}
