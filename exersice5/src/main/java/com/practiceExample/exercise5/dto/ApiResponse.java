package com.practiceExample.exercise5.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ApiResponse implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 1502985894618120340L;

    @JsonProperty("success")
    private Boolean success;


    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(Boolean success) {
        this.success = success;
    }

    public ApiResponse(Boolean success, HttpStatus httpStatus) {
        this.success = success;
        this.status = httpStatus;
    }
}
