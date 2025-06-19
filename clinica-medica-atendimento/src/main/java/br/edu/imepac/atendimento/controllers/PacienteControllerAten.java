package br.edu.imepac.atendimento.controllers;

import br.edu.imepac.central.dtos.paciente.PacienteDto;
import br.edu.imepac.central.dtos.paciente.PacienteRequest;
import br.edu.imepac.central.services.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/pacientes")
public class PacienteControllerAten {


        private final  PacienteService pacienteService;

        public  PacienteControllerAten(PacienteService pacienteService) {
            this.pacienteService = pacienteService;
        }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDto addPaciente(@RequestBody PacienteRequest pacienteRequest) {
        log.info("Criando paciente - controller: {}", pacienteRequest);
        return pacienteService.adicionarPaciente(pacienteRequest);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDto getPacienteById(@PathVariable Long id)  {
        log.info("Buscar paciente - controller: {}", id);
        return pacienteService.buscarPacientePorId(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDto updatePaciente(@PathVariable Long id, @RequestBody PacienteDto pacienteDto) {
        log.info("Atualizar paciente - controller: {}", pacienteDto);
        return pacienteService.atualizarPaciente(id, pacienteDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPaciente(@PathVariable Long id)  {
        log.info("Remover paciente - controller: {}", id);
        pacienteService.removerPaciente(id);
    }
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteDto> listarPaciente() {
        log.info("Listar paciente - controller");
        return pacienteService.listarPaciente();
    }
    }


