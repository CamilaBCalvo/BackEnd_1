package DBPersistence;

import org.apache.log4j.Logger;

import java.sql.*;

public class DBConnectionH2 {

    private static final String SQL_DROP_CREATE_PACIENTE = "DROP TABLE IF EXISTS PACIENTES; " +
                                                           "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, DNI INT NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID INT NOT NULL);";

    private static final String SQL_DROP_CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIO; " +
                                                            "CREATE TABLE DOMICILIO (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR(100) NOT NULL, PROVINCIA VARCHAR(100) NOT NULL);";

    private static final String SQL_DROP_CREATE_ODONTOLOGO = "DROP TABLE IF EXISTS ODONTOLOGOS; "+
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY NOT NULL, MATRICULA VARCHAR(100) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL);";

    private static final String SQL_URL= "jdbc:h2:~/ExamenBackEnd";
    private static final String SQL_USER = "sa";
    private static final String SQL_PASS = "";

    public static void crearTablas() {

        Logger logger = Logger.getLogger(DBConnectionH2.class);
        logger.info("se estan creando tablas");

        Connection connection = null;

        try{
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(SQL_DROP_CREATE_PACIENTE);
            stmt.execute(SQL_DROP_CREATE_DOMICILIO);
            stmt.execute(SQL_DROP_CREATE_ODONTOLOGO);


        } catch (Exception e){
            logger.error("ERROR");
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

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
    }
}
