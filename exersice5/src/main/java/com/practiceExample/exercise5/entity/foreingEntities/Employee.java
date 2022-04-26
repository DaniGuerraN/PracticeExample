package com.practiceExample.exercise5.entity.foreingEntities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private Gender gender;
    private Job job;
    private String name;
    private String last_name;
    private Date birthdate;

}
