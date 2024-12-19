package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
