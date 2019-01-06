package com.springboot.proj.bootframe.dao.implementation;

import com.springboot.proj.bootframe.dao.interfaces.EmployeeDAOInterface;
import com.springboot.proj.bootframe.entites.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class EmployeeDao implements EmployeeDAOInterface {

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {

        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> result = query.getResultList();
        return result;
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, employeeId);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(employee);
    }
}
