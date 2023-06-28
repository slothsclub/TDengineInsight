package org.slothsclub.tdengineinsight.filter;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ResponseCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.slothsclub.tdengineinsight.bind.ValidationErrors;
import org.slothsclub.tdengineinsight.exception.DataSourceNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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
    protected Result<List<ValidationErrors>> handleMethodArgNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        List<ValidationErrors> errors = new ArrayList<>();
        for(FieldError err: ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationErrors(err.getField(), err.getDefaultMessage()));
        }
        return Result.fail(ResponseCode.UNPROCESSABLE_ENTITY, errors.toString(), errors);
    }

    @ExceptionHandler(DataSourceNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected Result<String> handleDataSourceNotFoundException(RuntimeException ex, WebRequest request) {
        return Result.fail(ResponseCode.DATASOURCE_NOT_FOUND, ex.getMessage());
    }
}
