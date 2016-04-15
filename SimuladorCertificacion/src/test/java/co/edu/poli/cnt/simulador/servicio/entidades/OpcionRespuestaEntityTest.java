package co.edu.poli.cnt.simulador.servicio.entidades;

import co.edu.poli.cnt.simulador.modelo.OpcionRespuestaEntity;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de entidad OpcionRespuesta.
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class OpcionRespuestaEntityTest {

    @Test
    public void calificarOpcionRespuestaTest() {
        OpcionRespuestaEntity opcionRespuesta = new OpcionRespuestaEntity();
        opcionRespuesta.setOpcionCorrecta(true);
        opcionRespuesta.setElegida(true);
        Assert.assertTrue(opcionRespuesta.calificarOpcionRespuesta());

        opcionRespuesta = new OpcionRespuestaEntity();
        opcionRespuesta.setOpcionCorrecta(true);
        opcionRespuesta.setElegida(false);
        Assert.assertFalse(opcionRespuesta.calificarOpcionRespuesta());

        opcionRespuesta = new OpcionRespuestaEntity();
        opcionRespuesta.setOpcionCorrecta(false);
        opcionRespuesta.setElegida(true);
        Assert.assertFalse(opcionRespuesta.calificarOpcionRespuesta());

        opcionRespuesta = new OpcionRespuestaEntity();
        opcionRespuesta.setOpcionCorrecta(false);
        opcionRespuesta.setElegida(false);
        Assert.assertTrue(opcionRespuesta.calificarOpcionRespuesta());
    }
}
