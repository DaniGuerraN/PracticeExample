package com.practiceExample.exercise5.entity.foreingEntities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkedHours {

    private Long id;
    private Long employeeId;
    private int workedHours;
    private Date workedDate;
}
