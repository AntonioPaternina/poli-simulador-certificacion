package co.edu.poli.cnt.simulador.vista;

import co.edu.poli.cnt.simulador.modelo.PreguntaEntity;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class ListaPreguntaCellRenderer extends JButton implements ListCellRenderer<PreguntaEntity> {

    @Override
    public Component getListCellRendererComponent(JList<? extends PreguntaEntity> list, PreguntaEntity value, int index, boolean isSelected, boolean cellHasFocus) {

        setText(String.valueOf(++index));
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);

        return this;
    }

}
