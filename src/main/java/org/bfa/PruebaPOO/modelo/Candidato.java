package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@View(name="Simple", members="username; nombres, apellidos; carrera, genero, fechaNacimiento") // Organiza los campos en la misma línea separados por comas
public class Candidato extends Usuario {

    @Column(length = 100)
    @Required
    private String carrera;

    @Required
    private LocalDate fechaNacimiento; // OpenXava generará un calendario automáticamente

    @Enumerated(EnumType.STRING) // Le dice a JPA que guarde el nombre del Enum (ej. "MASCULINO") en vez de un número.
    @Required
    private Genero genero;

}