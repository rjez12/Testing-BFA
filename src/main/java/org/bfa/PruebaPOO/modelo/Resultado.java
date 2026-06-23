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

    public void calcularmetricasexamen() {
        // asumimos que n (opciones por reactivo) es 5 (a, b, c, d, e)
        int opciones = 5;
        this.aciertos = 0;
        this.errores = 0;
        this.omisiones = 0;

        // iteramos sobre las respuestas que el candidato guardo en el test
        for (RespuestaCandidato resp : this.testbfa.getRespuestas()) {
            if (resp.getAlternativaseleccionada() == null) {
                this.omisiones++; // si la dejo en blanco
            } else if (resp.getAlternativaseleccionada().isEscorrecta()) {
                this.aciertos++; // si marco la correcta
            } else {
                this.errores++; // si se equivoco
            }
        }

        // aplicamos la formula exacta del documento
        this.puntuaciondirecta = this.aciertos - ((double) this.errores / (opciones - 1));
    }
}