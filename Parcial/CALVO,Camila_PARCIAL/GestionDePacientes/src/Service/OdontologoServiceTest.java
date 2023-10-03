package Service;

import DBPersistence.DAO.OdontologoDaoH2;
import DBPersistence.DBConnectionH2;
import Model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class OdontologoServiceTest {
    @Test
    void crear() throws Exception {
        DBConnectionH2.crearTablas();
        Odontologo odontologoA = new Odontologo(01,"MN0001", "jose", "perez");
        Odontologo odontologoB = new Odontologo(02,"MN0002", "ana", "juarez");

        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
        odontologoService.crear(odontologoA);
        odontologoService.crear(odontologoB);

        Assertions.assertEquals(2, odontologoService.buscarTodos().size());
    }
}
