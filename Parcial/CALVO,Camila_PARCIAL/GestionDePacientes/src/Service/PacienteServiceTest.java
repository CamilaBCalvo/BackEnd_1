package Service;

import DBPersistence.DAO.PacienteDaoH2;
import DBPersistence.DBConnectionH2;
import Model.Domicilio;
import Model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PacienteServiceTest {

    @Test
    void crear() throws Exception {
        DBConnectionH2.crearTablas();
        Domicilio domicilioA = new Domicilio("Castro", 1001, "caba", "chubut");
        Domicilio domicilioB = new Domicilio("Triunvirato", 1002, "moreno", "tucuman");
        Domicilio domicilioC = new Domicilio("Callao", 1003, "escobar", "jujuy");
        Paciente pacienteA = new Paciente("Jose", "Suarez", 18155207, LocalDate.now(), domicilioA);
        Paciente pacienteB = new Paciente("Ana", "Alvarez", 34732485, LocalDate.of(2021,3,16), domicilioB);
        Paciente pacienteC = new Paciente("Pepa", "Perez", 16789432, LocalDate.of(2015,9,26), domicilioC);
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        pacienteService.crear(pacienteA);
        pacienteService.crear(pacienteB);
        pacienteService.crear(pacienteC);

        Assertions.assertEquals(3, pacienteService.buscarTodos().size());
    }

    @Test
    void eliminar() throws Exception {
        DBConnectionH2.crearTablas();
        Domicilio domicilioA = new Domicilio("Castro", 1001, "caba", "chubut");
        Paciente pacienteA = new Paciente("Jose", "Suarez", 18155207, LocalDate.now(), domicilioA);
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        pacienteService.crear(pacienteA);
        pacienteService.eliminar(1);
        Assertions.assertEquals(0, pacienteService.buscarTodos().size());

    }
}