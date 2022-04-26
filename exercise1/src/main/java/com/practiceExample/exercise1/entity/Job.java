package com.practiceExample.exercise1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

import static com.practiceExample.exercise1.utils.AppConstants.SALARYERROR;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "salary", nullable = false)
    @Size(min = 2, max = 9, message = SALARYERROR)
    private double salary;

    @OneToMany(mappedBy = "job", targetEntity = Employee.class)
    @JsonBackReference
    private List<Employee> employees;

}
