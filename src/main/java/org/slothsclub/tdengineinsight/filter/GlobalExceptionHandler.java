package org.slothsclub.tdengineinsight.filter;

import lombok.extern.slf4j.Slf4j;
import org.slothsclub.tdengineinsight.bind.ErrorCode;
import org.slothsclub.tdengineinsight.bind.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        log.error("Error: " + ex);
        return new ResponseEntity<>(new Result(ErrorCode.INTERNAL_SERVER_ERROR, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
