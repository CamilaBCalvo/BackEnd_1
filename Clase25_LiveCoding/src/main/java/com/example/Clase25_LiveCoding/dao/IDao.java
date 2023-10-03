package com.example.Clase25_LiveCoding.dao;

public interface IDao <T>{
    public T guardar(T t);
    public T buscar(Long id);
}
