package com.telefonica.jee.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telefonica.jee.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	 List<Employee> findByLastName(String lastName);
	 
	 Employee findByFirstNameAndLastName(String firstName, String lastName);
	 
	 List<Employee> findByFirstNameIn(Collection<String> names);
	 
	 @Query(value = "SELECT e FROM Employee e WHERE e.firstName IN :names")
	 List<Employee> findByNameList(@Param("names") List<String> names);
	 
	 
}
