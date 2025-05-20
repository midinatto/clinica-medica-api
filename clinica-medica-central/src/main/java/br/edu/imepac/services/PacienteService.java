package br.edu.imepac.services;


import br.edu.imepac.dtos.paciente.PacienteDto;
import br.edu.imepac.dtos.paciente.PacienteRequest;
import br.edu.imepac.models.Paciente;
import br.edu.imepac.repositories.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PacienteService {
        private final PacienteRepository pacienteRepository;
        public PacienteService(PacienteRepository pacienteRepository) {
            this.pacienteRepository = pacienteRepository;
        }

        public PacienteDto adicionarPaciente(PacienteRequest pacienteRequest) {
            if(pacienteRequest.getNome().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
            }
            if (pacienteRequest.getIdade() == null || pacienteRequest.getIdade() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Idade deve ser maior que zero e não pode ser nula.");
            }
            if(pacienteRequest.getRua().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rua não pode ser vazio.");
            }
            if(pacienteRequest.getNumero().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero não pode ser vazio.");
            }
            if(pacienteRequest.getComplemento().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Complemento não pode ser vazio.");
            }
            if(pacienteRequest.getBairro().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bairro não pode ser vazio.");
            }
            if(pacienteRequest.getCidade().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidade não pode ser vazio.");
            }
            if(pacienteRequest.getEstado().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado não pode ser vazio.");
            }
            if(pacienteRequest.getContato().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não pode ser vazio.");
            }
            if(pacienteRequest.getEmail().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não pode ser vazio.");
            }
            if (pacienteRequest.getDataNascimento() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de nascimento não pode ser nula.");
            }


            Paciente paciente = new Paciente();
            paciente.setNome(pacienteRequest.getNome());
            paciente.setIdade(pacienteRequest.getIdade());
            paciente.setSexo(pacienteRequest.getSexo());
            paciente.setCpf(pacienteRequest.getCpf());
            paciente.setRua(pacienteRequest.getRua());
            paciente.setNumero(pacienteRequest.getNumero());
            paciente.setComplemento(pacienteRequest.getComplemento());
            paciente.setBairro(pacienteRequest.getBairro());
            paciente.setCidade(pacienteRequest.getCidade());
            paciente.setEstado(pacienteRequest.getEstado());
            paciente.setContato(pacienteRequest.getContato());
            paciente.setEmail(pacienteRequest.getEmail());
            paciente.setDataNascimento(pacienteRequest.getDataNascimento());

            pacienteRepository.save(paciente);

            return new PacienteDto(paciente.getId(),
                    paciente.getNome(),
                    paciente.getIdade(),
                    paciente.getSexo(),
                    paciente.getCpf(),
                    paciente.getRua(),
                    paciente.getNumero(),
                    paciente.getComplemento(),
                    paciente.getBairro(),
                    paciente.getCidade(),
                    paciente.getEstado(),
                    paciente.getContato(),
                    paciente.getEmail(),
                    paciente.getDataNascimento()
                    );
        }


        public PacienteDto atualizarPaciente(Long id, PacienteRequest pacienteRequest) {
            Paciente pac = pacienteRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado."));

            if(pacienteRequest.getNome().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
            }
            if (pacienteRequest.getIdade() == null || pacienteRequest.getIdade() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Idade deve ser maior que zero e não pode ser nula.");
            }
            if(pacienteRequest.getRua().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rua não pode ser vazio.");
            }
            if(pacienteRequest.getNumero().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero não pode ser vazio.");
            }
            if(pacienteRequest.getComplemento().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Complemento não pode ser vazio.");
            }
            if(pacienteRequest.getBairro().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bairro não pode ser vazio.");
            }
            if(pacienteRequest.getCidade().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cidade não pode ser vazio.");
            }
            if(pacienteRequest.getEstado().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado não pode ser vazio.");
            }
            if(pacienteRequest.getContato().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não pode ser vazio.");
            }
            if(pacienteRequest.getEmail().isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não pode ser vazio.");
            }
            if (pacienteRequest.getDataNascimento() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de nascimento não pode ser nula.");
            }
            return new PacienteDto(pac.getId(),
                    pac.getNome(),
                    pac.getIdade(),
                    pac.getSexo(),
                    pac.getCpf(),
                    pac.getRua(),
                    pac.getNumero(),
                    pac.getComplemento(),
                    pac.getBairro(),
                    pac.getCidade(),
                    pac.getEstado(),
                    pac.getContato(),
                    pac.getEmail(),
                    pac.getDataNascimento()
            );
        }


        public void removerPaciente(Long id)  {
            Paciente paciente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado."));
            pacienteRepository.delete(paciente);
        }

        public PacienteDto buscarPacientePorId(Long id)   {
            Paciente paciente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado."));
            return new PacienteDto(paciente.getId(),
                    paciente.getNome(),
                    paciente.getIdade(),
                    paciente.getSexo(),
                    paciente.getCpf(),
                    paciente.getRua(),
                    paciente.getNumero(),
                    paciente.getComplemento(),
                    paciente.getBairro(),
                    paciente.getCidade(),
                    paciente.getEstado(),
                    paciente.getContato(),
                    paciente.getEmail(),
                    paciente.getDataNascimento()
            );
        }


        public List<PacienteDto> listarPaciente() {
            return pacienteRepository.findAll().stream()
                    .map(e -> new PacienteDto(e.getId(), e.getNome(), e.getIdade(), e.getSexo(), e.getCpf(), e.getRua(),
                            e.getNumero(), e.getComplemento(), e.getBairro(), e.getCidade(), e.getEstado(), e.getContato(), e.getEmail(),
                            e.getDataNascimento()))
                    .collect(Collectors.toList());

        }
}
