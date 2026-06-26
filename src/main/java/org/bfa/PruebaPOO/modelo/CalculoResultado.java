package org.bfa.PruebaPOO.modelo;

import org.bfa.PruebaPOO.modelo.RespuestaCandidato;
import org.bfa.PruebaPOO.modelo.Resultado;

import java.util.List;

public class CalculoResultado {

    // nota como ahora devolvemos el tipo 'resultado' (la entidad de base de datos)
    public Resultado Calcular(List<RespuestaCandidato> respuestas) {

        int n = 5;
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

        // instanciamos la entidad correcta que sí tiene los setters de lombok
        Resultado res = new Resultado();

        res.setAciertos(aciertos);
        res.setErrores(errores);
        res.setOmisiones(omisiones);

        // aplicamos la formula psicometrica de penalizacion
        res.setPuntuaciondirecta(
                aciertos - (errores / (double)(n - 1))
        );

        return res;
    }
}