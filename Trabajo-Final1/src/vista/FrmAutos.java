/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControladorAutos;
import controlador.ControladorMarcas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Autos;
import modelo.Marcas;
import vista.Tablas.TablaMarcas;

/**
 *
 * @author LENOVO LEGION 5
 */
public class FrmAutos extends javax.swing.JFrame {

    /**
     * Creates new form FrmAutos
     */
    public FrmAutos() {
        initComponents();
        controlAutos.cargar();
        controlMarcas.cargar(); 
        cargarTabla();
        cargarTablaM();
    }
    ControladorAutos controlAutos = new ControladorAutos();
    ControladorMarcas controlMarcas = new ControladorMarcas();
    Autos autoSeleccionado = new Autos();
    int pos = -1;
    boolean editar = false;
    int posm = -1;
    boolean editarm = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textf_chasis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textf_modelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textf_color = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textf_precio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_autos = new javax.swing.JTable();
        botn_salir = new javax.swing.JButton();
        lblNotifica = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textf_anio = new javax.swing.JTextField();
        boton_seleccionar = new javax.swing.JButton();
        combob_marca = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        boton_guardar = new javax.swing.JButton();
        boton_editar = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMarcas = new javax.swing.JTable();
        boton_guardar1 = new javax.swing.JButton();
        boton_editar1 = new javax.swing.JButton();
        boton_eliminar1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Vehículo");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 10, 93, 36);

        jLabel2.setText("Chasis:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 50, 30);
        getContentPane().add(textf_chasis);
        textf_chasis.setBounds(50, 60, 140, 30);

        jLabel3.setText("Marca:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(230, 60, 50, 30);

        jLabel4.setText("Modelo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(470, 60, 50, 30);
        getContentPane().add(textf_modelo);
        textf_modelo.setBounds(530, 60, 140, 30);

        jLabel5.setText("Color:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 140, 50, 30);
        getContentPane().add(textf_color);
        textf_color.setBounds(50, 140, 140, 30);

        jLabel6.setText("Precio:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(230, 140, 50, 30);
        getContentPane().add(textf_precio);
        textf_precio.setBounds(280, 140, 140, 30);

        tabla_autos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_autos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo", "Color", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_autos.getTableHeader().setReorderingAllowed(false);
        tabla_autos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_autosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_autos);
        if (tabla_autos.getColumnModel().getColumnCount() > 0) {
            tabla_autos.getColumnModel().getColumn(0).setResizable(false);
            tabla_autos.getColumnModel().getColumn(1).setResizable(false);
            tabla_autos.getColumnModel().getColumn(2).setResizable(false);
            tabla_autos.getColumnModel().getColumn(3).setResizable(false);
            tabla_autos.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 260, 670, 260);

        botn_salir.setText("Salir");
        botn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(botn_salir);
        botn_salir.setBounds(600, 220, 80, 30);
        getContentPane().add(lblNotifica);
        lblNotifica.setBounds(720, 410, 150, 70);

        jLabel7.setText("Año:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(480, 140, 50, 30);
        getContentPane().add(textf_anio);
        textf_anio.setBounds(530, 140, 140, 30);

        boton_seleccionar.setText("Seleccionar");
        boton_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_seleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_seleccionar);
        boton_seleccionar.setBounds(750, 360, 100, 30);

        combob_marca.setModel(new javax.swing.DefaultComboBoxModel<>(controlMarcas.toArray()));
        getContentPane().add(combob_marca);
        combob_marca.setBounds(280, 62, 140, 30);

        jLabel8.setText("Marca:");

        boton_guardar.setText("Guardar");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        boton_editar.setText("Editar");
        boton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editarActionPerformed(evt);
            }
        });

        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblMarcas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(boton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(690, 10, 230, 350);

        boton_guardar1.setText("Guardar");
        boton_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_guardar1);
        boton_guardar1.setBounds(20, 220, 80, 30);

        boton_editar1.setText("Editar");
        boton_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_editar1);
        boton_editar1.setBounds(140, 220, 80, 30);

