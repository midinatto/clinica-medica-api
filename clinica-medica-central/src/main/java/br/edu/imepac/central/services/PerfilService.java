package br.edu.imepac.central.services;

import br.edu.imepac.central.dtos.perfil.PerfilDto;
import br.edu.imepac.central.dtos.perfil.PerfilRequest;
import br.edu.imepac.central.models.Perfil;
import br.edu.imepac.central.repositories.PerfilRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service

public class PerfilService {

    private final ModelMapper modelMapper;
    private final PerfilRepository perfilRepository;

    public PerfilService(ModelMapper modelMapper, PerfilRepository perfilRepository) {
        this.modelMapper = modelMapper;
        this.perfilRepository = perfilRepository;
    }

    public Perfil adicionarPerfil(Perfil perfil) {
        log.info("Cadastro de perfil - service: {}", perfil);
        return perfilRepository.save(perfil);
    }

    public Perfil atualizarPerfil(Long id, PerfilRequest perfilAtualizado) {
        log.info("Atualizando perfil com ID: {}", id);
        Perfil perfilExistente = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado com ID: " + id));
        modelMapper.map(perfilAtualizado, perfilExistente);
        return perfilRepository.save(perfilExistente);
    }

    public void removerPerfil(Long id) {
        log.info("Removendo perfil com ID: {}", id);
        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado com ID: " + id));
        perfilRepository.delete(perfil);
    }

    public Perfil buscarPerfilPorId(Long id) {
        log.info("Buscando perfil com ID: {}", id);
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado com ID: " + id));
    }


    public boolean verificarAutorizacao(String usuario, String senha, String acao) {
        log.info("Verificando autorização para usuário: {}, senha: {}, acao: {}", usuario, senha, acao);
        return true;
    }

    public List<PerfilDto> listarPerfil() {
        return perfilRepository.findAll().stream().map((element) -> modelMapper.map(element, PerfilDto.class))
                .collect(Collectors.toList());

    }
}