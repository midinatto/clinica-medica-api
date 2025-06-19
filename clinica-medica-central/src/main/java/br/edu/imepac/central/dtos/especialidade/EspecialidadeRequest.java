package br.edu.imepac.central.dtos.especialidade;

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


