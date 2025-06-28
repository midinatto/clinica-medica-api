package br.edu.imepac.central.dtos.prontuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProntuarioDto {

    private long id;
    private String receituario;
    private String exames;
    private String observacoes;



}

