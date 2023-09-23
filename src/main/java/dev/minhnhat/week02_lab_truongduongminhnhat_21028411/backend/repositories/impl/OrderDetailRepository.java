package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.OrderDetail;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepository implements IRepositories<OrderDetail> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public OrderDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean add(OrderDetail orderDetail) {
        try {
            transaction.begin();
            entityManager.persist(orderDetail);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public boolean delete(OrderDetail orderDetail) {
        return false;
    }

    @Override
    public Optional<OrderDetail> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<OrderDetail> findAll() {
        return entityManager.createNamedQuery("OrderDetail.findAll", OrderDetail.class).getResultList();
    }
}
