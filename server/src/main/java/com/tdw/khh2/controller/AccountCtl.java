package com.tdw.khh2.controller;

import com.tdw.khh2.common.RestReply;
import com.tdw.khh2.service.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountCtl {
    @Autowired
    AccountService accountService;

    @ApiOperation("获取所有账户列表信息")
    @GetMapping("/accounts")
    public RestReply accounts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return RestReply.success(accountService.findAccounts(PageRequest.of(page, size)));
    }

    @ApiOperation("获取账户信息")
    @GetMapping({"/account/{id}"})
    public RestReply account(@PathVariable String id) {
        return RestReply.success(accountService.findAccountById(id));
    }

//    @ApiOperation("创建账户信息")
//    @PutMapping({"/account"})
//    public RestReply accountCreate() {
//        return RestReply.success(accountService.findAccountById(id));
//    }

}
