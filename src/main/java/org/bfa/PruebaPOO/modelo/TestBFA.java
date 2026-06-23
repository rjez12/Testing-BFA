package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;

import dev.langchain4j.agent.tool.P;
import lombok.*;
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

    // devolvemos la entidad 'Resultado' a la base de datos
    public Resultado resultadocalculo() {
        CalculoResultado calculador = new CalculoResultado();
        return calculador.Calcular(new ArrayList<>(this.getRespuestas() ));
    }

    @PreUpdate
    @PreRemove
    private void validarainmutabilidad() {
        if (this.estado == EnumestadoTest.finalizado) { // (Asegurate que tu enum por dentro diga 'finalizado')
            // si alguien intenta guardar cambios o eliminar un test finalizado, postgresql abortara
            throw new IllegalStateException("regla de seguridad 6: el examen esta finalizado y es inmutable.");
        }
    }
}