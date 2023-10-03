package DBPersistence.DAO;

import DBPersistence.DBConnectionH2;
import Model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio>{

    private static final String SQL_CREAR_DOMICILIO = "INSERT INTO DOMICILIO (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?);";
    private static final String SQL_ELIMINAR = "DELETE FROM DOMICILIO WHERE ID=?;";
    private static final String SQL_DOMICILIO = "SELECT * FROM DOMICILIO WHERE ID=?;";
    private static final String SQL_TODOS_LOS_DOMICILIOS = "SELECT * FROM DOMICILIO;";
    private static final String SQL_UPDATE = "UPDATE DOMICILIO SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?;";
    private static final Logger LOGGER = Logger.getLogger(DomicilioDaoH2.class);

    @Override
    public Domicilio crear(Domicilio domicilio) {
        Connection connection = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREAR_DOMICILIO, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
            }
            LOGGER.info("se agrego el domicilio");
        } catch (Exception e) {
            LOGGER.error("no se agrego el domicilio");
            throw new RuntimeException(e);
        }
        finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            LOGGER.info("el domicilio del id: " + id + " es eliminado");

        }catch (Exception e) {
            LOGGER.error("no se elimino el domicilio del id " + id);
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection = null;
        Domicilio domicilio = null;

        try{
            connection=DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DOMICILIO);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                domicilio = new Domicilio(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
            }

            LOGGER.info("devuelve domicilio");

        } catch (Exception e){
            LOGGER.error("no existe ese domicilio");
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void modificar(Domicilio domicilio) {
        Connection connection =null;

        try{
            connection=DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());
            preparedStatement.execute();

            LOGGER.info("actualizaste el domicilio");

        } catch (Exception e) {
            LOGGER.error("no se pudo modificar");
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();
        Domicilio domicilio = null;

        try{
            connection=DBConnectionH2.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_TODOS_LOS_DOMICILIOS);

            while(resultSet.next()) {
                domicilio = new Domicilio(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                domicilios.add(domicilio);
            }

            LOGGER.info("devuelve lista de domicilios");

        } catch (Exception e){
            LOGGER.error("no hay elementos en la lista");
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return domicilios;
    }
}
