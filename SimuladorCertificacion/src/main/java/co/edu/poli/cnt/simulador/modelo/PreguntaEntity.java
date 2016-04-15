package co.edu.poli.cnt.simulador.modelo;

import co.edu.poli.cnt.simulador.servicio.excepciones.OpcionRespuestaNoExisteException;
import co.edu.poli.cnt.simulador.servicio.excepciones.PreguntaInvalidaException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidad Pregunta
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
@Entity
public class PreguntaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "clob")
    @Lob
    private String textoInicio;
    @Column(columnDefinition = "clob")
    @Lob
    private String textoFin;
    @Column(columnDefinition = "clob")
    @Lob
    private String fragmentoCodigo;
    @Enumerated(EnumType.STRING)
    private TipoPregunta tipoPregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    @NotEmpty
    private List<OpcionRespuestaEntity> opcionesRespuesta;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<TemaCertificacionEntity> temasCertificacion;

    /**
     * Califica la pregunta al determinar si la(s) respuesta(s) escogida(s) es
     * correcta.
     *
     * @return Retorna verdadero si la pregunta ha sido contestada
     * correctamente.
     * @throws
     * co.edu.poli.cnt.simulador.servicio.excepciones.PreguntaInvalidaException
     */
    public boolean calificarPregunta() throws PreguntaInvalidaException {
        if (!validarPregunta()) {
            throw new PreguntaInvalidaException();
        }

        return opcionesRespuesta.stream().noneMatch((opcionRespuesta) -> (!opcionRespuesta.calificarOpcionRespuesta()));
    }

    /**
     * Marca como elegida una opción de respuesta.
     *
     * @param idOpcionRespuesta el identificador de la opción de respuesta que
     * se quiere elegir.
     * @throws OpcionRespuestaNoExisteException si no existe ninguna opción de
     * respuesta con el id recibido como parámetro
     */
    public void marcarOpcionRespuesta(long idOpcionRespuesta) throws OpcionRespuestaNoExisteException {
        boolean respuestaElegida = false;
        if (opcionesRespuesta != null) {
            for (OpcionRespuestaEntity opcionRespuesta : opcionesRespuesta) {
                if (opcionRespuesta.getId() == idOpcionRespuesta) {
                    opcionRespuesta.setElegida(true);
                    respuestaElegida = true;
                    break;
                }
            }

            if (!respuestaElegida) {
                throw new OpcionRespuestaNoExisteException();
            }
        }
    }

    /**
     * Valida si la pregunta ha sido respondida de manera válida
     *
     * @return Verdadero si la pregunta ha sido respondida de manera válida,
     * falso en caso contrario.
     */
    private boolean validarPregunta() {
        if (opcionesRespuesta != null) {
            int numeroRespuestas = 0;
            numeroRespuestas = opcionesRespuesta.stream().filter((respuesta) -> (respuesta.isElegida())).map((_item) -> 1).reduce(numeroRespuestas, Integer::sum);
            if (null != tipoPregunta) {
                switch (tipoPregunta) {
                    case SELECCION_UNICA:
                        if (numeroRespuestas != 1) {
                            return false;
                        }
                        break;
                    case SELECCION_MULTIPLE:
                        if (numeroRespuestas < 1) {
                            return false;
                        }
                        break;
                    // escenario no definido
                    default:
                        break;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    /* GETTERS Y SETTERS */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoInicio() {
        return textoInicio;
    }

    public void setTextoInicio(String contenido) {
        this.textoInicio = contenido;
    }

    public String getTextoFin() {
        return textoFin;
    }

    public void setTextoFin(String textoFin) {
        this.textoFin = textoFin;
    }

    public String getFragmentoCodigo() {
        return fragmentoCodigo;
    }

    public void setFragmentoCodigo(String fragmentoCodigo) {
        this.fragmentoCodigo = fragmentoCodigo;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public List<OpcionRespuestaEntity> getOpcionesRespuesta() {
        return opcionesRespuesta;
    }

    public void setOpcionesRespuesta(List<OpcionRespuestaEntity> opcionesRespuesta) {
        this.opcionesRespuesta = opcionesRespuesta;
    }

    public List<TemaCertificacionEntity> getTemasCertificacion() {
        return temasCertificacion;
    }

    public void setTemasCertificacion(List<TemaCertificacionEntity> temasCertificacion) {
        this.temasCertificacion = temasCertificacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final PreguntaEntity other = (PreguntaEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PreguntaEntity{" + "id=" + id + ", textoInicio=" + textoInicio + ", textoFin=" + textoFin + ", fragmentoCodigo=" + fragmentoCodigo + ", tipoPregunta=" + tipoPregunta + ", opcionesRespuesta=" + opcionesRespuesta + ", temasCertificacion=" + temasCertificacion + '}';
    }

}
