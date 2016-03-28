package co.edu.poli.cnt.simulador.servicio.entidades;

import co.edu.poli.cnt.simulador.servicio.excepciones.OpcionRespuestaNoExisteException;
import co.edu.poli.cnt.simulador.servicio.excepciones.PreguntaInvalidaException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la entidad Pregunta.
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class PreguntaEntityTest {

    PreguntaEntity preguntaSeleccionUnica;
    PreguntaEntity preguntaSeleccionMultiple;

    @Before
    public void initData() {
        /* RESPUESTA DE SELECCIÓN ÚNICA */
        preguntaSeleccionUnica = new PreguntaEntity();
        preguntaSeleccionUnica.setTipoPregunta(TipoPregunta.SELECCION_UNICA);
        preguntaSeleccionUnica.setContenido("contenido de prueba");
        preguntaSeleccionUnica.setFragmentoCodigo("fragmento de código de prueba");

        List<OpcionRespuestaEntity> respuestas = new ArrayList<>();
        OpcionRespuestaEntity op = new OpcionRespuestaEntity();
        op.setId(1L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(2L);
        op.setContenido("test");
        op.setOpcionCorrecta(true);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(3L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(4L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(5L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);

        preguntaSeleccionUnica.setOpcionesRespuesta(respuestas);

        /* RESPUESTA DE SELECCIÓN MÚLTIPLE */
        preguntaSeleccionMultiple = new PreguntaEntity();
        preguntaSeleccionMultiple.setTipoPregunta(TipoPregunta.SELECCION_MULTIPLE);
        preguntaSeleccionMultiple.setContenido("contenido de prueba");
        preguntaSeleccionMultiple.setFragmentoCodigo("fragmento de código de prueba");

        respuestas = new ArrayList<>();
        op = new OpcionRespuestaEntity();
        op.setId(6L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(7L);
        op.setContenido("test");
        op.setOpcionCorrecta(true);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(8L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(9L);
        op.setContenido("test");
        op.setOpcionCorrecta(false);
        respuestas.add(op);
        op = new OpcionRespuestaEntity();
        op.setId(10L);
        op.setContenido("test");
        op.setOpcionCorrecta(true);
        respuestas.add(op);

        preguntaSeleccionMultiple.setOpcionesRespuesta(respuestas);
    }

    @Test
    public void calificarPreguntaSeleccionUnicaRespuestaCorrectaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuesta correcta
        preguntaSeleccionUnica.marcarOpcionRespuesta(2L);
        Assert.assertTrue(preguntaSeleccionUnica.calificarPregunta());
    }

    @Test
    public void calificarPreguntaSeleccionUnicaRespuestaIncorrectaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuesta incorrecta
        preguntaSeleccionUnica.marcarOpcionRespuesta(1L);
        Assert.assertFalse(preguntaSeleccionUnica.calificarPregunta());
    }

    @Test(expected = PreguntaInvalidaException.class)
    public void calificarPreguntaSeleccionUnicaNingunaRespuestaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // no ingresar ninguna respuesta
        preguntaSeleccionUnica.calificarPregunta();
    }

    @Test(expected = PreguntaInvalidaException.class)
    public void calificarPreguntaSeleccionUnicaMasDeUnaRespuestaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar más de una respuesta
        preguntaSeleccionUnica.marcarOpcionRespuesta(1L);
        preguntaSeleccionUnica.marcarOpcionRespuesta(2L);
        preguntaSeleccionUnica.calificarPregunta();
    }
    
    @Test(expected = PreguntaInvalidaException.class)
    public void calificarPreguntaSeleccionMultipleNingunaRespuestaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // no ingresar ninguna respuesta
        preguntaSeleccionUnica.calificarPregunta();
    }

    @Test
    public void calificarPreguntaSeleccionMultipleRespuestasCorrectasTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuestas correctas completas
        preguntaSeleccionMultiple.marcarOpcionRespuesta(7L);
        preguntaSeleccionMultiple.marcarOpcionRespuesta(10L);
        Assert.assertTrue(preguntaSeleccionMultiple.calificarPregunta());
    }

    @Test
    public void calificarPreguntaSeleccionMultipleRespuestasDeMasTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuestas correctas completas y adicionales incorrectas
        preguntaSeleccionMultiple.marcarOpcionRespuesta(7L);
        preguntaSeleccionMultiple.marcarOpcionRespuesta(10L);
        preguntaSeleccionMultiple.marcarOpcionRespuesta(8L);
        Assert.assertFalse(preguntaSeleccionMultiple.calificarPregunta());
    }

    @Test
    public void calificarPreguntaSeleccionMultipleIncompletaTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuestas correctas incompletas
        preguntaSeleccionMultiple.marcarOpcionRespuesta(7L);
        Assert.assertFalse(preguntaSeleccionMultiple.calificarPregunta());
    }

    @Test
    public void calificarPreguntaSeleccionMultipleIncorrectasTest() throws OpcionRespuestaNoExisteException, PreguntaInvalidaException {
        // ingresar respuestas incorrectas
        // ingresar respuestas correctas completas
        preguntaSeleccionMultiple.marcarOpcionRespuesta(8L);
        preguntaSeleccionMultiple.marcarOpcionRespuesta(9L);
        Assert.assertFalse(preguntaSeleccionMultiple.calificarPregunta());
    }

}
