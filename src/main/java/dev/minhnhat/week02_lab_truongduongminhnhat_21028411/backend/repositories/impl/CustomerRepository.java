package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.Customer;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CustomerRepository implements IRepositories<Customer> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean add(Customer customer) {
        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Customer customer) {
        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Customer customer) {
        return false;
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(entityManager.createNamedQuery("Customer.findByID", Customer.class).getSingleResult());
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
