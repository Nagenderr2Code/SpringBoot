package com.springboot.proj.bootframe.services.implementation;

import com.springboot.proj.bootframe.dao.interfaces.EmployeeDAOSDI;
import com.springboot.proj.bootframe.entites.Employee;
import com.springboot.proj.bootframe.services.interfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("sdJpa")
public class EmployeeServiceSD implements EmployeeServiceInterface {

    @Autowired
    private EmployeeDAOSDI employeeDAOSDI;

    @Override
    public List<Employee> findAllEmployees() {
        System.out.println("@@@@@@@@@@@@@@@ Service provided from SD JPA @@@@@@@@@@@@@");
        return employeeDAOSDI.findAll();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeDAOSDI.findById(employeeId).get();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAOSDI.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDAOSDI.delete(employee);
    }
}
