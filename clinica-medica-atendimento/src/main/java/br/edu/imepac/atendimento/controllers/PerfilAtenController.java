package br.edu.imepac.atendimento.controllers;
import br.edu.imepac.models.Perfil;
import br.edu.imepac.central.services.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.edu.imepac.central.dtos.perfil.PerfilDto;
import br.edu.imepac.central.dtos.perfil.PerfilRequest;

import java.util.List;

@RestController
@RequestMapping("/Perfils")
public class PerfilAtenController {

    private final PerfilService perfilService;
    public PerfilAtenController(PerfilService perfilService) {this.perfilService = perfilService;}

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Perfil addPerfil(@RequestBody Perfil perfil) {
        return perfilService.adicionarPerfil(perfil);
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public Perfil getPerfilById(@PathVariable Long id)  {return perfilService.buscarPerfilPorId(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Perfil updatePerfil(@PathVariable Long id, @RequestBody PerfilRequest perfilRequest) {
        return perfilService.atualizarPerfil(id, perfilRequest);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPerfil(@PathVariable Long id)  {
        perfilService.removerPerfil(id);
    }

    @GetMapping(produces = "application/json")
    public List<PerfilDto> listarPerfil() {
        return perfilService.listarPerfil();
    }
    @GetMapping(produces = "application/json" )
    public boolean verificarAutorizacao(@PathVariable String usuario, String senha, String acao) {
        return perfilService.verificarAutorizacao(usuario, senha, acao);
    }
}

