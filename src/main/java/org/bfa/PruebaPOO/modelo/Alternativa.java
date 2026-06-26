package org.bfa.PruebaPOO.modelo;
import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idalternativa;

    @ManyToOne
    private Reactivo reactivo;

    @Column(length = 1)
    @Required
    private String etiquetaopcion;

    @Required
    private boolean escorrecta;

    @Stereotype("image")
    private String rutaimagenestimulo;
}