        boton_eliminar1.setText("Eliminar");
        boton_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton_eliminar1);
        boton_eliminar1.setBounds(260, 220, 80, 30);

        setBounds(0, 0, 929, 539);
    }// </editor-fold>//GEN-END:initComponents

    private void botn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botn_salirActionPerformed
        dispose();
    }//GEN-LAST:event_botn_salirActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        cambiosm();
    }//GEN-LAST:event_boton_guardarActionPerformed
    private void limpiar(){
        textf_anio.setText(null);
        textf_chasis.setText(null);
        textf_color.setText(null);
        textf_modelo.setText(null);
        textf_precio.setText(null);
        txtMarca.setText(null);
    }
    private void cambios(){
        if (textf_chasis.getText().trim().isEmpty() || textf_modelo.getText().trim().isEmpty() || textf_color.getText().trim().isEmpty() || textf_precio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los datos");
        } else {
            pos = tabla_autos.getSelectedRow();
        try {
            if (editar==true) {
                controlAutos.getListaAuto().obtenerDato(pos).setChasis(textf_chasis.getText());
                controlAutos.getListaAuto().obtenerDato(pos).getMarca().setNombres((String) combob_marca.getSelectedItem());
                controlAutos.getListaAuto().obtenerDato(pos).setModelo(textf_modelo.getText());
                controlAutos.getListaAuto().obtenerDato(pos).setColor(textf_color.getText());
                controlAutos.getListaAuto().obtenerDato(pos).setPrecio(Double.parseDouble(textf_precio.getText()));
                controlAutos.getListaAuto().obtenerDato(pos).setAnio(Integer.parseInt(textf_anio.getText()));
                editar=false;
            } else {
                controlAutos.getListaAuto().insertarAlInicio(new Autos(textf_chasis.getText(), new Marcas((String) combob_marca.getSelectedItem()), textf_color.getText(), textf_modelo.getText(), Double.valueOf(textf_precio.getText()), Integer.parseInt(textf_anio.getText())));
            }
            controlAutos.guardar();        // TODO add your handling code here:
            cargarTabla();
            limpiar();
        } catch (IOException ex) {
            Logger.getLogger(FrmAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    private void cambiosm(){
        if (txtMarca.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los datos");
        } else {
            pos = tabla_autos.getSelectedRow();
        try {
            if (editarm==true) {
                controlMarcas.getListaMarcas().obtenerDato(pos).setNombres(txtMarca.getText());
                editarm=false;
            } else {
                controlMarcas.getListaMarcas().insertarAlInicio(new Marcas((String)txtMarca.getText()));
            }
            controlMarcas.guardar();        // TODO add your handling code here:
            cargarTablaM();
            limpiar();
        } catch (IOException ex) {
            Logger.getLogger(FrmAutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    public Autos getAutos() {
        return autoSeleccionado;
    }
    private void boton_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_seleccionarActionPerformed
        if (tabla_autos.getSelectedRow() >= 0) {
            autoSeleccionado = controlAutos.getListaAuto().obtenerDato(tabla_autos.getSelectedRow());
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }

    }//GEN-LAST:event_boton_seleccionarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        if (tblMarcas.getSelectedRow() >= 0) {
            controlMarcas.getListaMarcas().eliminarPosicion(tblMarcas.getSelectedRow());
            cargarTabla();
            try {
                controlMarcas.guardar();
            } catch (IOException ex) {
                Logger.getLogger(FrmAutos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void boton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editarActionPerformed
        editarm = true;
        cambiosm();
    }//GEN-LAST:event_boton_editarActionPerformed

    private void tabla_autosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_autosMouseClicked
        if(evt.getClickCount()==2){
            int fila = tabla_autos.getSelectedRow();
            textf_chasis.setText(controlAutos.getListaAuto().obtenerDato(fila).getChasis());
            textf_color.setText(controlAutos.getListaAuto().obtenerDato(fila).getColor());
            textf_modelo.setText(controlAutos.getListaAuto().obtenerDato(fila).getModelo());
            textf_anio.setText(controlAutos.getListaAuto().obtenerDato(fila).getAnio()+"");
            textf_precio.setText(controlAutos.getListaAuto().obtenerDato(fila).getPrecio()+"");
        }
    }//GEN-LAST:event_tabla_autosMouseClicked

    private void boton_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar1ActionPerformed
        cambios();// TODO add your handling code here:
    }//GEN-LAST:event_boton_guardar1ActionPerformed

    private void boton_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar1ActionPerformed
        editar=true;
        cambios();// TODO add your handling code here:
    }//GEN-LAST:event_boton_editar1ActionPerformed

    private void boton_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminar1ActionPerformed
        if (tabla_autos.getSelectedRow() >= 0) {
            controlAutos.getListaAuto().eliminarPosicion(tabla_autos.getSelectedRow());
            cargarTabla();
            try {
                controlAutos.guardar();
            } catch (IOException ex) {
                Logger.getLogger(FrmAutos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }// TODO add your handling code here:
    }//GEN-LAST:event_boton_eliminar1ActionPerformed
  
    private void cargarTabla() {
        controlAutos.getListaAuto();
        String[] columnas = {"Chasis", "Marca", "Modelo", "Color", "Precio", "Año"};
        String[][] tabla = controlAutos.toArray();
        tabla_autos.removeAll();
        tabla_autos.setModel(new DefaultTableModel(tabla, columnas));
    }
    
    private void cargarTablaM() {
        TablaMarcas tm = new TablaMarcas(controlMarcas.getListaMarcas());
        tblMarcas.setModel(tm);
        tblMarcas.updateUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botn_salir;
    private javax.swing.JButton boton_editar;
    private javax.swing.JButton boton_editar1;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_eliminar1;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JButton boton_guardar1;
    private javax.swing.JButton boton_seleccionar;
    private javax.swing.JComboBox<String> combob_marca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNotifica;
    private javax.swing.JTable tabla_autos;
    private javax.swing.JTable tblMarcas;
    private javax.swing.JTextField textf_anio;
    private javax.swing.JTextField textf_chasis;
    private javax.swing.JTextField textf_color;
    private javax.swing.JTextField textf_modelo;
    private javax.swing.JTextField textf_precio;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables
}
