package com.intellect.intellectcurd.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.intellect.intellectcurd.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);
}
