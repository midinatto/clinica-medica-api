package br.edu.imepac.dtos.convenio;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvenioRequest {

    private long id;

    private String nome;

    private String descricao;

}
