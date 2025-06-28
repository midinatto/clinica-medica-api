package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.central.dtos.consulta.ConsultaDto;
import br.edu.imepac.central.dtos.consulta.ConsultaRequest;
import br.edu.imepac.central.services.ConsultaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/consultas")
public class ConsultaAdmController {


        private final ConsultaService consultaService;

        public ConsultaAdmController(ConsultaService consultaService) {
            this.consultaService = consultaService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ConsultaDto criarConsulta(@RequestBody ConsultaRequest consultaRequest) {
            log.info("Criando Consulta - controller: {}", consultaRequest);
            return consultaService.adicionarConsulta(consultaRequest);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ConsultaDto atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaDto consultaDto) {
            log.info("Atualizar Consulta - controller: {}", consultaDto);
            return consultaService.atualizarConsulta(id, consultaDto);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removerConsulta(@PathVariable Long id) {
            log.info("Remover Consulta - controller: {}", id);
            consultaService.removerConsulta(id);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ConsultaDto buscarConsultaPorId(@PathVariable Long id) {
            log.info("Buscar Consulta - controller: {}", id);
            return consultaService.buscarConsultaPorId(id);
        }

        @GetMapping("/listar")
        @ResponseStatus(HttpStatus.OK)
        public List<ConsultaDto> listarConsulta() {
            log.info("Listar Consulta - controller");
            return consultaService.listarConsulta();
        }
    }


