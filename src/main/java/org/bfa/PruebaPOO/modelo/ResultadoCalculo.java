package org.bfa.PruebaPOO.modelo;

public class ResultadoCalculo {

    private int aciertos;
    private int errores;
    private int omisiones;
    private double puntajedirecto;

    public int getaciertos() {
        return aciertos;
    }

    public void setaciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int geterrores() {
        return errores;
    }

    public void seterrores(int errores) {
        this.errores = errores;
    }

    public int getomisiones() {
        return omisiones;
    }

    public void setomisiones(int omisiones) {
        this.omisiones = omisiones;
    }

    public double getpuntajedirecto() {
        return puntajedirecto;
    }

    public void setpuntajedirecto(double puntajedirecto) {
        this.puntajedirecto = puntajedirecto;
    }
}