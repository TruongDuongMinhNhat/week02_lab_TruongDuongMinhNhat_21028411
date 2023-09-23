package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.enums.EmployeeStatus;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.Employee;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements IRepositories<Employee> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean add(Employee employee) {
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Employee employee) {
        try {
            transaction.begin();
            Employee target = entityManager.find(Employee.class, employee.getId());
            target.setFullName(employee.getFullName());
            target.setPhone(employee.getPhone());
            target.setEmail(employee.getEmail());
            target.setDob(employee.getDob());
            target.setAddress(employee.getAddress());
            target.setStatus(employee.getStatus());
            entityManager.merge(target);
            transaction.commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Employee employee) {
        try {
            transaction.begin();
            Employee target = entityManager.find(Employee.class, employee.getId());
            target.setStatus(EmployeeStatus.TERMINATE);
            entityManager.merge(target);
            transaction.commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Optional<Employee> findById(String id) {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByID", Employee.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
