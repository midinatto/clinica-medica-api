package br.edu.imepac.central.dtos.convenio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvenioRequest {

    private long id;

    private String nome;

    private String descricao;

}
