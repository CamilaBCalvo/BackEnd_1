package dao;

import bd.BD;
import model.Domicilio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DOMICILIOS (" +
                    "CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
                    "VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS); // Esto lo agregamos por el autoincrement
             ps.setString(1,domicilio.getCalle());
             ps.setString(2,domicilio.getNumero());
             ps.setString(3,domicilio.getLocalidad());
             ps.setString(4,domicilio.getProvincia());
             ps.execute();
// Esto lo hacemos por el autoincrement
            ResultSet clave=ps.getGeneratedKeys();
            while (clave.next()){
                domicilio.setId(clave.getInt(1));
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
        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
// este buscar esta pensado para buscar de a un domicilio
        Connection connection = null;
        Domicilio domicilio = null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
// Haces el domicilio nuevo con el constructor que TIENE id
                domicilio = new Domicilio(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
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
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement  ps= connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID=?");
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
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE DOMICILIOS SET CALLE = ?, " +
                    "NUMERO = ?, " +
                    "LOCALIDAD = ?," +
                    "PROVINCIA = ? " +
                    "WHERE ID = ?");
            ps.setString(1,domicilio.getCalle());
            ps.setString(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.setInt(5, domicilio.getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                //Domicilio domicilio = new Domicilio(rs.getInt(1),
                //        rs.getString(2),
                //        rs.getString(3),
                //        rs.getString(4),
                //        rs.getString(5));
                domicilios.add(new Domicilio(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
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
        return domicilios; //devuelvo la LISTA porque es un buscarTodos
    }
}
