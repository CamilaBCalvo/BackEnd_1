package com.Clase13_Clase;

import java.sql.*;

public class Programa {

    private static final String SQL_CREATE_DROP =
            "DROP TABLE IF EXISTS CUENTAS;" +
            "CREATE TABLE CUENTAS (ID INT PRIMARY KEY,"
                    + "NRO_CUENTA INT NOT NULL,"
                    + "NOMBRE VARCHAR(100) NOT NULL,"
                    + "SALDO NUMERIC(10,2) NOT NULL)";
    private static final String SQL_INSERT =
            "INSERT INTO CUENTAS (ID, NRO_CUENTA, NOMBRE, SALDO)"
                    + "VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?;";

    public static void main(String[] args) {
        Connection connection  = null;
        Cuenta cuenta = new Cuenta(1,1234,"CA 001",10);
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_DROP);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            //ahora tengo que cargar el SQL con los datos a mandar
            psInsert.setInt(1,cuenta.getId());
            psInsert.setInt(2,cuenta.getNroCuenta());
            psInsert.setString(3,cuenta.getNombre());
            psInsert.setDouble(4,cuenta.getSaldo());
            //una vez cargado ordenamos al ejecucion
            psInsert.execute();

            //Actualizacion +10 de salto
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,cuenta.getSaldo()+10);
            psUpdate.setInt(2,cuenta.getId());
            //ordeno la ejecucion
            psUpdate.execute();

            //arranca tx (transaccion) - hasta que no les das el ok final, no impacta en la base
            connection.setAutoCommit(false); //deshabilito el commit
            psUpdate.setDouble(1,cuenta.getSaldo()+15);
            psUpdate.setInt(2,cuenta.getId());
            psUpdate.execute();
            psUpdate.setDouble(1,cuenta.getSaldo()+25);
            psUpdate.setInt(2,cuenta.getId());
            psUpdate.execute();

            //genero un error adrede - me obliga a hacer una excepcion y un rollback.
            //Para eso es esto de la TX, como que si hay error no se hace y se mantiene toddo en un estado "correcto"
            int a=4/0;

            connection.commit(); //aca termino la transaccion
            //vuelvo a ponerlo como estaba antes y lo vuelvo a pasar a true
            connection.setAutoCommit(true);

        }catch (Exception e){
            //Por el error adrede, hago un rollback
            if(connection!=null){
                try {
                    connection.rollback();
                }
                catch (SQLException sqlException){
                sqlException.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        //en este nivel puedo chequear que toodo este sucediendo
        try {
            connection=getConnection();
            Statement sql=connection.createStatement();
            ResultSet rs=sql.executeQuery("SELECT * FROM CUENTAS");
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+" - SALDO: "+rs.getDouble(4));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./Database/clase13","root","1234");
    }
}
