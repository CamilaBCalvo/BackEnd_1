package com.example.Clase25_LiveCoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private final static String DRIVER = "org.h2.Driver";
    private final static String URL = "jdbc:h2:./Database/clase14vivo";
    private final static String USER = "root";
    private final static String PASS = "1234";
    private final static String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS;"
            + "CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY NOT NULL, NOMBRE VARCHAR(200), LABORATORIO VARCHAR(100),CANTIDAD INT, PRECIO NUMERIC(10,2))";

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void crearBD(){
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }
        catch(Exception e){
            e.printStackTrace(); }
        finally {
            try{
                connection.close();
            }catch(Exception ex)
            { ex.printStackTrace(); }
        }
    }
}
