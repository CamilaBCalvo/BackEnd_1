package com.example.Clase25_LiveCoding.dao;


import com.example.Clase25_LiveCoding.db.DB;
import com.example.Clase25_LiveCoding.model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class MedicamentoDAO_h2 implements IDao<Medicamento>{
    public MedicamentoDAO_h2(ConfiguracionJDBC configuracionJDBC) {
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS (NOMBRE , LABORATORIO ,CANTIDAD , PRECIO) VALUES" +
                    "(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getLaboratorio());
            preparedStatement.setInt(3, medicamento.getCantidad());
            preparedStatement.setDouble(4, medicamento.getPrecio());
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;

        try {
            connection= DB.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID=?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                medicamento = new Medicamento(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return medicamento;
    }
}

