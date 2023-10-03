package com.example.ProyectoFinal_ClinicaOdontologica.controller;

import com.example.ProyectoFinal_ClinicaOdontologica.domain.Odontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Paciente;
import com.example.ProyectoFinal_ClinicaOdontologica.domain.Turno;
import com.example.ProyectoFinal_ClinicaOdontologica.dto.TurnoDTO;
import com.example.ProyectoFinal_ClinicaOdontologica.service.ServOdontologo;
import com.example.ProyectoFinal_ClinicaOdontologica.service.ServPaciente;
import com.example.ProyectoFinal_ClinicaOdontologica.service.ServTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class ContrTurno {
    private ServTurno servTurno;
    private ServOdontologo servOdontologo;
    private ServPaciente servPaciente;

    @Autowired
    public ContrTurno(ServTurno servTurno, ServOdontologo servOdontologo, ServPaciente servPaciente) {
        this.servTurno = servTurno;
        this.servOdontologo = servOdontologo;
        this.servPaciente = servPaciente;
    }

    public ContrTurno(ServTurno servTurno) {
        this.servTurno = servTurno;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody TurnoDTO turno){
        ResponseEntity<Turno> respuesta;
        Optional<Paciente> pacienteBuscado = servPaciente.buscarPaciente(turno.getPaciente_id());
        Optional<Odontologo> odontologoBuscado = servOdontologo.buscarOdontologo(turno.getOdontologo_id());
        if (pacienteBuscado.isPresent()&& odontologoBuscado.isPresent()) {
            respuesta=ResponseEntity.ok(servTurno.registrarTurno(turno));
        }else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return respuesta;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno (@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = servTurno.buscarTurno(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> buscarTodosTurnos(){
        return ResponseEntity.ok(servTurno.listarTodosTurnos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno (@PathVariable Long id){
        Optional<TurnoDTO> turnoBuscado = servTurno.buscarTurno(id);
        if (turnoBuscado.isPresent()){
            servTurno.eliminarTurno(id);
            return ResponseEntity.ok("Se elimino el turno por id: "+ id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se logro eliminar por id: "
                    +id
                    +", dado que el mismo no existe en la base de datos");
        }
    }

}
