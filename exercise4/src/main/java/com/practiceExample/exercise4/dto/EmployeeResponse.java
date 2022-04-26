package com.practiceExample.exercise4.dto;


import com.practiceExample.exercise4.entity.foreingEntities.Employee;
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
