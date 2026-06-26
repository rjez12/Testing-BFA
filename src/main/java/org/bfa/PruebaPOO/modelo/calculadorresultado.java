package org.bfa.PruebaPOO.modelo;

import org.bfa.PruebaPOO.modelo.RespuestaCandidato;

import java.util.List;

public class calculadorresultado {

    public resultadocalculo calcular(List<RespuestaCandidato> respuestas) {

        int aciertos = 0;
        int errores = 0;
        int omisiones = 0;

        for (RespuestaCandidato respuesta : respuestas) {

            if (respuesta.getAlternativaseleccionada() == null) {
                omisiones++;
                continue;
            }

            if (respuesta.getAlternativaseleccionada().isEscorrecta()) {
                aciertos++;
            } else {
                errores++;
            }
        }

        int n = 5;

        resultadocalculo resultado = new resultadocalculo();

        resultado.setaciertos(aciertos);
        resultado.seterrores(errores);
        resultado.setomisiones(omisiones);

        resultado.setpuntajedirecto(
                aciertos - (errores / (double)(n - 1))
        );

        return resultado;
    }
}