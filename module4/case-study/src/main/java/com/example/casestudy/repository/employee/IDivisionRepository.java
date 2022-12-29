package com.example.casestudy.repository.employee;

import com.example.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface IDivisionRepository extends JpaRepository<Division, Long> {
}
