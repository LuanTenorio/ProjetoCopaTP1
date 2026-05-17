package com.github.luantenorio.projetocopatp1.interfaces;

import java.util.List;

public interface Persistence<T> {
    public T create(T entity);
    public List<T> findAll();
}
