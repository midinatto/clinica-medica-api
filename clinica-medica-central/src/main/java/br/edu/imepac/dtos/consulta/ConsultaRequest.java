package br.edu.imepac.dtos.consulta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ConsultaRequest {

    private long id;

    private LocalDateTime DataHorario;

    private String sintomas;

    private boolean eRetorno;

    private boolean estaAtiva;

    public boolean getEstaAtivo() {
        return false;
    }
}

