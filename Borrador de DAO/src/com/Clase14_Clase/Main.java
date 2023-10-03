package com.Clase14_Clase;

import com.Clase14_Clase.dao.MedicamentoDAO_h2;
import com.Clase14_Clase.db.DB;
import com.Clase14_Clase.model.Medicamento;
import com.Clase14_Clase.service.MedicamentoService;

public class Main {
    public static void main(String[] args) {
        DB.crearBD();
        Medicamento medicamento = new Medicamento(1,"12ED3","Ibuprofeno","Lab",2,506);
        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDAO_h2());
        Medicamento medicamentoGuardado = medicamentoService.guardarMedicamento(medicamento);
    }
}
