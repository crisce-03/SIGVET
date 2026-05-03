/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores.CtrlProveedor;

import Modelos.Proveedor;
import Modelos.ProveedorDAO;
import Vistas.FrmGestionarProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class CtrlGestionarProveedores implements ActionListener {

    private Proveedor proveedor;
    private FrmGestionarProveedores form;
    private ProveedorDAO dao;
    private ArrayList<Proveedor> proveedores;

    public CtrlGestionarProveedores(Proveedor proveedor, FrmGestionarProveedores form, ProveedorDAO dao) {
        this.proveedor = proveedor;
        this.form = form;
        this.dao = dao;

        this.form.btnActualizar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);

        this.form.TableProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cargarDatosFilaSeleccionada();
            }
        });
    }

    public void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) Vistas.FrmGestionarProveedores.TableProveedores.getModel();
        modeloTabla.setRowCount(0);

        proveedores = dao.listar();
        Object[] fila = new Object[4];

        for (Proveedor p : proveedores) {
            fila[0] = p.getId();
            fila[1] = p.getNombre();
            fila[2] = p.getTelefono();
            fila[3] = p.getEstado();
            modeloTabla.addRow(fila);
        }
    }
    
    public void limpiarCampos() {
        form.txtNombre.setText("");
        form.txtTelefono.setText("");
        form.cmbEstado.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == form.btnActualizar) {
            int filaSeleccionada = form.TableProveedores.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla para actualizar.");
                return;
            }

            try {
                int id = Integer.parseInt(form.TableProveedores.getValueAt(filaSeleccionada, 0).toString());

                String nombre = form.txtNombre.getText().trim();
                String telefono = form.txtTelefono.getText().trim();
                String estado = form.cmbEstado.getSelectedItem().toString();

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                    return;
                }

                String regexTelefono = "^[267]\\d{3}-?\\d{4}$";
                if (!telefono.matches(regexTelefono) && !telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto. Ej: 7123-4567");
                    return;
                }

                proveedor.setId(id);
                proveedor.setNombre(nombre);
                proveedor.setTelefono(telefono);
                proveedor.setEstado(estado);

                if (dao.actualizar(proveedor)) {
                    JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito.");
                    cargarTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor en la base de datos.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al procesar los datos: " + ex.getMessage());
                System.out.println(ex);
            }
        }

        if (e.getSource() == form.btnEliminar) {
            int filaSeleccionada = form.TableProveedores.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla para eliminar.");
                return;
            }

            try {
                int id = Integer.parseInt(form.TableProveedores.getValueAt(filaSeleccionada, 0).toString());

                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro que desea eliminar este proveedor?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (dao.eliminar(id)) {
                        JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.");
                        cargarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor. Es posible que tenga registros asociados.");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar: " + ex.getMessage());
                System.out.println(ex);
            }
        }


    }   
    
        public void cargarDatosFilaSeleccionada() {
        int fila = form.TableProveedores.getSelectedRow();

        if (fila >= 0) {
            String nombre = form.TableProveedores.getValueAt(fila, 1).toString();
            String telefono = form.TableProveedores.getValueAt(fila, 2).toString();
            String estado = form.TableProveedores.getValueAt(fila, 3).toString();

            form.txtNombre.setText(nombre);
            form.txtTelefono.setText(telefono);
            form.cmbEstado.setSelectedItem(estado);
        }
    }
}