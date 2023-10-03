package com.example.EntregaFinal_2.dao;

import com.example.EntregaFinal_2.bd.BD;
import com.example.EntregaFinal_2.domain.Odontologo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OdontologoDAOH2 implements IDao<Odontologo>{
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (" +
                            "APELLIDO, NOMBRE, MATRICULA) " +
                            "VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS); // Esto lo agregamos por el autoincrement
            ps.setString(1,odontologo.getApellido());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getMatricula());
            ps.execute();
// Esto lo hacemos por el autoincrement
            ResultSet clave=ps.getGeneratedKeys();
            while (clave.next()){
                odontologo.setId(clave.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        Connection connection = null;
        Odontologo odontologo = null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            };
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement  ps= connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE ODONTOLOGOS SET APELLIDO = ?, " +
                    "NOMBRE = ?, " +
                    "MATRICULA = ?," +
                    "WHERE ID = ?");
            ps.setString(1, odontologo.getApellido());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getMatricula());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                odontologos.add(odontologo);
            };
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

    @Override
    public Odontologo buscarXCriterioString(String criterio) {
        Connection connection=null;
        Odontologo odontologo=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE MATRICULA=?");
            ps.setString(1,criterio);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                odontologo=new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }
}
