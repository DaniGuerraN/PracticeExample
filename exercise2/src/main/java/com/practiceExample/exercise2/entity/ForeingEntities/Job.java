package com.practiceExample.exercise2.entity.ForeingEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private Long id;
    private String name;
    private double salary;
}
