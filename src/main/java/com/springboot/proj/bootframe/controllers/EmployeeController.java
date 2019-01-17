package com.springboot.proj.bootframe.controllers;


import com.springboot.proj.bootframe.entites.Employee;
import com.springboot.proj.bootframe.services.interfaces.EmployeeServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Api(value = "Employee Controller", description = "Has following services. Add, Delete, FindAll, Delete")
public class EmployeeController {

    private EmployeeServiceInterface employeeService;

    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listAll")
    private List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{employeeId}")
    @ApiOperation(position = 2, notes = "Find Employee By ID", value = "./findEmployeeById")
    private Employee findEmployeeById(@PathVariable int employeeId){
        return employeeService.findEmployeeById(employeeId);
    }

    @PostMapping("/addEmployee")
    private Employee add(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PostMapping("/update")
    private Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete")
    private String delete(@RequestBody Employee employee){
        employeeService.delete(employee);
        return "Deleted Employee";
    }
}
