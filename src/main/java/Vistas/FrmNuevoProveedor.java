package Vistas;

import java.awt.Dimension;

public class FrmNuevoProveedor extends javax.swing.JInternalFrame {

    public FrmNuevoProveedor() {
        initComponents();
        this.setSize(new Dimension(400,200));
        this.setTitle("Nuevo Proveedor");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnGuardarProveedor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nuevo Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setText("Nombre: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("Telefono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        getContentPane().add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 220, -1));
        getContentPane().add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, -1));

        btnGuardarProveedor.setText("Guardar");
        getContentPane().add(btnGuardarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables

    public void txtNombreProveedor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void txtTelefonoProveedor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
