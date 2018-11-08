package com.example.interceptor.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SimpleFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SimpleFilter.doFilter");
        System.out.println("Remote Host:" + servletRequest.getRemoteHost());
        System.out.println("Remote Address:" + servletRequest.getRemoteAddr());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.reset();
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

        filterChain.doFilter(servletRequest, response);
    }

    @Override
    public void destroy() {
        System.out.println("SimpleFilter.destroy");
    }
}
