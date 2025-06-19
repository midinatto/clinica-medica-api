package br.edu.imepac.dtos.convenio;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude.Include.NON_NULL
public class ConvenioDto {
    private long id;
    private String nome;
    private String descricao;

}
