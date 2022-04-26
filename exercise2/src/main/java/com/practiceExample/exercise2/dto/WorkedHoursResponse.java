package com.practiceExample.exercise2.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
        "total_worked_hours",
        "success"
})
@Getter
@Setter
@NoArgsConstructor
public class WorkedHoursResponse extends ApiResponse {

    private Integer total_worked_hours;

    public WorkedHoursResponse(Boolean success, int total_worked_hours) {
        super(success);
        this.total_worked_hours = total_worked_hours;
    }
}
