package br.edu.imepac.dtos.paciente;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PacienteRequest {
    private int id;
    private String nome;

    @NotNull(message = "Idade não pode ser nula.")
    @Min(value = 1, message = "Idade deve ser maior que zero.")
    private Integer idade;

    private char sexo;
    private String cpf;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String contato;
    private String email;
    private LocalDate dataNascimento;
}
