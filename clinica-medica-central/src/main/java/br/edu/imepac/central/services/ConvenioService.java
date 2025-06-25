package br.edu.imepac.central.services;

import br.edu.imepac.central.dtos.convenio.ConvenioDto;
import br.edu.imepac.central.dtos.convenio.ConvenioRequest;
import br.edu.imepac.central.models.Convenio;
import br.edu.imepac.central.repositories.ConvenioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConvenioService {
    private final ConvenioRepository convenioRepository;

    public ConvenioService(ConvenioRepository convenioRepository) {
        this.convenioRepository = convenioRepository;
    }

    public ConvenioDto adicionarConvenio(ConvenioRequest convenioRequest) {
        if (convenioRequest.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo nome não pode ser vazio");

        }
        if (convenioRequest.getDescricao().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deve haver a descrição do Convenio");
        }

        Convenio convenio = new Convenio();
        convenio.setNome(convenioRequest.getNome());
        convenio.setDescricao(convenioRequest.getDescricao());

        convenioRepository.save(convenio);

        return new ConvenioDto(convenio.getId(),
                convenio.getNome(),
                convenio.getDescricao());

    }

    public ConvenioDto atualizarEspecialidade(Long id, ConvenioRequest convenioRequest) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convenio não encontrado."));
        if (convenioRequest.getNome().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo nome não pode ser vazio");

        } if (convenioRequest.getDescricao().trim().isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deve haver a descrição do Convenio");
        }

        convenio.setNome(convenioRequest.getNome());
        convenio.setDescricao(convenioRequest.getDescricao());

        convenioRepository.save(convenio);

        return new ConvenioDto(convenio.getId(),
            convenio.getNome(),
            convenio.getDescricao());

    }
    public void removerConvenio (Long id) {
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convenio não encontrado"));
        convenioRepository.delete(convenio);
    }
    public ConvenioDto buscarConvenioPorId(Long id){
        Convenio convenio = convenioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Convenio não encontrado"));
        return new ConvenioDto(convenio.getId(), convenio.getNome(), convenio.getDescricao());
    }
    public List<ConvenioDto> listarConvenio(){
       return convenioRepository.findAll().stream()
               .map(e -> new ConvenioDto(e.getId(), e.getNome(), e.getDescricao()))
               .collect(Collectors.toList());


    }
}