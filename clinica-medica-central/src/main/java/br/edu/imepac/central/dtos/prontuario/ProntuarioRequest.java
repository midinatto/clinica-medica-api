package br.edu.imepac.central.dtos.prontuario;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProntuarioRequest {

    private long id;
    private String receituario;
    private String exames;
    private String observacoes;

}



