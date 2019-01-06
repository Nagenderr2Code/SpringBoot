package com.springboot.proj.bootframe.services.interfaces;

import com.springboot.proj.bootframe.entites.Employee;

import java.util.List;


public interface EmployeeServiceInterface {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(int employeeId);
    Employee save(Employee employee);
    void delete(Employee employee);
}
