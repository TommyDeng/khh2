package com.tdw.khh2.controller;

import com.tdw.khh2.common.RestReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常用注解
 * /**
 *  @Api：修饰整个类，描述Controller的作用
 *  @ApiOperation：描述一个类的一个方法，或者说一个接口
 *  @ApiParam：单个参数描述
 *  @ApiModel：用对象来接收参数
 *  @ApiProperty：用对象接收参数时，描述对象的一个字段
 *  @ApiResponse：HTTP响应其中1个描述
 *  @ApiResponses：HTTP响应整体描述
 *  @ApiIgnore：使用该注解忽略这个API
 *  @ApiError ：发生错误返回的信息
 *  @ApiImplicitParam：一个请求参数
 *  @ApiImplicitParams：多个请求参数
 *
 */

@Api(tags = "1.公共服务")
@RestController
public class CommonCtl {

    @ApiOperation("服务器状态")
    @GetMapping("/")
    public RestReply index(){
        return RestReply.ok(
                "Server OK!");
    }

}
