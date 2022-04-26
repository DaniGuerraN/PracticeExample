package com.practiceExample.exercise3.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.practiceExample.exercise3.dto.ApiResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@JsonPropertyOrder({
        "message",
        "success"
})
@Data
@NoArgsConstructor
public class ErrorResponse extends ApiResponse {

    @JsonProperty("message")
    private String message;


    public ErrorResponse(Boolean success, String message) {
        super(success);
        this.message = message;
    }

    public ErrorResponse(Boolean success, HttpStatus httpStatus, String message) {
        super(success, httpStatus);
        this.message = message;
    }
}
