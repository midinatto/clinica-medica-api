package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.dtos.paciente.PacienteDto;
import br.edu.imepac.dtos.paciente.PacienteRequest;
import br.edu.imepac.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pacientes")
public class PacienteControllerAdm {

        private final PacienteService pacienteService;

        public  PacienteControllerAdm(PacienteService pacienteService) {
            this.pacienteService = pacienteService;
        }

        @PostMapping(consumes = "application/json", produces = "application/json")
        @ResponseStatus(HttpStatus.CREATED)
        public PacienteDto addPaciente(@RequestBody PacienteRequest pacienteRequest) {
            return pacienteService.adicionarPaciente(pacienteRequest);
        }

        @GetMapping(value = "/{id}", produces = "application/json")
        public PacienteDto getPacienteById(@PathVariable Long id)  {
            return pacienteService.buscarPacientePorId(id);
        }

        @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
        public PacienteDto updatePaciente(@PathVariable Long id, @RequestBody PacienteRequest pacienteRequest) {
            return pacienteService.atualizarPaciente(id, pacienteRequest);
        }

        @DeleteMapping(value = "/{id}", produces = "application/json")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removerPaciente(@PathVariable Long id)  {
            pacienteService.removerPaciente(id);
        }
        @GetMapping(produces = "application/json")
        public List<PacienteDto> listarPaciente() {
            return pacienteService.listarPaciente();
        }
    }




