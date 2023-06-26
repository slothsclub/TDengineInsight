package org.slothsclub.tdengineinsight.filter;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ResponseCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.exception.DataSourceNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Locale;
import java.util.stream.Collectors;


@ControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        log.error("Error: " + ex);
        return new ResponseEntity<>(new Result<String>(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result<String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
        return Result.fail(ResponseCode.NOT_FOUND, String.format("%s Not Found", request.getContextPath()));
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    protected Result<String> handleMethodArgNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return Result.fail(ResponseCode.UNPROCESSABLE_ENTITY, errorMessage);
    }

    @ExceptionHandler(DataSourceNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected Result<String> handleDataSourceNotFoundException(RuntimeException ex, WebRequest request) {
        return Result.fail(ResponseCode.DATASOURCE_NOT_FOUND, ex.getMessage());
    }
}
