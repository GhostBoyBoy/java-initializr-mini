package com.mishu.java.initializr.web.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Before doFilter Request!");
        chain.doFilter(request, response);
        log.info("After doFilter Response!");
    }

}
