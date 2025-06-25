package br.edu.imepac.central.dtos.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude.Include.NON_NULL

public class ConsultaDto {
    private long id;
    private LocalDateTime DataHorario;
    private String sintomas;
    private boolean eRetorno;
    private Boolean EstaAtiva;

    public ConsultaDto(long id, String dataHorario, String sintomas) {
    }


}
