package com.springboot.proj.bootframe.dao.implementation;

import com.springboot.proj.bootframe.dao.interfaces.EmployeeDAOInterface;
import com.springboot.proj.bootframe.entites.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Profile("jpa")
public class EmployeeDaoJPA implements EmployeeDAOInterface {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDaoJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        System.out.println("@@@@@@@@@@@@@@@ Service provided from JPA @@@@@@@@@@@@@");
        Query query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
