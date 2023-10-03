package com.Clase14_Video2.daos;

import com.Clase14_Video2.entidades.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO_h2 implements IDao<Estudiante> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/dbestudiantes";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        // 1. Levantar el driver para conectarnos y le damos la info
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            // 2. Crear una coneccion
            preparedStatement = connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            preparedStatement.setLong(1,estudiante.getId());
            preparedStatement.setString(2,estudiante.getNombre());
            preparedStatement.setString(3,estudiante.getApellido());

            // 3. Ejecutamos la sentencia y lo cerramos
            preparedStatement.executeUpdate();
            preparedStatement.close();

        //agrego el try-catch porque me tira las dos exceptions
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Levantar el driver para conectarnos y le damos la info
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. Crear una conexion
            preparedStatement = connection.prepareStatement("DELETE FROM estudiantes WHERE ID=?");
            preparedStatement.setLong(1, id);

            // 3. Ejecutamos la sentencia y lo cerramos
            preparedStatement.executeUpdate();
            preparedStatement.close();

            //agrego el try-catch porque me tira las dos exceptions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Estudiante buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Estudiante estudiante = null; // porque es un SELECT y me aparece el while

        try {
            // 1. Levantar el driver para conectarnos y le damos la info
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            // 2. Crear una coneccion
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes WHERE ID=?");
            preparedStatement.setLong(1, id);

            // 3. Ejecutamos la sentencia y lo cerramos
            //En este caso nos devuelve un resultado, lO TRAE, asique usamos el executeQuery, y el ResultSet
            ResultSet rs= preparedStatement.executeQuery();

            // 4. Aca vamos a tener que evaluar los resultados recorriendo los registros

            while (rs.next()){
                Long idEstudiante = rs.getLong("ID");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                // Lo asignamos a un estudiante
                estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

            }

            preparedStatement.close();

            //agrego el try-catch porque me tira las dos exceptions
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Estudiante> estudiantes = new ArrayList(); // porque es una LISTA lo que me va a devolver

        try {
            // 1. Levantar el driver para conectarnos y le damos la info
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. Crear una coneccion
            preparedStatement = connection.prepareStatement("SELECT * FROM estudiantes");

            // 3. Ejecutamos la sentencia y lo cerramos
            //En este caso nos devuelve un resultado, lO TRAE, asique usamos el executeQuery, y el ResultSet
            ResultSet rs = preparedStatement.executeQuery();

            // 4. Aca vamos a tener que evaluar los resultados recorriendo los registros

            while (rs.next()) {
                Long idEstudiante = rs.getLong("ID");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");

                // Por cada registro creamos a un estudiante y le asignamos los datos
                Estudiante estudiante = new Estudiante();
                estudiante = new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);

                // Ahora lo guardamos en el ArrayList
                estudiantes.add(estudiante);
            }

            preparedStatement.close();

            //agrego el try-catch porque me tira las dos exceptions
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }
}
