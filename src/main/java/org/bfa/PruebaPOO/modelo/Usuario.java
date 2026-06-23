package org.bfa.PruebaPOO.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia profesional: Crea una tabla "Usuario" y la une con las tablas hijas.
@Getter @Setter
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cumpliendo tu Regla de Negocio 10 (Autoincremental)
    @Hidden // Lección de OpenXava: Oculta este campo autogenerado en la interfaz, el usuario no necesita ver IDs de BD.
    private Integer idUsuario;

    @Column(length = 50)
    @Required // Lección de OpenXava: Hace que el campo sea obligatorio en la UI y en la BD.
    private String nombres;

    @Column(length = 50)
    @Required
    private String apellidos;

    @Column(length = 30, unique = true)
    @Required
    private String username;

    @Column(length = 255)
    @Required
    @Stereotype("PASSWORD") // Lección de OpenXava: Automáticamente enmascara el texto con asteriscos en la pantalla.
    private String passwordHash;
}