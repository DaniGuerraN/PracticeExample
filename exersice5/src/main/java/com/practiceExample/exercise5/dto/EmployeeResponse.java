package com.practiceExample.exercise5.dto;


import com.practiceExample.exercise5.entity.foreingEntities.Employee;
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
