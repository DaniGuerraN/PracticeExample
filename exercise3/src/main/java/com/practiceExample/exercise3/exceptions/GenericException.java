package com.practiceExample.exercise3.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class GenericException extends RuntimeException{

    private ErrorResponse errorResponse;

    private String message;

    public GenericException( String message) {
        this.message = message;
        this.setApiResponse();
    }

    public ErrorResponse getApiResponse() {
        return errorResponse;
    }

    private void setApiResponse() {
        errorResponse = new ErrorResponse(Boolean.FALSE, message);
    }
}
