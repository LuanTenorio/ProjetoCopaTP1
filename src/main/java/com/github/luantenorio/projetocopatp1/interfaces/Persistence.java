package com.github.luantenorio.projetocopatp1.interfaces;

import java.util.List;
import java.util.UUID;

public interface Persistence<T> {
    public T create(T entity);
    public List<T> findAll();
    public T find(UUID id);
    public boolean update(T entity);
    public boolean delete(UUID id);
}
