package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class Evaluador extends Usuario {

    @Column(length = 50)
    @Required
    private String cargoAdministrativo;

    @Column(length = 20, unique = true) // El código de empleado no puede repetirse
    @Required
    private String codigoEmpleado;

    @Column(length = 100)
    @Required
    private String especialidadPsicologica;
}