package com.example.EntregaFinal_2.controller;

import com.example.EntregaFinal_2.domain.Turno;
import com.example.EntregaFinal_2.service.OdontologoService;
import com.example.EntregaFinal_2.service.PacienteService;
import com.example.EntregaFinal_2.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private OdontologoService odontologoService;
    private PacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        ResponseEntity<Turno> respuesta;
        if (pacienteService.buscar(turno.getPaciente().getId())!=null
        && odontologoService.buscarOdontologo(turno.getOdontologo().getId())!=null) {
            respuesta=ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //hace uque el resultado de BAD REQUEST
        }
        return respuesta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno (@PathVariable int id){
        Turno turnoBuscado = turnoService.buscarTurno(id);
        if(turnoBuscado!=null){
            return ResponseEntity.ok(turnoBuscado);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/optional/{id}")
    public ResponseEntity<Turno> buscarTurnoOptional (@PathVariable int id){
        Optional<Turno> turnoBuscado = turnoService.buscarTurnoOptional(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno (@PathVariable int id){
        Optional<Turno> turnoBuscado = turnoService.buscarTurnoOptional(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok("Se elimino el turno por id: "+ id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se logro eliminar por id: "
                    +id
                    +", dado que el mismo no existe en la base de datos");
        }
    }

}
