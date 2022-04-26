package com.practiceExample.exercise2.repository;

import com.practiceExample.exercise2.entity.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHours, Long> {

    @Query(value = "SELECT * FROM employee_worked_hours where employee_id = :id AND worked_date = :date",
            nativeQuery = true)
    Optional<EmployeeWorkedHours> findEmployeeWorkedHoursByEmployeeIdAndWorkedDate(@Param("id") Long id, @Param("date") String date);

    @Query(value = "Select sum(worked_hours) from employee_worked_hours where employee_id = :employeeId AND worked_date >= :start_date AND worked_date <= :end_date",
            nativeQuery = true)
    Integer totalHoursByDates(@Param("employeeId") Long employeeId, @Param("start_date") String start_date, @Param("end_date") String end_date);

    @Query(value = "Select sum(employee_worked_hours.worked_hours)*jobs.salary  from employee_worked_hours INNER JOIN employees ON employees.id = employee_worked_hours.employee_id INNER JOIN jobs ON employees.job_id = jobs.id where employee_id = :employeeId AND worked_date >= :start_date AND worked_date <= :end_date",
            nativeQuery = true)
    Integer totalPaymentHours(@Param("employeeId") Long employeeId, @Param("start_date") String start_date, @Param("end_date") String end_date);


}
