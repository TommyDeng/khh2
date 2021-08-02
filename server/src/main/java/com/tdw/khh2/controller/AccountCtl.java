package com.tdw.khh2.controller;

import com.tdw.khh2.common.RestReply;
import com.tdw.khh2.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@Api(tags = "2.账号服务")
@RestController
public class AccountCtl {
    @Autowired
    AccountService accountService;

    @ApiOperation("获取所有账户列表")
    @GetMapping("/accounts")
    public RestReply accounts(Pageable pageable) {
        log.info(pageable.toString());
        return RestReply.ok(accountService.findAccounts(pageable));
    }

    @ApiOperation("获取账户信息")
    @GetMapping({"/account/{id}"})
    public RestReply account(@PathVariable String id) {
        return RestReply.ok(accountService.findAccountById(id));
    }

    @ApiOperation("创建账户信息")
    @PutMapping({"/account"})
    public RestReply accountCreate() {
        return RestReply.ok();
    }

}
