package com.Clase14_Clase.dao;

public interface IDao <T>{
    public T guardar(T t);
    public T buscar(Long id);
}
