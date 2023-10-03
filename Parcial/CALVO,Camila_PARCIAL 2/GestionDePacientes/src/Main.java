import DBPersistence.DAO.OdontologoDaoH2;
import DBPersistence.DAO.PacienteDaoH2;
import DBPersistence.DBConnectionH2;
import Model.Domicilio;
import Model.Odontologo;
import Model.Paciente;
import Service.PacienteService;
import OdontologoService.OdontologoService;
// no me importa la clase OdontologoService, no e por qué

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        Domicilio domicilioA = new Domicilio("Castro", 1001, "caba", "chubut");
        Domicilio domicilioB = new Domicilio("Triunvirato", 1002, "moreno", "tucuman");
        Domicilio domicilioC = new Domicilio("Callao", 1003, "escobar", "jujuy");

        Paciente pacienteA = new Paciente("Jose", "Suarez", 18155207, LocalDate.now(), domicilioA);
        Paciente pacienteB = new Paciente("Ana", "Alvarez", 34732485, LocalDate.of(2021,3,16), domicilioB);
        Paciente pacienteC = new Paciente("Pepa", "Perez", 16789432, LocalDate.of(2015,9,26), domicilioC);

        Odontologo odontologoA = new Odontologo(01,"MN0001", "jose", "perez");
        Odontologo odontologoB = new Odontologo(02,"MN0002", "ana", "juarez");
        Odontologo odontologoC = new Odontologo(03,"MN0003", "emma", "gonzalez");

        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        odontologoService.crear(odontologoA);
        odontologoService.crear(odontologoB);
        odontologoService.crear(odontologoC);

        DBConnectionH2.crearTablas();

        pacienteService.crear(pacienteA);
        pacienteService.crear(pacienteB);
        pacienteService.crear(pacienteC);

        pacienteService.eliminar(1);
        pacienteService.crear(pacienteA);

        System.out.println(pacienteService.buscar(1));

        pacienteA.setDni(10756453);
        pacienteService.modificar(pacienteA);

        System.out.println(pacienteService.buscarTodos());


    }

}
