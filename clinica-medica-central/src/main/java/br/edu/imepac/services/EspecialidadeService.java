package br.edu.imepac.services;
import br.edu.imepac.dtos.especialidade.EspecialidadeDto;
import br.edu.imepac.dtos.especialidade.EspecialidadeRequest;
import br.edu.imepac.models.Especialidade;
import br.edu.imepac.repositories.EspecialidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class EspecialidadeService {
        private final EspecialidadeRepository especialidadeRepository;
        public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
            this.especialidadeRepository = especialidadeRepository;
        }

        public EspecialidadeDto adicionarEspecialidade(EspecialidadeRequest especialidadeRequest) {
                if(especialidadeRequest.getNome().isEmpty()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
                }

                if(especialidadeRequest.getDescricao().isEmpty()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição não pode ser vazio.");
                }

                Especialidade especialidade = new Especialidade();
            especialidade.setNome(especialidadeRequest.getNome());
            especialidade.setDescricao(especialidadeRequest.getDescricao());

            especialidadeRepository.save(especialidade);

                return new EspecialidadeDto(especialidade.getId(),
                        especialidade.getNome(),
                        especialidade.getDescricao());
            }


        public EspecialidadeDto atualizarEspecialidade(Long id, EspecialidadeRequest especialidadeRequest) {
            Especialidade especialidade = especialidadeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "especialidade não encontrado."));

                if (especialidadeRequest.getNome().isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
                }

                if (especialidadeRequest.getDescricao().isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição não pode ser vazio.");
                }

            especialidade.setNome(especialidadeRequest.getNome());
            especialidade.setDescricao(especialidadeRequest.getDescricao());

            especialidadeRepository.save(especialidade);

                return new EspecialidadeDto(especialidade.getId(), especialidade.getNome(), especialidade.getDescricao());
            }


        public void removerEspecialidade(Long id)  {
            Especialidade especialidade = especialidadeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrado."));
                especialidadeRepository.delete(especialidade);
            }

        public EspecialidadeDto buscarEspecialidadePorId(Long id)   {
                Especialidade especialidade = especialidadeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidade não encontrado."));
                return new EspecialidadeDto(especialidade.getId(), especialidade.getNome(), especialidade.getDescricao());
            }


        public List<EspecialidadeDto> listarEspecialidades() {
                return especialidadeRepository.findAll().stream()
                        .map(e -> new EspecialidadeDto(e.getId(), e.getNome(), e.getDescricao()))
                        .collect(Collectors.toList());

        }

    }

