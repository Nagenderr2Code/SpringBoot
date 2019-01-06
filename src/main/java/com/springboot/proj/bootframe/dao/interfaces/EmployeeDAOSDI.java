package com.springboot.proj.bootframe.dao.interfaces;

import com.springboot.proj.bootframe.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAOSDI extends JpaRepository<Employee, Integer> {
}
