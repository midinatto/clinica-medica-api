package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.central.dtos.convenio.ConvenioDto;
import br.edu.imepac.central.dtos.convenio.ConvenioRequest;
import br.edu.imepac.central.services.ConvenioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/convenios")
public class ConvenioAgenController {

        private final ConvenioService convenioService;

        public ConvenioAgenController(ConvenioService convenioService) {
            this.convenioService = convenioService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ConvenioDto criarConvenio(@RequestBody ConvenioRequest convenioRequest) {
            log.info("Criando Convenio - controller: {}", convenioRequest);
            return convenioService.adicionarConvenio(convenioRequest);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ConvenioDto atualizarConvenio(@PathVariable Long id, @RequestBody ConvenioDto convenioDto) {
            log.info("Atualizar Convenio - controller: {}", convenioDto);
            return convenioService.atualizarConvenio(id, convenioDto);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void removerConvenio(@PathVariable Long id) {
            log.info("Remover Convenio - controller: {}", id);
            convenioService.removerConvenio(id);
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ConvenioDto buscarConvenioPorId(@PathVariable Long id) {
            log.info("Buscar Convenio - controller: {}", id);
            return convenioService.buscarConvenioPorId(id);
        }

        @GetMapping("/listar")
        @ResponseStatus(HttpStatus.OK)
        public List<ConvenioDto> listarConvenio() {
            log.info("Listar Convenio - controller");
            return convenioService.listarConvenio();
        }
    }
