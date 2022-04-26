package com.practiceExample.exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkedHoursDTO {

    private Long employee_id;
    private String start_date;
    private String end_date;
}
