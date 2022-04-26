package com.practiceExample.exercise1.repository;

import com.practiceExample.exercise1.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job,Long> {
}
