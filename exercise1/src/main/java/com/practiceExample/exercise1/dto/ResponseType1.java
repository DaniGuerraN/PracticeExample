package com.practiceExample.exercise1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        "id",
        "success"
})
@Data
@NoArgsConstructor
public class ResponseType1 extends ApiResponse {

    @JsonProperty("id")
    private Long id;

    public ResponseType1(Boolean success, Long id) {
        super(success);
        this.id = id;
    }
}
