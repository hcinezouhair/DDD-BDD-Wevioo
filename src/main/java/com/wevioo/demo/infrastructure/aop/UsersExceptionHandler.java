package com.wevioo.demo.infrastructure.aop;

import com.wevioo.demo.domain.exception.BusinessException;
import com.wevioo.demo.infrastructure.exception.BadDataArgumentException;
import com.wevioo.demo.infrastructure.utils.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class UsersExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ BadDataArgumentException.class })
	protected ResponseEntity<Object> handleBadDataArgumentException(BadDataArgumentException ex, WebRequest request) {
	    log.warn(ex.getMessage(),ex);
		return buildErrorResponse( ex, ex.getCode().name(), ex.getMessage(), HttpStatus.BAD_REQUEST, request );
	}

	@ExceptionHandler({ BusinessException.class })
	protected ResponseEntity<Object> handleBadDataArgumentException(BusinessException ex, WebRequest request) {
		log.warn(ex.getMessage(),ex);
		return buildErrorResponse( ex, ex.getCode().name(), ex.getMessage(), HttpStatus.PRECONDITION_FAILED, request );
	}

	private ResponseEntity<Object> buildErrorResponse(Exception ex, String code, String message, HttpStatus httpStatus, WebRequest request ) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(code);
		errorResponse.setMessage(message);
		errorResponse.setTimeStamp(LocalDateTime.now().toString());
		log.warn(ex.getMessage(),ex);
		return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), httpStatus, request);
	}

}
