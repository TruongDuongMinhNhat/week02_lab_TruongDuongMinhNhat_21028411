package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.backend.services;

import java.util.List;
import java.util.Optional;

public interface Services<T> {
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    Optional<T> findByID(String id);
    List<T> findAll();
}
