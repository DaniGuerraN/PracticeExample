package com.practiceExample.exercise1.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "last_name"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Gender.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Job.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "birthdate", columnDefinition = "DATE", nullable = false)
    private Date birthdate;

}
