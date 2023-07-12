package org.slothsclub.tdengineinsight.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.RawSqlResult;
import org.slothsclub.tdengineinsight.bind.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;


@RestControllerAdvice
@Slf4j
public class ResponseBodyFilter implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletServerHttpRequest servletServerRequest = (ServletServerHttpRequest) request;
        Object startAttr = servletServerRequest.getServletRequest().getAttribute("start");
        long startTime = !Objects.isNull(startAttr) ? (long) startAttr : 0;
        long timeElapsed = System.currentTimeMillis() - startTime;
        response.getHeaders().add("Elapsed-Time", String.valueOf(timeElapsed));

        if (!Objects.requireNonNull(returnType.getDeclaringClass()).getName().startsWith("org.slothsclub.tdengineinsight")) {
            return body;
        }
        if (body instanceof String) {
            return objectMapper.writeValueAsString(Result.success(body));
        }
        if (body instanceof Result) {
            if (((Result<?>) body).getPayload() instanceof RawSqlResult) {
                ((RawSqlResult) ((Result<?>) body).getPayload()).setElapsedTime(timeElapsed);
            }
            return body;
        }

        return Result.success(body);
    }
}
