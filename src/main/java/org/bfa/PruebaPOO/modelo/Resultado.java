package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;

import org.bfa.PruebaPOO.modelo.TestBFA;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idresultado;

    @Required
    private Integer aciertos;

    @Required
    private Integer errores;

    @Required
    private Integer omisiones;

    @Required
    private double puntuaciondirecta;

    @Required
    private Integer percentil;

    @OneToOne(fetch = FetchType.LAZY)
    private TestBFA testbfa;
}