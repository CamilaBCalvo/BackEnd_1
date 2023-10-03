package com.Clase14_Video2.servicios;

import com.Clase14_Video2.daos.IDao;
import com.Clase14_Video2.entidades.Estudiante;

import java.sql.SQLException;
import java.util.List;

public class EstudianteService {

    private IDao<Estudiante> estudianteIDao;

    public IDao<Estudiante> getEstudianteIDao() {
        return estudianteIDao;
    }

    public void setEstudianteIDao(IDao<Estudiante> estudianteIDao) {
        this.estudianteIDao = estudianteIDao;
    }

    //Es un public estudiante y no void, poruqe devuelve un estudiante.
    public Estudiante guardarEstudiante(Estudiante e) {
        //delegamos la responsabilidad de guardar al DAO
        return estudianteIDao.guardar(e); //uso el metodo del DAO y le paso el mismo estudiante por parametro
    }

    public void eliminarEstudiante (Long id){
        estudianteIDao.eliminar(id);
    }

    public Estudiante buscarEstudiante (Long id){
        return estudianteIDao.buscar(id);
    }

    public List<Estudiante> buscarTodos(){
        return estudianteIDao.buscarTodos();
    }
}
