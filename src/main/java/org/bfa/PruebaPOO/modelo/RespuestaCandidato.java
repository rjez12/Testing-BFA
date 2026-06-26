package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;

import org.bfa.PruebaPOO.modelo.Alternativa;
import org.bfa.PruebaPOO.modelo.Reactivo;
import org.bfa.PruebaPOO.modelo.TestBFA;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter
@Setter
public class RespuestaCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idrespuesta;

    @ManyToOne
    private TestBFA testbfa;

    @ManyToOne
    private Reactivo reactivo;

    @ManyToOne(optional = true)
    private Alternativa alternativaseleccionada;

    private long tiemporespuestamilisegundos;
}