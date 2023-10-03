package com.Clase14_Clase.service;

import com.Clase14_Clase.dao.IDao;
import com.Clase14_Clase.model.Medicamento;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento guardarMedicamento (Medicamento medicamento){
        return medicamentoIDao.guardar(medicamento);
    };
    public Medicamento buscarMedicamento(Long id){
        return medicamentoIDao.buscar(id);
    };

    public IDao<Medicamento> getMedicamentoIDao() {
        return medicamentoIDao;
    }

    public void setMedicamentoIDao(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }
}
