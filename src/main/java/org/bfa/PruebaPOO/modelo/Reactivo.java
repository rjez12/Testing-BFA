package org.bfa.PruebaPOO.modelo;
import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@Getter @Setter
public class Reactivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer idreactivo;

    @Column(length = 20)
    @Required
    private String codigoreactivo;

    @Required
    private Integer ordensecuencial;

    @Stereotype("image")
    private String rutaimagenmodelo;

    @OneToMany(mappedBy = "reactivo", cascade = CascadeType.ALL)
    @ListProperties("etiquetaopcion, escorrecta")
    private java.util.Collection<Alternativa> alternativas;
}