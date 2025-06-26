package br.edu.imepac.central.dtos.perfil;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;


@Data
@NoArgsConstructor
@AllArgsConstructor


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerfilDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    private boolean cadastrarPaciente;
    private boolean lerPaciente;
    private boolean atualizarPaciente;
    private boolean deletarPaciente;
    private boolean listarPaciente;
    private boolean cadastrarFuncionario;
    private boolean lerFuncionario;
    private boolean atualizarFuncionario;
    private boolean deletarFuncionario;
    private boolean listarFuncionario;
    private boolean cadastrarProntuario;
    private boolean lerProntuario;
    private boolean atualizarProntuario;
    private boolean deletarProntuario;
    private boolean listarProntuario;
    private boolean cadastrarConvenio;
    private boolean lerConvenio;
    private boolean atualizarConvenio;
    private boolean deletarConvenio;
    private boolean listarConvenio;
    private boolean cadastrarConsulta;
    private boolean lerConsulta;
    private boolean atualizarConsulta;
    private boolean deletarConsulta;
    private boolean listarConsulta;
    private boolean cadastrarEspecialidade;
    private boolean lerEspecialidade;
    private boolean atualizarEspecialidade;
    private boolean deletarEspecialidade;
    private boolean listarEspecialidade;
}

