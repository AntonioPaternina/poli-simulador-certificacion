package co.edu.poli.cnt.simulador.repositorio;

import co.edu.poli.cnt.simulador.modelo.PreguntaEntity;
import java.util.List;

/**
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public interface PreguntaRepositorio {

    /**
     * Consulta todas las preguntas en la base de datos.
     *
     * @return Una lista de las preguntas en la base de datos
     */
    List<PreguntaEntity> getAllPreguntaEntity();
}
