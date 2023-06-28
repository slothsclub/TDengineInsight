package org.slothsclub.tdengineinsight.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ResponseCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;


@Slf4j
public class InstanceHeaderFilter implements Filter {
    private ObjectMapper objectMapper;

    @Override
    public void init(FilterConfig filterConfig) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String instanceId = httpRequest.getHeader("x-instance-id");
        if (instanceId == null || instanceId.equals("")) {
            request.getRequestDispatcher("/error/invalid-instance").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
