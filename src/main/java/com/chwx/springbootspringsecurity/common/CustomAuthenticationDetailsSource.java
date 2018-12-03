package com.chwx.springbootspringsecurity.common;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 该接口用户在Sping Security登录过程中对用户信息的详细信息进行填充
 */
@Component
public class CustomAuthenticationDetailsSource implements
        AuthenticationDetailsSource<HttpServletRequest,WebAuthenticationDetails> {

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
        return  new CustomWebAuthenticationDetails(request);
    }
}
