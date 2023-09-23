package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.impl;

import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.repositories.IRepositories;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.enums.ProductStatus;
import dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ProductRepository implements IRepositories<Product> {

    private EntityManager entityManager;
    private EntityTransaction transaction;
    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        transaction = entityManager.getTransaction();
    }

    @Override
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            Product target = entityManager.find(Product.class, product.getId());
            target.setName(product.getName());
            target.setDescription(product.getDescription());
            target.setUnit(product.getUnit());
            target.setManufaturerName(product.getManufaturerName());
            target.setStatus(product.getStatus());
            entityManager.merge(target);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            Product target = entityManager.find(Product.class, product.getId());
            target.setStatus(ProductStatus.STOP);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Optional<Product> findById(String id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findByID", Product.class);
        query.setParameter("productID", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }
}
