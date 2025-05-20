package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.dtos.especialidade.EspecialidadeDto;
import br.edu.imepac.dtos.especialidade.EspecialidadeRequest;
import br.edu.imepac.services.EspecialidadeService;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeControllerAdm {

    private final EspecialidadeService especialidadeService;

    public EspecialidadeControllerAdm(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EspecialidadeDto addEspecialidade(@RequestBody EspecialidadeRequest especialidadeRequest) {
        return especialidadeService.adicionarEspecialidade(especialidadeRequest);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public EspecialidadeDto getEspecialidadeById(@PathVariable Long id)  {
        return especialidadeService.buscarEspecialidadePorId(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public EspecialidadeDto updateEspecialidade(@PathVariable Long id, @RequestBody EspecialidadeRequest especialidadeRequest) {
        return especialidadeService.atualizarEspecialidade(id, especialidadeRequest);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEspecialidade(@PathVariable Long id)  {
        especialidadeService.removerEspecialidade(id);
    }
    @GetMapping(produces = "application/json")
    public List<EspecialidadeDto> listarEspecialidades() {
        return especialidadeService.listarEspecialidades();
    }
}

