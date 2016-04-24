package co.edu.poli.cnt.simulador.vista;

import co.edu.poli.cnt.simulador.modelo.OpcionRespuestaEntity;
import co.edu.poli.cnt.simulador.modelo.PreguntaEntity;
import co.edu.poli.cnt.simulador.modelo.TipoPregunta;
import co.edu.poli.cnt.simulador.repositorio.PreguntaRepositorio;
import co.edu.poli.cnt.simulador.repositorio.PreguntaRepositorioImpl;
import co.edu.poli.cnt.simulador.servicio.excepciones.OpcionRespuestaNoExisteException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class PanelExamen extends JPanel {

    private static final Logger LOGGER = Logger.getLogger(PanelExamen.class.getName());

    private PreguntaRepositorio preguntaRepositorio;
    private final List<PreguntaEntity> preguntas;
    private int indicePreguntaActual;

    /**
     * Creates new form PanelExamen
     */
    public PanelExamen() {
        JPanel estePanel = this;
        initComponents();
        preguntaRepositorio = PreguntaRepositorioImpl.getInstancia();

        // cargar las preguntas del examen
        preguntas = preguntaRepositorio.getAllPreguntaEntity();
        LOGGER.info(preguntas);
        listaPreguntas.setModel(new AbstractListModel<PreguntaEntity>() {
            @Override
            public int getSize() {
                return preguntas.size();
            }

            @Override
            public PreguntaEntity getElementAt(int index) {
                return preguntas.get(index);
            }
        });
        listaPreguntas.setCellRenderer(new ListaPreguntaCellRenderer());
        listaPreguntas.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPreguntas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // mostrar pregunta actual
        mostrarPreguntaActual();

        // iniciar el temporizador
        this.temporizador.inicializar(60 * 100 - 1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // mostrar panel de resultado
                VistaPrincipal vistaPrincipal = (VistaPrincipal) SwingUtilities.getWindowAncestor(estePanel);
                vistaPrincipal.mostrarPanelResultado(preguntas);
            }
        });
    }

    public void mostrarPreguntaActual() {
        limpiarTodo();

        StringBuilder textoPregunta = new StringBuilder();
        PreguntaEntity preguntaActual = getPreguntaActual();

        // mostrar encabezado pregunta
        if (StringUtils.isNotBlank(preguntaActual.getTextoInicio())) {
            textoPregunta.append(preguntaActual.getTextoInicio());
            textoPregunta.append("\n\n");
        }

        // mostrar código pregunta
        if (StringUtils.isNotBlank(preguntaActual.getFragmentoCodigo())) {
            textoPregunta.append(preguntaActual.getFragmentoCodigo());
            textoPregunta.append("\n\n");
        }

        // mostrar encabezado respuestas
        if (StringUtils.isNotBlank(preguntaActual.getTextoFin())) {
            textoPregunta.append(preguntaActual.getTextoFin());
        }

        // mostrar pregunta
        textAreaPregunta.setText(textoPregunta.toString());

        // seleccionar la pregunta actual en el panel de navegación de preguntas
        listaPreguntas.setSelectedIndex(indicePreguntaActual);

        // marcar el check de revisión en caso de aplicar
        checkMarcar.setSelected(preguntaActual.isMarcadoRevision());

        // renderizar respuestas
        mostrarRespuestas();
    }

    private void mostrarRespuestas() {
        // limpiar respuestas anteriores
        panelRespuestas.removeAll();
        PreguntaEntity preguntaActual = getPreguntaActual();
        // determinar si es seleccion unica o multiple
        TipoPregunta tipoPregunta = preguntaActual.getTipoPregunta();
        switch (tipoPregunta) {
            case SELECCION_UNICA:
                ButtonGroup grupoBotones = new ButtonGroup();
                for (int i = 0; i < preguntaActual.getOpcionesRespuesta().size(); i++) {
                    OpcionRespuestaEntity respuesta = preguntaActual.getOpcionesRespuesta().get(i);
                    JRadioButton radioButton = new JRadioButton((i + 1) + ". " + respuesta.getContenido());
                    radioButton.setActionCommand(String.valueOf(respuesta.getId()));
                    grupoBotones.add(radioButton);
                    if (respuesta.isElegida()) {
                        radioButton.setSelected(true);
                    }
                    radioButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                int idRespuesta = Integer.parseInt(e.getActionCommand());
                                preguntaActual.marcarOpcionRespuesta(idRespuesta);
                            } catch (OpcionRespuestaNoExisteException ex) {
                                java.util.logging.Logger.getLogger(PanelExamen.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    panelRespuestas.add(radioButton);
                }
                break;
            case SELECCION_MULTIPLE:
                break;
            default:
                // no hacer nada
                break;
        }
    }

    private PreguntaEntity getPreguntaActual() {
        return preguntas.get(indicePreguntaActual);
    }

    private void limpiarTodo() {
        textAreaPregunta.setText("");
        panelRespuestas.removeAll();
        panelRespuestas.revalidate();
        panelRespuestas.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEncabezado = new javax.swing.JPanel();
        temporizador = new co.edu.poli.cnt.simulador.vista.Temporizador();
        jLabel1 = new javax.swing.JLabel();
        panelNavegadorDePreguntas = new javax.swing.JPanel();
        scrollPaneListaPreguntas = new javax.swing.JScrollPane();
        listaPreguntas = new javax.swing.JList<>();
        panelControles = new javax.swing.JPanel();
        botonSiguiente = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        checkMarcar = new javax.swing.JCheckBox();
        botonTerminar = new javax.swing.JButton();
        panelPregunta = new javax.swing.JPanel();
        scrollAreaPregunta = new javax.swing.JScrollPane();
        textAreaPregunta = new javax.swing.JTextArea();
        scrollAreaRespuestas = new javax.swing.JScrollPane();
        panelRespuestas = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1280, 800));

        panelEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Simulador de Certificación OCPJP8");

        javax.swing.GroupLayout panelEncabezadoLayout = new javax.swing.GroupLayout(panelEncabezado);
        panelEncabezado.setLayout(panelEncabezadoLayout);
        panelEncabezadoLayout.setHorizontalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEncabezadoLayout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(temporizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEncabezadoLayout.setVerticalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(temporizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelNavegadorDePreguntas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelNavegadorDePreguntas.setPreferredSize(new java.awt.Dimension(150, 340));

        listaPreguntas.setModel(new javax.swing.AbstractListModel<PreguntaEntity>() {
            public int getSize() { return 0; }
            public PreguntaEntity getElementAt(int i) { return null; }
        });
        listaPreguntas.setFixedCellHeight(40);
        listaPreguntas.setFixedCellWidth(40);
        listaPreguntas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPreguntasMouseClicked(evt);
            }
        });
        scrollPaneListaPreguntas.setViewportView(listaPreguntas);

        javax.swing.GroupLayout panelNavegadorDePreguntasLayout = new javax.swing.GroupLayout(panelNavegadorDePreguntas);
        panelNavegadorDePreguntas.setLayout(panelNavegadorDePreguntasLayout);
        panelNavegadorDePreguntasLayout.setHorizontalGroup(
            panelNavegadorDePreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavegadorDePreguntasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneListaPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelNavegadorDePreguntasLayout.setVerticalGroup(
            panelNavegadorDePreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavegadorDePreguntasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneListaPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelControles.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botonSiguiente.setText("siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAnterior.setText("anterior");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        checkMarcar.setText("marcar");
        checkMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMarcarActionPerformed(evt);
            }
        });

        botonTerminar.setText("Terminar");
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelControlesLayout = new javax.swing.GroupLayout(panelControles);
        panelControles.setLayout(panelControlesLayout);
        panelControlesLayout.setHorizontalGroup(
            panelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonTerminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 705, Short.MAX_VALUE)
                .addComponent(checkMarcar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSiguiente)
                .addContainerGap())
        );

        panelControlesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAnterior, botonSiguiente});

        panelControlesLayout.setVerticalGroup(
            panelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesLayout.createSequentialGroup()
                .addGroup(panelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSiguiente)
                    .addComponent(botonAnterior)
                    .addComponent(checkMarcar)
                    .addComponent(botonTerminar))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        panelPregunta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textAreaPregunta.setEditable(false);
        textAreaPregunta.setColumns(20);
        textAreaPregunta.setRows(5);
        scrollAreaPregunta.setViewportView(textAreaPregunta);

        panelRespuestas.setLayout(new javax.swing.BoxLayout(panelRespuestas, javax.swing.BoxLayout.PAGE_AXIS));
        scrollAreaRespuestas.setViewportView(panelRespuestas);

        javax.swing.GroupLayout panelPreguntaLayout = new javax.swing.GroupLayout(panelPregunta);
        panelPregunta.setLayout(panelPreguntaLayout);
        panelPreguntaLayout.setHorizontalGroup(
            panelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollAreaPregunta)
                    .addComponent(scrollAreaRespuestas))
                .addContainerGap())
        );
        panelPreguntaLayout.setVerticalGroup(
            panelPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPreguntaLayout.createSequentialGroup()
                .addComponent(scrollAreaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollAreaRespuestas)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelNavegadorDePreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelNavegadorDePreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMarcarActionPerformed
        PreguntaEntity preguntaActual = preguntas.get(indicePreguntaActual);
        preguntaActual.setMarcadoRevision(true);
    }//GEN-LAST:event_checkMarcarActionPerformed

    private void listaPreguntasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPreguntasMouseClicked
        JList list = (JList<PreguntaEntity>) evt.getComponent();
        indicePreguntaActual = list.getSelectedIndex();
        mostrarPreguntaActual();
    }//GEN-LAST:event_listaPreguntasMouseClicked

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        if (indicePreguntaActual > 0) {
            indicePreguntaActual--;
        }
        mostrarPreguntaActual();
    }//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        if (indicePreguntaActual < preguntas.size() - 1) {
            indicePreguntaActual++;
        }
        mostrarPreguntaActual();
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        this.temporizador.detener();
        VistaPrincipal vistaPrincipal = (VistaPrincipal) SwingUtilities.getWindowAncestor(this);
        vistaPrincipal.mostrarPanelResultado(preguntas);
    }//GEN-LAST:event_botonTerminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JCheckBox checkMarcar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<PreguntaEntity> listaPreguntas;
    private javax.swing.JPanel panelControles;
    private javax.swing.JPanel panelEncabezado;
    private javax.swing.JPanel panelNavegadorDePreguntas;
    private javax.swing.JPanel panelPregunta;
    private javax.swing.JPanel panelRespuestas;
    private javax.swing.JScrollPane scrollAreaPregunta;
    private javax.swing.JScrollPane scrollAreaRespuestas;
    private javax.swing.JScrollPane scrollPaneListaPreguntas;
    private co.edu.poli.cnt.simulador.vista.Temporizador temporizador;
    private javax.swing.JTextArea textAreaPregunta;
    // End of variables declaration//GEN-END:variables

}
