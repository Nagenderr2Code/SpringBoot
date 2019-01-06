package com.springboot.proj.bootframe.services.implementation;

import com.springboot.proj.bootframe.dao.interfaces.EmployeeDAOInterface;
import com.springboot.proj.bootframe.entites.Employee;
import com.springboot.proj.bootframe.services.interfaces.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeDAOInterface employeeDAO;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeDAO.findEmployeeById(employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }
}
