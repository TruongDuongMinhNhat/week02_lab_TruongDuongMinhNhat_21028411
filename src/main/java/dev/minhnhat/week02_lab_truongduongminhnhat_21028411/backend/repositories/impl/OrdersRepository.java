package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import com.sun.jdi.event.ExceptionEvent;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.Orders;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class OrdersRepository implements IRepositories<Orders> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public OrdersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean add(Orders orders) {
        try {
            transaction.begin();
            entityManager.persist(orders);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Orders orders) {
        return false;
    }

    @Override
    public boolean delete(Orders orders) {
        return false;
    }

    @Override
    public Optional<Orders> findById(String id) {
        TypedQuery<Orders> query = entityManager.createNamedQuery("Orders.findByID", Orders.class);
        query.setParameter("orderID", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Orders> findAll() {
        return entityManager.createNamedQuery("Orders.findAll", Orders.class).getResultList();
    }
}
