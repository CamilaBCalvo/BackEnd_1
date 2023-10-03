package com.Clase11.EjercicioMesa;

import java.sql.*;

public class Mesa {

    //3
    private static final String SQL_CREATE_TABLE =
            "DROP TABLE IF EXISTS FIGURAS; CREATE TABLE FIGURAS" +
            "(ID INT PRIMARY KEY, FORMA VARCHAR(100) NOT NULL, COLOR VARCHAR(100) NOT NULL)";
    private static final String SQL_INSERT_1 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (1,'CIRCULO','ROJO')";
    private static final String SQL_INSERT_2 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (2,'CIRCULO','ROSA')";
    private static final String SQL_INSERT_3 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (3,'CIRCULO','AZUL')";
    private static final String SQL_INSERT_4 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (4,'CUADRADO','ROJO')";
    private static final String SQL_INSERT_5 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (5,'CUADRADO','VERDE')";
    private static final String SQL_INSERT_6 =
            "INSERT INTO FIGURAS (ID, FORMA, COLOR) VALUES (6,'CUADRADO','AMARILLO')";

    private static final String SQL_SELECT =
            "SELECT * FROM FIGURAS";
    private static final String SQL_SELECT_1 =
                "SELECT * FROM FIGURAS WHERE COLOR = 'ROJO'";


    //2
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection=getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statement1 = connection.createStatement();
            statement1.execute(SQL_INSERT_1);
            Statement statement3 = connection.createStatement();
            statement3.execute(SQL_INSERT_2);
            Statement statement4 = connection.createStatement();
            statement4.execute(SQL_INSERT_3);
            Statement statement5 = connection.createStatement();
            statement5.execute(SQL_INSERT_4);
            Statement statement6 = connection.createStatement();
            statement6.execute(SQL_INSERT_5);
            Statement statement7 = connection.createStatement();
            statement7.execute(SQL_INSERT_6);


            Statement statement2 = connection.createStatement();
            ResultSet rs = statement2.executeQuery(SQL_SELECT);
            System.out.println("Lista de todas las figuras: -----------");
            while (rs.next()){
                System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
            }

            Statement statement8 = connection.createStatement();
            ResultSet rs2 = statement8.executeQuery(SQL_SELECT_1);
            System.out.println("Lista solo de las figuras color rojo: -------------");
            while (rs2.next()){
                System.out.println(rs2.getInt(1)+" - "+rs2.getString(2)+" - "+rs2.getString(3));

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


    //1
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./Database/testClase","root","1234");
    }
}
