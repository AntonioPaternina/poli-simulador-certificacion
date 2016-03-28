package co.edu.poli.cnt.simulador.servicio.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionRespuestaEntity)) {
            return false;
        }
        OpcionRespuestaEntity other = (OpcionRespuestaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OpcionRespuestaEntity{" + "id=" + id + ", contenido=" + contenido + ", opcionCorrecta=" + opcionCorrecta + ", orden=" + orden + ", elegida=" + elegida + '}';
    }

}
