package com.practiceExample.exercise1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.practiceExample.exercise1.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        "employee",
        "success"
})
@Data
@NoArgsConstructor
public class EmployeeResponse extends ApiResponse {

    @JsonProperty("employee")
    private Employee employee;

    public EmployeeResponse(Boolean success, Employee employee) {
        super(success);
        this.employee = employee;
    }

}
