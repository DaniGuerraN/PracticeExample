package com.practiceExample.exercise3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.practiceExample.exercise3.entity.foreingEntities.Employee;
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
