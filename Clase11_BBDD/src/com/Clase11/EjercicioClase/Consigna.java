package com.Clase11.EjercicioClase;

import java.sql.*;

public class Consigna {

    //ESTO LO HICE NUMERO 3
    private static final String SQL_CREATE_TABLE =
            "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES" + //Primero le digo que la cree si no existe
                    "(ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)";
    private static final String SQL_INSERT_1 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1,'PANCHO','PERRO')";
    
    private static final String SQL_SELECT = "SELECT * FROM ANIMALES"; //Aca busca la informacion

    // ESTO LO HICE NUMERO 2
    public static void main(String[] args) {
        Connection connection = null;
        // Como tira exceptions, necesito ponerlo dentro de un try-catch
        try {
            //aca hago la conexion
            connection=getConnection(); //este renglon tmb me pide que ponga la exception, va en el catch

            Statement statement = connection.createStatement(); //aca quiero mandar el SQL a la base, necesito crear un statement
            statement.execute(SQL_CREATE_TABLE);//ejecuto el SQL

            Statement statement2 = connection.createStatement();
            statement2.execute(SQL_INSERT_1);
 
            //En este tercer caso, yo no estoy mandando info, sino que la traigo. Entonces es distinto y uso ResultSet.
            Statement statement3 = connection.createStatement();
            ResultSet rs = statement3.executeQuery(SQL_SELECT);
            //Ahora tengo que recorrer esa informacion con un ciclo condicional --> WHILE
            while (rs.next()){ // el NEXT pregunta y mueve el indicador a la fila siguiente y te muestre todas las rtas
                System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3));
            }

        }catch (Exception e){

            e.printStackTrace();
        }
        finally {
            //el bloque finally cierra al conexion
            try {
                connection.close(); //este renglon tmb arroja una exception por eso va un try-catch adentro del finally
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    //ESTO LO HICE NUMERO 1
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //aca aviso que voy a usar el driver. Te obliga a poner la exception.
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./Database/test","root","1234");
        //Aca es para que si no existe el ususario, te lo crea, si no existe la tabla, te la crea.
        //getConnection tmb te obliga a tener una exception.
    }
}
