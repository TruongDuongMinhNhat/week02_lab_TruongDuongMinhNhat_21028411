package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepositories<T> {
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
    Optional<T> findById(String id);
    List<T> findAll();
}
