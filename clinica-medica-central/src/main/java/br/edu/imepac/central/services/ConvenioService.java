package br.edu.imepac.central.services;

import br.edu.imepac.central.dtos.convenio.ConvenioDto;
import br.edu.imepac.central.dtos.convenio.ConvenioRequest;
import br.edu.imepac.central.models.Convenio;
import br.edu.imepac.central.repositories.ConvenioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
@Slf4j
@Service
public class ConvenioService {
    private final ModelMapper modelMapper;
    private final ConvenioRepository convenioRepository;

    public ConvenioService(ModelMapper modelMapper,ConvenioRepository convenioRepository) {
        this.modelMapper = modelMapper;
        this.convenioRepository = convenioRepository;
    }

    public ConvenioDto adicionarConvenio(ConvenioRequest convenioRequest) {
        log.info("Cadastro de convenio - service: {}", convenioRequest);
        Convenio convenio = modelMapper.map(convenioRequest, Convenio.class);
        convenio = convenioRepository.save(convenio);
        return modelMapper.map(convenio, ConvenioDto.class);
    }

    public ConvenioDto atualizarEspecialidade(Long id, ConvenioDto convenioDto) {
        log.info("Atualizando convenio com ID: {}", id);
        Convenio convenioExistente = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convenio não encontrado com ID: " + id));
        modelMapper.map(convenioDto, convenioExistente);
        Convenio convenioAtualizado = convenioRepository.save(convenioExistente);
        return modelMapper.map(convenioAtualizado, ConvenioDto.class);
    }
    public void removerConvenio (Long id) {
        log.info("Removendo convenio com ID: {}", id);
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convenio não encontrado com ID: " + id));
        convenioRepository.delete(convenio);
    }
    public ConvenioDto buscarConvenioPorId(Long id){
        log.info("Buscando convenio com ID: {}", id);
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convenio não encontradocom ID: " + id));
        return modelMapper.map(convenio, ConvenioDto.class);
    }
    public List<ConvenioDto> listarConvenio(){
        log.info("Listando todos os convenios");
        List<Convenio> convenios = convenioRepository.findAll();
        return convenios.stream()
                .map(convenio -> modelMapper.map(convenio, ConvenioDto.class))
                .toList();
    }
}