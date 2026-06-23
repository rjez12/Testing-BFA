package org.bfa.PruebaPOO.modelo;
import javax.persistence.*;

import lombok.*;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter @Setter
public class TestBFA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idtest;

    @Required
    private LocalDateTime fechacreacion;

    @Required
    private Integer tiempolimitesegundos = 900; // 15 minutos estrictos

    private Integer segundosrestantes;

    @Enumerated(EnumType.STRING)
    @Required
    private EnumestadoTest estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "nombres, apellidos") // le decimos explícitamente qué mostrar
    private Candidato candidato;

    @OneToMany(mappedBy = "testbfa", cascade = CascadeType.ALL)
    private Collection<RespuestaCandidato> respuestas;

}