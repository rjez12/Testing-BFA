package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class RespuestaCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idrespuesta;

    @ManyToOne
    private TestBFA testbfa;

    @ManyToOne
    private Reactivo reactivo;

    @ManyToOne(optional = true) // nullable en el uml por si el candidato omite la pregunta
    private Alternativa alternativaseleccionada;

    private long tiemporespuestamilisegundos;

}