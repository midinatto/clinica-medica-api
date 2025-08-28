package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.central.dtos.prontuario.ProntuarioDto;
import br.edu.imepac.central.dtos.prontuario.ProntuarioRequest;
import br.edu.imepac.central.services.ProntuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/prontuarios")
public class ProntuarioAgenController {

        private final ProntuarioService prontuarioService;

        public ProntuarioAgenController(ProntuarioService prontuarioService) {
            this.prontuarioService = prontuarioService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ProntuarioDto criarProntuario(@RequestBody ProntuarioRequest prontuarioRequest) {
            log.info("Criando Prontuario - controller: {}", prontuarioRequest);
            return prontuarioService.adicionarProntuario(prontuarioRequest);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ProntuarioDto atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioDto prontuarioDto) {
            log.info("Atualizar Prontuario - controller: {}", prontuarioDto);
            return prontuarioService.atualizarProntuario(id, prontuarioDto);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removerProntuario(@PathVariable Long id) {
            log.info("Remover Prontuario - controller: {}", id);
            prontuarioService.removerProntuario(id);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ProntuarioDto buscarProntuarioPorId(@PathVariable Long id) {
            log.info("Buscar Prontuario - controller: {}", id);
            return prontuarioService.buscarProntuarioPorId(id);
        }

        @GetMapping("/listar")
        @ResponseStatus(HttpStatus.OK)
        public List<ProntuarioDto> listarProntuario() {
            log.info("Listar Prontuario - controller");
            return prontuarioService.listarProntuario();
        }
    }



