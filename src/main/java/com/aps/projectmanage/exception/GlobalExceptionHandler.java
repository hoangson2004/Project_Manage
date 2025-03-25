package com.aps.projectmanage.exception;

import com.aps.projectmanage.domain.constant.StatusCode;
import com.aps.projectmanage.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<Object> handleUnknownHostException(UnknownHostException ex) {
        log.error("UnknownHostException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.NOT_FOUND.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //404
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        log.error("NotFoundException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.NOT_FOUND.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.error("BadRequestException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.BAD_REQUEST.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //401
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        log.error("UnauthorizedException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.UNAUTHORIZED.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //403
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity<Object> handleForbiddenException(HttpClientErrorException.Forbidden ex) {
        log.error("ForbiddenException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.FORBIDDEN.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //409
    @ExceptionHandler(HttpClientErrorException.Conflict.class)
    public ResponseEntity<Object> handleConflictException(HttpClientErrorException.Conflict ex) {
        log.error("ConflictException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.CONFLICT.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }

    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                StatusCode.INTERNAL_SERVER_ERROR.getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
    }
}