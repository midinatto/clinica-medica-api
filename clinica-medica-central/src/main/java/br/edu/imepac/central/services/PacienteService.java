package br.edu.imepac.central.services;


import br.edu.imepac.central.dtos.paciente.PacienteDto;
import br.edu.imepac.central.dtos.paciente.PacienteRequest;
import br.edu.imepac.central.models.Paciente;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PacienteService {
        private final ModelMapper modelMapper;
        private final PacienteRepository.PacienteRepository pacienteRepository;
        public PacienteService(ModelMapper modelMapper, PacienteRepository.PacienteRepository pacienteRepository) {
            this.modelMapper = modelMapper;
            this.pacienteRepository = pacienteRepository;
        }

        public PacienteDto adicionarPaciente(PacienteRequest pacienteRequest) {
                log.info("Cadastro de paciente - service: {}", pacienteRequest);
            Paciente paciente = modelMapper.map(pacienteRequest, Paciente.class);
            paciente = pacienteRepository.save(paciente);
                return modelMapper.map(paciente, PacienteDto.class);
            }

        public PacienteDto atualizarPaciente(Long id, PacienteDto pacienteDto) {
            log.info("Atualizando paciente com ID: {}", id);
            Paciente pacienteExistente = pacienteRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));
                modelMapper.map(pacienteDto, pacienteExistente);
            Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);
                return modelMapper.map(pacienteAtualizado, PacienteDto.class);
            }


        public void removerPaciente(Long id) {
            log.info("Removendo paciente com ID: {}", id);
            Paciente paciente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + id));
            pacienteRepository.delete(paciente);
        }

        public PacienteDto buscarPacientePorId(Long id)   {
            log.info("Buscando paciente com ID: {}", id);
            Paciente paciente = pacienteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Paciente não encontradocom ID: " + id));
            return modelMapper.map(paciente, PacienteDto.class);
        }


        public List<PacienteDto> listarPaciente() {
            log.info("Listando todos os pacientes");
            List<Paciente> pacientes = pacienteRepository.findAll();
            return pacientes.stream()
                    .map(paciente -> modelMapper.map(paciente, PacienteDto.class))
                    .toList();
        }
}
