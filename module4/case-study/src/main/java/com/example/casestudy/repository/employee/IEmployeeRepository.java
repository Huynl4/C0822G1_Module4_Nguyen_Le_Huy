package com.example.casestudy.repository.employee;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Employee;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM `furama`.employee where name like %:name%  employee.flag_delete = true" , nativeQuery = true)
    Page<Employee> findEmployee(Pageable pageable, String name);
}
