package Controladores.CtrlProveedor;

import Vistas.FrmNuevoProveedor;
import Modelos.Proveedor;
import Modelos.ProveedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlNuevoProveedor implements ActionListener {

    private Proveedor proveedor;
    private FrmNuevoProveedor form;
    private ProveedorDAO dao;
    private ArrayList<Proveedor> proveedores;

    public CtrlNuevoProveedor(Proveedor proveedor, FrmNuevoProveedor form, ProveedorDAO dao) {
        this.proveedor = proveedor;
        this.form = form;
        this.dao = dao;

        this.form.btnGuardarProveedor.addActionListener(this);
    }

    public void limpiarCampos() {
        form.txtNombreProveedor.setText("");
        form.txtTelefonoProveedor.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form.btnGuardarProveedor) {
            try {
                String nombre = form.txtNombreProveedor.getText();

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre del Proveedor es obligatorio.");
                    return;
                }
                
                if (dao.existeProveedor(nombre)) {
                    JOptionPane.showMessageDialog(null, "Ya existe un proveedor registrado con ese nombre.");
                    return;
                }

                String telefono = form.txtTelefonoProveedor.getText();

                String regexTelefono = "^[267]\\d{3}-?\\d{4}$";
                if (!telefono.matches(regexTelefono) && !telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto. Ejemplos válidos: 7123-4567 o 71234567.");
                    return;
                }

                proveedor.setNombre(nombre);
                proveedor.setTelefono(telefono);

                if (dao.registrar(proveedor)) {
                    JOptionPane.showMessageDialog(null, "¡Proveedor creada exitosamente!");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear el Proveedor.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en el formato de los datos.");
                System.out.println(ex);
            }
        }
    }
}
