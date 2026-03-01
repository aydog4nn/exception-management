package com.ahmetaydo.handler;

import com.ahmetaydo.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handlerBaseException(BaseException exception, WebRequest request) throws UnknownHostException {
        return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
    }

    private String getHostName() throws UnknownHostException {
        try {
            return InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException e){
            System.out.println("Hata Oluştu" + e.getMessage());
        }

        return null;
    }


    public <E> ApiError<E> createApiError(E message,WebRequest request) throws UnknownHostException {

        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());

        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false));
        exception.setMessage(message);

        apiError.setException(exception);

        return apiError;






    }

}
