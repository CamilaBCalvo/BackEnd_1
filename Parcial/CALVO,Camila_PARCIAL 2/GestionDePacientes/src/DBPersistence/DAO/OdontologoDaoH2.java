package DBPersistence.DAO;

import DBPersistence.DBConnectionH2;
import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo>{

    private static final String SQL_CREAR_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (ID,MATRICULA,NOMBRE,APELLIDO) VALUES (?,?,?,?);";
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OdontologoDaoH2.class));

    private static final String SQL_LISTAR_ODONTOLOGOS = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo crear(Odontologo odontologo) throws Exception {
        Connection connection = null;
        try {
            connection = DBConnectionH2.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SQL_CREAR_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, odontologo.getId());
            pstmt.setString(2, odontologo.getMatricula());
            pstmt.setString(3, odontologo.getNombre());
            pstmt.setString(4, odontologo.getApellido());
            pstmt.execute();

        } catch (Exception e) {
            LOGGER.error("no pudiste crear odontologo");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public void modificar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = DBConnectionH2.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rsListaOdontologos = stmt.executeQuery(SQL_LISTAR_ODONTOLOGOS);
            while (rsListaOdontologos.next()) {
                odontologo = new Odontologo(rsListaOdontologos.getInt("ID"),rsListaOdontologos.getString("MATRICULA"), rsListaOdontologos.getString("NOMBRE"), rsListaOdontologos.getString("APELLIDO"));
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            LOGGER.error("no hay lista");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return odontologos;
    }
}
