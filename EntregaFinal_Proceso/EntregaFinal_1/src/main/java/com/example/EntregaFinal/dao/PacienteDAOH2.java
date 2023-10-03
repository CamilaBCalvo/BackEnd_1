package com.example.EntregaFinal.dao;

import com.example.EntregaFinal.bd.BD;
import com.example.EntregaFinal.domain.Domicilio;
import com.example.EntregaFinal.domain.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;
        try{
            connection = BD.getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            Domicilio domicilio = domicilioDAOH2.guardar(paciente.getDomicilio());
            PreparedStatement ps = connection.prepareStatement("INSERT INTO PACIENTES" +
                    " (APELLIDO, NOMBRE, DOCUMENTO, FECHA_INGRESO, DOMICILIO_ID, EMAIL)" +
                    "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,paciente.getApellido());
            ps.setString(2,paciente.getNombre());
            ps.setString(3,paciente.getDocumento());
            ps.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
// El id del domicilio va a existir una vez que yo guarde al paciente, entonces por eso genero el domicilioDao arriba (linea 17 y 18)
            ps.setInt(5,domicilio.getId());
            ps.setString(6,paciente.getEmail());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
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
        return paciente;
    };

    @Override
    public Paciente buscar(int id) {
        Connection connection = null;
        Paciente paciente = null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(6)),
                        rs.getString(7));
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
        return paciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("DELETE FROM PACIENTES WHERE ID=?");
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
    public Paciente actualizar(Paciente paciente) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE PACIENTES SET " +
                    "APELLIDO = ?, " +
                    "NOMBRE = ?, " +
                    "DOCUMENTO = ?," +
                    "FECHA_INGRESO = ? " +
                    "DOMICLIO_ID = ?," +
                    "EMAIL=?" +
                    "WHERE ID = ?");
            ps.setString(1,paciente.getApellido());
            ps.setString(2,paciente.getNombre());
            ps.setString(3,paciente.getDocumento());
            ps.setDate(4,Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(1,paciente.getDomicilio().getId());
            ps.setString(6,paciente.getEmail());
            ps.setInt(7,paciente.getId());
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
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM PACIENTES");
            ResultSet rs=ps.executeQuery();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            while (rs.next()){
                pacientes.add(new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(6)),
                        rs.getString(7)));
// lo busca en el otro dao, porque las tablas estan relacionadas.
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
        return pacientes;
    }

    @Override
    public Paciente buscarXCriterioString(String criterio) {
        Connection connection=null;
        Paciente paciente=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM PACIENTES WHERE EMAIL=?");
            ps.setString(1,criterio);
            ResultSet rs= ps.executeQuery();
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            while (rs.next()){
                paciente=new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        domicilioDAOH2.buscar(rs.getInt(6)),
                        rs.getString(7)
                );
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
