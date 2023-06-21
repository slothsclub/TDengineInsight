package org.slothsclub.tdengineinsight.filter;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ResponseCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        log.error("Error: " + ex);
        return new ResponseEntity<>(new Result<String>(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result<String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
        return Result.fail(HttpStatus.NOT_FOUND.name(), String.format("%s Not Found", request.getContextPath()));
    }
}
