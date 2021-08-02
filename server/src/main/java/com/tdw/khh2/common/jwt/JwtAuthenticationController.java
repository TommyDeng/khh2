package com.tdw.khh2.common.jwt;

import com.tdw.khh2.common.JwtRequest;
import com.tdw.khh2.common.RestReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "0.Jon Web Token")
@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @ApiOperation("获取token")
    @PostMapping("/token")
    public RestReply generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {
        // Objects.requireNonNull(authenticationRequest.getUsername());
        // Objects.requireNonNull(authenticationRequest.getPassword());
        //验证用户名密码
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        //授权
        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return RestReply.ok(token);
    }
}