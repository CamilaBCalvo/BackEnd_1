package DBPersistence.DAO;

import DBPersistence.DBConnectionH2;
import Model.Domicilio;
import Model.Paciente;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.NOPLogger;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PacienteDaoH2 implements IDao<Paciente>{
    private static final String SQL_CREAR_PACIENTE = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_INGRESO, DOMICILIO_ID) VALUES (?,?,?,?,?);";
    private static final String SQL_ELIMINAR = "DELETE FROM PACIENTES WHERE ID=?;";
    private static final String SQL_PACIENTE = "SELECT * FROM PACIENTES WHERE ID=?;";
    private static final String SQL_TODOS_LOS_PACIENTES = "SELECT * FROM PACIENTES;";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DNI=?, FECHA_INGRESO=? WHERE ID=?;";
    private static final Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);


    @Override
    public Paciente crear(Paciente paciente) throws Exception {
        Connection connection = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREAR_PACIENTE, Statement.RETURN_GENERATED_KEYS);
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.crear(paciente.getDomicilio());
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt("ID"));
            }

            LOGGER.info("se creo nuevo paciente");

        }catch(Exception e){
            LOGGER.error("no se creo paciente");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        Paciente paciente = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR);
            preparedStatement.setInt(1,id);
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            paciente = buscar(id);
            domicilioDaoH2.eliminar(paciente.getDomicilio().getId());
            preparedStatement.execute();

            LOGGER.info("se elimino el paciente del id " + id);

        }catch(Exception e){
            LOGGER.error("no se pudo eliminar al paciente del id " + id);
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection = null;
        Paciente paciente = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_PACIENTE);
            preparedStatement.setInt(1, id);
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                paciente = new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getInt("DNI"), rs.getDate("FECHA_INGRESO").toLocalDate(), domicilioDaoH2.buscar(rs.getInt("DOMICILIO_ID")));
            }

            LOGGER.info("devuelve paciente");
        }catch(Exception e){
            LOGGER.error("no hay paciente");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void modificar(Paciente paciente) {
        Connection connection = null;
        try{
            connection = DBConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.modificar(paciente.getDomicilio());
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaDeIngreso()));
            preparedStatement.setInt(5, paciente.getId());
            preparedStatement.execute();

            LOGGER.info("se edito al paciente");

        }catch(Exception e){
            LOGGER.error("no se edito al paciente");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        Paciente paciente = null;
        try{
            connection = DBConnectionH2.getConnection();
            Statement statement = connection.createStatement();
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            ResultSet rs = statement.executeQuery(SQL_TODOS_LOS_PACIENTES);

            while(rs.next()) {
                paciente = new Paciente(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getInt("DNI"), rs.getDate("FECHA_INGRESO").toLocalDate(), domicilioDaoH2.buscar(rs.getInt("DOMICILIO_ID")));
                pacientes.add(paciente);
            }

            LOGGER.info("devuelve lista completa");
        }catch(Exception e){
            LOGGER.error("no hay ningun paciente en la lista");
            e.printStackTrace();
        }
        finally{
            try{
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pacientes;
    }
}
