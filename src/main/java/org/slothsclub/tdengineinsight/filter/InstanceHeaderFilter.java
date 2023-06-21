package org.slothsclub.tdengineinsight.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ErrorCode;
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
            sendError(response, "The required parameter x-instance-id is missing in the header");
            return;
        }

        chain.doFilter(request, response);
    }

    private void sendError(ServletResponse response, String message) throws IOException {
        HttpServletResponse resp = ((HttpServletResponse) response);
        resp.setStatus(HttpStatus.BAD_REQUEST.value());
        resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(new Result(ErrorCode.BAD_REQUEST, message, null)));
    }
}
