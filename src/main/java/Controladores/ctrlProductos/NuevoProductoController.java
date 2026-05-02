/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores.ctrlProductos;

import Modelos.ProductosDAO;
import Vistas.FrmNuevoProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class NuevoProductoController {
    
    private ProductosDAO dao;
    private FrmNuevoProducto vista;

    public NuevoProductoController(FrmNuevoProducto vista) {
        this.dao = new ProductosDAO();
        this.vista = vista;

        configurarVista();
        cargarCategorias();
        agregarEventos();
    }

    private void configurarVista() {
        vista.setTitle("Nuevo Producto");
    }

    private void agregarEventos() {
        vista.btnGuardar.addActionListener(e -> guardarProducto());
        vista.btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void cargarCategorias() {
        vista.cboCategoria.removeAllItems();

        ArrayList<String> categorias = dao.listarCategoriasCombo();

        for (String categoria : categorias) {
            vista.cboCategoria.addItem(categoria);
        }
    }

    private int obtenerIdCategoria() {
        String categoriaSeleccionada = vista.cboCategoria.getSelectedItem().toString();
        String[] partes = categoriaSeleccionada.split(" - ");
        return Integer.parseInt(partes[0]);
    }

    private void guardarProducto() {
        String codigoBarras = vista.txtCodigoBarras.getText().trim();
        String nombre = vista.txtNombre.getText().trim();

        if (codigoBarras.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el código de barras.");
            vista.txtCodigoBarras.requestFocus();
            return;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese el nombre del producto.");
            vista.txtNombre.requestFocus();
            return;
        }

        if (vista.cboCategoria.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(vista, "Seleccione una categoría.");
            return;
        }

        int idCategoria = obtenerIdCategoria();

        boolean guardado = dao.guardarProductoBasico(codigoBarras, nombre, idCategoria);

        if (guardado) {
            JOptionPane.showMessageDialog(vista, "Producto guardado correctamente.");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo guardar el producto.");
        }
    }

    private void limpiarCampos() {
        vista.txtCodigoBarras.setText("");
        vista.txtNombre.setText("");

        if (vista.cboCategoria.getItemCount() > 0) {
            vista.cboCategoria.setSelectedIndex(0);
        }

        vista.txtCodigoBarras.requestFocus();
    }
    
}
