package com.example.casestudy.service;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findALlEmployee(Pageable pageable, String name);
}
