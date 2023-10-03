package com.Clase14_Clase.dao;

import com.Clase14_Clase.db.DB;
import com.Clase14_Clase.model.Medicamento;
import com.Clase14_Video2.entidades.Estudiante;

import java.sql.*;


public class MedicamentoDAO_h2 implements IDao<Medicamento>{
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        Connection connection = null;
        try {
            connection = DB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS (ID, CODE , NOMBRE , LABORATORIO ,CANTIDAD , PRECIO) VALUES" +
                    "(?,?,?,?,?,?)");
            preparedStatement.setInt(1, medicamento.getId());
            preparedStatement.setString(2, medicamento.getCodigo());
            preparedStatement.setString(3, medicamento.getNombre());
            preparedStatement.setString(4, medicamento.getLaboratorio());
            preparedStatement.setInt(5, medicamento.getCantidad());
            preparedStatement.setDouble(6, medicamento.getPrecio());
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

            preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID=?");
            preparedStatement.setLong(1, id);

            ResultSet rs= preparedStatement.executeQuery();

            while (rs.next()){
                int idMedicamento = rs.getInt("ID");
                String codigo = rs.getString("CODE");
                String nombre = rs.getString("NOMBRE");
                String laboratorio = rs.getString("LABORATORIO");
                int cantidad = rs.getInt("CANTIDAD");
                Double precio = rs.getDouble("PRECIO");
                medicamento.setId(idMedicamento);
                medicamento.setCodigo(codigo);
                medicamento.setNombre(nombre);
                medicamento.setLaboratorio(laboratorio);
                medicamento.setCantidad(cantidad);
                medicamento.setPrecio(precio);

            }

            preparedStatement.close();

            //agrego el try-catch porque me tira las dos exceptions
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

