package com.aps.projectmanage.exception;

import com.aps.projectmanage.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<Object> handleUnknownHostException(UnknownHostException ex) {
        log.error("UnknownHostException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    //404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        log.error("NotFoundException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    //400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.error("BadRequestException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    //401
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex) {
        log.error("UnauthorizedException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    //403
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException ex) {
        log.error("ForbiddenException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    //409
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(ConflictException ex) {
        log.error("ConflictException: {}", ex.getMessage(), ex);
        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                ex.getStatus().getStatusCode(),
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    //500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);
        InternalServerException e = new InternalServerException();

        BaseResponse<String> errorResponse = BaseResponse.failedResponse(
                e.getStatus().getStatusCode(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}