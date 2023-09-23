package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.ProductImage;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ProductImageRepository implements IRepositories<ProductImage> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    public ProductImageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }
    @Override
    public boolean add(ProductImage productImage) {
        try {
            transaction.begin();
            entityManager.persist(productImage);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(ProductImage productImage) {
        return false;
    }

    @Override
    public boolean delete(ProductImage productImage) {
        return false;
    }

    @Override
    public Optional<ProductImage> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<ProductImage> findAll() {
        return entityManager.createNamedQuery("ProductImage.findAll", ProductImage.class).getResultList();
    }
}
