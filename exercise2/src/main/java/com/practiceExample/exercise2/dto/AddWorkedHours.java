package com.practiceExample.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddWorkedHours {

    private Long employeeId;
    private int workedHours;
    private Date workedDate;
}
