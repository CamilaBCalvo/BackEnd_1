package com.example.Clase25_LiveCoding.service;


import com.example.Clase25_LiveCoding.dao.IDao;
import com.example.Clase25_LiveCoding.model.Medicamento;

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
