package com.practiceExample.exercise1.repository;

import com.practiceExample.exercise1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findEmployeesByJobId(Long jobId);

}
