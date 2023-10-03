package com.example.ProyectoFinal_ClinicaOdontologica.service;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Turno;
import com.example.ProyectoFinal_ClinicaOdontologica.dto.TurnoDTO;
import com.example.ProyectoFinal_ClinicaOdontologica.repository.RepTurno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ServTurno {
    private RepTurno repTurno;
    public ServTurno(RepTurno repTurno) {
        this.repTurno = repTurno;
    }
    public TurnoDTO registrarTurno(TurnoDTO turno){
        return convertirTurnoaTurnoDTO(repTurno.save(convertirTurnoDTOaTurno(turno)));
    }
    public TurnoDTO acutalizarTurno(TurnoDTO turno){
        return convertirTurnoaTurnoDTO(repTurno.save(convertirTurnoDTOaTurno(turno)));
    }
    public Optional<TurnoDTO> buscarTurno(Long id) {
        Optional<Turno> turnoBuscado = repTurno.findById(id);
        if(turnoBuscado.isPresent()){
            return  Optional.of(convertirTurnoaTurnoDTO(repTurno.findById(id).get()));
        }else {
            return Optional.empty();   
        }
    }
    public List<TurnoDTO> listarTodosTurnos() {
        List<Turno> turnoEncontrado = repTurno.findAll();
        List<TurnoDTO> respuesta= new ArrayList<TurnoDTO>();
        for (Turno turno : turnoEncontrado) {
            respuesta.add(convertirTurnoaTurnoDTO(turno));
        }return respuesta;
    }

    public void eliminarTurno(Long id) {
        repTurno.deleteById(id);
    }

    private Turno convertirTurnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        paciente.setId(turnoDTO.getPaciente_id());
        odontologo.setId(turnoDTO.getOdontologo_id());
        paciente.setNombre(turnoDTO.getNombre_paciente());
        odontologo.setNombre(turnoDTO.getNombre_odontologo());
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        return turno;
    }
    private TurnoDTO convertirTurnoaTurnoDTO(Turno turno){
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setOdontologo_id(turno.getOdontologo().getId());
        turnoDTO.setPaciente_id(turno.getPaciente().getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setNombre_odontologo(turno.getOdontologo().getNombre());
        turnoDTO.setNombre_paciente(turno.getPaciente().getNombre());
        return turnoDTO;
    }
}
