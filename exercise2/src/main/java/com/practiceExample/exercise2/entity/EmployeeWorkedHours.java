package com.practiceExample.exercise2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_worked_hours", uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id", "worked_date"})})
public class EmployeeWorkedHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;
    @Column(name = "worked_hours", nullable = false)
    private int workedHours;
    @Column(name = "worked_date", columnDefinition = "DATE", nullable = false)
    private Date workedDate;
}
