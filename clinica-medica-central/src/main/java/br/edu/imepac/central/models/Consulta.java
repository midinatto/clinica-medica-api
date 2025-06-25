package br.edu.imepac.central.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String dataHorario;

    @Column(nullable = false, length = 100)
    private String sintomas;

    @Column(nullable = false, length = 100)
    private boolean EstaAtiva;



}
