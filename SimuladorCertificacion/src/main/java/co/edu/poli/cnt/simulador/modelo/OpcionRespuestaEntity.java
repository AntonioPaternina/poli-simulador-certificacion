package co.edu.poli.cnt.simulador.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Representa una opción de respuesta para una pregunta de selección única o de
 * selección múltiple.
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
@Entity
public class OpcionRespuestaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String contenido;
    private boolean opcionCorrecta;
    private int orden;
    @Transient
    private boolean elegida;
    @ManyToOne
    private PreguntaEntity pregunta;

    /**
     * Califica la opción de respuesta.
     *
     * @return Retorna verdadero si la opción de respuesta ha sido respondida
     * correctamente.
     */
    public boolean calificarOpcionRespuesta() {
        return opcionCorrecta == elegida;
    }

    /* GETTERS Y SETTERS */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(boolean opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public boolean isElegida() {
        return elegida;
    }

    public void setElegida(boolean elegida) {
        this.elegida = elegida;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public PreguntaEntity getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntaEntity pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.contenido);
        hash = 97 * hash + (this.opcionCorrecta ? 1 : 0);
        hash = 97 * hash + this.orden;
        hash = 97 * hash + (this.elegida ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.pregunta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OpcionRespuestaEntity other = (OpcionRespuestaEntity) obj;
        if (this.opcionCorrecta != other.opcionCorrecta) {
            return false;
        }
        if (this.orden != other.orden) {
            return false;
        }
        if (this.elegida != other.elegida) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pregunta, other.pregunta)) {
            return false;
        }
        return true;
    }

}
