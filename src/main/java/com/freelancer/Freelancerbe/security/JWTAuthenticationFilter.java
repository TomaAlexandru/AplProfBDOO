package com.freelancer.Freelancerbe.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest)request);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        HttpServletResponse rs = (HttpServletResponse) response;

        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")){
            rs.setHeader("Access-Control-Allow-Origin", "*");
            rs.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
            return;
        }

        filterChain.doFilter(request,response);
    }
}