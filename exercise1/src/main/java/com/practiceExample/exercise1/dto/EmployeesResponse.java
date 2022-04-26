package com.practiceExample.exercise1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.practiceExample.exercise1.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonPropertyOrder({
        "employees",
        "success"
})
@Getter
@Setter
@NoArgsConstructor
public class EmployeesResponse extends ApiResponse {
    @JsonProperty("employees")
    private List<Employee> employees;

    public EmployeesResponse(Boolean success, List<Employee> employees) {
        super(success);
        this.employees = employees;
    }
}
