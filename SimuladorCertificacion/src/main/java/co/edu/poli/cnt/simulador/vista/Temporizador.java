package co.edu.poli.cnt.simulador.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class Temporizador extends JLabel implements ActionListener {

    private static final Logger LOGGER = Logger.getLogger(Temporizador.class.getName());

    private Duration duracion;
    private ActionListener actionListener;
    private Timer temporizador;

    public Temporizador() {
    }

    /**
     *
     * @param tiempo el tiempo total del temporizador
     * @param actionListener
     */
    public void inicializar(int tiempo, ActionListener actionListener) {
        this.duracion = Duration.ofSeconds(tiempo);
        this.actionListener = actionListener;
        temporizador = new Timer(1000, this);
        temporizador.start();
        calcularTiempo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.duracion = this.duracion.minusSeconds(1);
        calcularTiempo();
        if (duracion.getSeconds() == 0) {
            LOGGER.log(Level.FINE, String.valueOf(duracion.getSeconds()));
            this.actionListener.actionPerformed(e);
            this.temporizador.stop();
        }
    }

    private void calcularTiempo() {
        long horas = this.duracion.toHours();
        long minutos = this.duracion.minusHours(horas).toMinutes();
        long segundos = this.duracion.minusHours(horas).minusMinutes(minutos).getSeconds();
        String temporizadorString = horas + ":" + minutos + ":" + segundos;
        LOGGER.log(Level.FINE, temporizadorString);
        this.setText(temporizadorString);
    }

}
