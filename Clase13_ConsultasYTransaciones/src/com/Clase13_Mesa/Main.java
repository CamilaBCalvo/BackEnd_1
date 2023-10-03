package com.Clase13_Mesa;

import java.sql.*;

public class Main {

    private static final String SQL_CREATE_DROP =
            "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY NOT NULL,"
                    + "APELLIDO VARCHAR(100) NOT NULL,"
                    + "NOMBRE VARCHAR(100) NOT NULL,"
                    + "MATRICULA VARCHAR(100))";

    private static final String SQL_INSERT =
        "INSERT INTO ODONTOLOGOS (ID, APELLIDO, NOMBRE, MATRICULA)"
            + "VALUES (?,?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE ODONTOLOGOS SET MATRICULA=? WHERE APELLIDO=?;";

    public static void main(String[] args) {
        Connection connection = null;
        Odontologo odontologo = new Odontologo(1,"Perez","Juan","MN001");

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_DROP);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getId());
            psInsert.setString(2,odontologo.getApellido());
            psInsert.setString(3,odontologo.getNombre());
            psInsert.setString(4,odontologo.getMatricula());
            psInsert.execute();

            Statement sql1=connection.createStatement();
            ResultSet rs1=sql1.executeQuery("SELECT * FROM ODONTOLOGOS");
            while(rs1.next()){
                System.out.println(
                        "ID: " + rs1.getInt(1)
                        +" - APELLIDO: " + rs1.getString(2)
                        +" - NOMBRE: " + rs1.getString(3)
                        +" - MATRICULA: " + rs1.getString(4)
                );
            }

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,"MN002");
            psUpdate.setString(2,"Perez");
            psUpdate.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        try {
            connection=getConnection();
            Statement sql2 = connection.createStatement();
            ResultSet rs2=sql2.executeQuery("SELECT * FROM ODONTOLOGOS");
            while (rs2.next()){
                System.out.println(
                        "ID: " + rs2.getInt(1)
                                +" - APELLIDO: " + rs2.getString(2)
                                +" - NOMBRE: " + rs2.getString(3)
                                +" - NUEVA MATRICULA: " + rs2.getString(4)
                );            }

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
        return DriverManager.getConnection("jdbc:h2:./Database/clase13_mesa","root","1234");
    }


}
