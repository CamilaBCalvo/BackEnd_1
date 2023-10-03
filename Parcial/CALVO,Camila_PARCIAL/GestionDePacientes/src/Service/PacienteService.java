package Service;

import DBPersistence.DAO.IDao;
import Model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteDaoH2IDao;

    public PacienteService(IDao<Paciente> pacienteDaoH2IDao) {
        this.pacienteDaoH2IDao = pacienteDaoH2IDao;
    }

    public Paciente crear(Paciente paciente) throws Exception {
        return pacienteDaoH2IDao.crear(paciente);
    }

    public void eliminar(int id) {
        pacienteDaoH2IDao.eliminar(id);
    }

    public Paciente buscar(int id) {
        return pacienteDaoH2IDao.buscar(id);
    }

    public void modificar(Paciente paciente) {
        pacienteDaoH2IDao.modificar(paciente);
    }

    public List<Paciente> buscarTodos() {
        return pacienteDaoH2IDao.buscarTodos();
    }
}
