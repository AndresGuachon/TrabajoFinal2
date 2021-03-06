/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ListaEnlazada;
import controlador.tablaInmuebles;
import controlador.utiles.TipoOrdenacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.inmuebles;

/**
 *
 * @author 
 */
public class viewInmuebles extends javax.swing.JFrame {

    ListaEnlazada<inmuebles> listaIn = new ListaEnlazada<>();
    tablaInmuebles tp = new tablaInmuebles();
    DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form ventana
     */
    public viewInmuebles() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /*public void cargarTabla(){
        tp.setLista(listaIn);
        jTable1.setModel(tp);
        jTable1.updateUI();
    }*/
    void agregar() {
        if (!"".equals(jTextField2.getText()) && !"".equals(jTextField3.getText()) && !"".equals(jTextField4.getText()) && !"".equals(jTextField4.getText()) && !"--Seleccionar--".equals(jComboBox5.getSelectedItem().toString())) {
            int c = 0;
            // List<inmuebles> listProductos = proSQL.informacion();
            Integer ID = Integer.parseInt(jTextField2.getText());
            String Tipo = jComboBox5.getSelectedItem().toString();
            Integer Precio = Integer.parseInt(jTextField3.getText());
            Integer Area = Integer.parseInt(jTextField4.getText());

            Object[] object = new Object[6];
            object[0] = ID;
            object[1] = Tipo;
            object[2] = Precio;
            object[3] = Area;
            listaIn.agregar(object);
            modelo = (DefaultTableModel) jTable1.getModel();
            modelo.addRow(object);
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jComboBox5.setSelectedItem("--Seleccionar--");

        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos ");
        }
    }

    void editar() {
        if (jTable1.getSelectedRow() >= 0) {
            Integer ID = Integer.parseInt(jTextField2.getText());
            String Tipo = jComboBox5.getSelectedItem().toString();
            Integer Precio = Integer.parseInt(jTextField3.getText());
            Integer Area = Integer.parseInt(jTextField4.getText());

            Object[] objet = new Object[4];
            objet[0] = ID;
            objet[1] = Tipo;
            objet[2] = Precio;
            objet[3] = Area;
            listaIn.editar(objet);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Inmueble a editar!");
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID ", "TIPO", "PRECIO", "AREA(m2)"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Ordenar:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASCENDENTE", "DESCENDENTE" }));

        jLabel2.setText("Atributo:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tipo", "Precio", "Area" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Inmuebles");

        jLabel7.setText("ID:");

        jLabel9.setText("Precio:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "naturaleza", "incorporaci??n", "destino", "analog??a" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipo:");

        jLabel11.setText("Area:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(89, 89, 89))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(2, 2, 2)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton4)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel6)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*if (jComboBox4.getSelectedItem().equals("Shell")) {
        if (jComboBox1.getSelectedItem().equals("ASCENDENTE")&&jComboBox2.getSelectedItem().equals("ID")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("IDPersona", TipoOrdenacion.ASCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (jComboBox1.getSelectedItem().equals("DESCENDENTE")&&jComboBox2.getSelectedItem().equals("ID")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("IDPersona", TipoOrdenacion.DESCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (jComboBox1.getSelectedItem().equals("ASCENDENTE")&&jComboBox2.getSelectedItem().equals("Nombre")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("nombre", TipoOrdenacion.ASCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (jComboBox1.getSelectedItem().equals("DESCENDENTE")&&jComboBox2.getSelectedItem().equals("Nombre")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("nombre", TipoOrdenacion.DESCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (jComboBox1.getSelectedItem().equals("ASCENDENTE")&&jComboBox2.getSelectedItem().equals("Edad")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("edad", TipoOrdenacion.ASCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (jComboBox1.getSelectedItem().equals("DESCENDENTE")&&jComboBox2.getSelectedItem().equals("Edad")) {
            try {
                long inicio = System.currentTimeMillis();
                listaIn.shell("edad", TipoOrdenacion.DESCENDENTE);
                cargarTabla();
                long fin = System.currentTimeMillis();
                JOptionPane.showMessageDialog(null, "Tiempo total: "+((double) (fin - inicio) / 1000)+"s");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        }else if (jComboBox4.getSelectedItem().equals("QuickSort")) {
            if (jComboBox1.getSelectedItem().equals("ASCENDENTE") && jComboBox2.getSelectedItem().equals("ID")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortID(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.ASCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (jComboBox1.getSelectedItem().equals("DESCENDENTE") && jComboBox2.getSelectedItem().equals("ID")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortID(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.DESCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (jComboBox1.getSelectedItem().equals("ASCENDENTE") && jComboBox2.getSelectedItem().equals("Nombre")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortNombre(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.ASCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (jComboBox1.getSelectedItem().equals("DESCENDENTE") && jComboBox2.getSelectedItem().equals("Nombre")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortNombre(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.DESCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (jComboBox1.getSelectedItem().equals("ASCENDENTE") && jComboBox2.getSelectedItem().equals("Edad")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortedad(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.ASCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (jComboBox1.getSelectedItem().equals("DESCENDENTE") && jComboBox2.getSelectedItem().equals("Edad")) {
                try {
                    long inicio = System.currentTimeMillis();
                    listaIn.QuickSortedad(listaIn, 0, listaIn.getSize()-1, TipoOrdenacion.DESCENDENTE);
                    cargarTabla();
                    long fin = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, "Tiempo total: " + ((double) (fin - inicio) / 1000) + "s");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      agregar();
        /*for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.removeRow(i);
                i=i-1;
            }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       editar();
for (int i = 0; i < modelo.getRowCount(); i++) {
                modelo.removeRow(i);
                i=i-1;
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
  int ID;
ID = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
        jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
        jComboBox5.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
        jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(viewInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewInmuebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewInmuebles().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
