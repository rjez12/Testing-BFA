package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;
import lombok.*;
import org.bfa.PruebaPOO.modelo.Candidato;
import org.bfa.PruebaPOO.modelo.EnumestadoTest;
import org.bfa.PruebaPOO.modelo.RespuestaCandidato;
import org.openxava.annotations.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
public class TestBFA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idtest;

    @Required
    private LocalDateTime fechacreacion;

    @Required
    private Integer tiempolimitesegundos = 900;

    private Integer segundosrestantes;

    @Enumerated(EnumType.STRING)
    @Required
    private EnumestadoTest estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Candidato candidato;

    @OneToMany(mappedBy = "testbfa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<RespuestaCandidato> respuestas;

    public resultadocalculo calcularresultado() {

        calculadorresultado calculador = new calculadorresultado();

        return calculador.calcular(new ArrayList<>(this.getRespuestas()));
    }
}