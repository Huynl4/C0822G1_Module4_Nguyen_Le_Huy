package com.example.casestudy.service.impl;

import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.repository.employee.IEmployeeRepository;
import com.example.casestudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findALlEmployee(Pageable pageable, String name) {
        return employeeRepository.findEmployee(pageable,name);
    }
}
