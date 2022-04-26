package com.practiceExample.exercise2.dto;

import com.practiceExample.exercise2.entity.ForeingEntities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private Employee employee;
    private boolean success;


}
