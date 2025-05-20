package br.edu.imepac.dtos.especialidade;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
    @Data
    public class EspecialidadeRequest {

    private String nome;

    private String descricao;
    }


