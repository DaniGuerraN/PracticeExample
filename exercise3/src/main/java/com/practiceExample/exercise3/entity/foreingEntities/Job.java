package com.practiceExample.exercise3.entity.foreingEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private Long id;
    private String name;
    private Double salary;
}
