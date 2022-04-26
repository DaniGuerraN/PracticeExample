package com.practiceExample.exercise1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeCreateOrUpdateDTO {


    private Long id;
    private Long gender_id;
    private Long job_id;
    private String name;
    private String last_name;
    private Date birthdate;

}
