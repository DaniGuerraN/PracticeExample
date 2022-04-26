package com.practiceExample.exercise1.repository;

import com.practiceExample.exercise1.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends JpaRepository<Gender,Long> {
}
