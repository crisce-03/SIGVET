/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores.ctrlProductos;

import Modelos.ProductosDAO;
import Vistas.FrmAjusteInventario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class AjusteInventarioController {
    
    private ProductosDAO dao;
    private FrmAjusteInventario vista;

    public AjusteInventarioController(FrmAjusteInventario vista) {
        this.dao = new ProductosDAO();
        this.vista = vista;

        configurarVista();
        cargarLotesProductos();
        cargarTiposMovimiento();
        listarAjustesTabla();
        agregarEventos();
    }

    private void configurarVista() {
        vista.setTitle("Ajuste de Inventario");

        vista.spCantidad.setModel(new SpinnerNumberModel(1, 1, 9999, 1));

        DefaultTableModel modelo = crearModeloTabla();
        vista.tblAjustes.setModel(modelo);
    }

    private void agregarEventos() {
        vista.btnRegistrarAjuste.addActionListener(e -> registrarAjuste());
        vista.btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void cargarLotesProductos() {
        vista.cboLoteProducto.removeAllItems();

        ArrayList<String> lotes = dao.listarLotesProductosCombo();

        for (String lote : lotes) {
            vista.cboLoteProducto.addItem(lote);
        }
    }

    private void cargarTiposMovimiento() {
        vista.cboTipoMovimiento.removeAllItems();
        vista.cboTipoMovimiento.addItem("AJUSTE_ENTRADA");
        vista.cboTipoMovimiento.addItem("AJUSTE_SALIDA");
    }

    private int obtenerIdLote() {
        String loteSeleccionado = vista.cboLoteProducto.getSelectedItem().toString();
        String[] partes = loteSeleccionado.split(" - ");
        return Integer.parseInt(partes[0]);
    }

    private DefaultTableModel crearModeloTabla() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID Movimiento");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Motivo");
        modelo.addColumn("Producto");
        modelo.addColumn("Lote");
        modelo.addColumn("ID Usuario");

        return modelo;
    }

    private void listarAjustesTabla() {
        DefaultTableModel modelo = crearModeloTabla();

        ArrayList<Object[]> ajustes = dao.listarAjustesInventario();

        for (Object[] fila : ajustes) {
            modelo.addRow(fila);
        }

        vista.tblAjustes.setModel(modelo);
    }

    private void registrarAjuste() {
        try {
            if (vista.cboLoteProducto.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(vista, "Seleccione un producto/lote.");
                return;
            }

            if (vista.cboTipoMovimiento.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(vista, "Seleccione el tipo de movimiento.");
                return;
            }

            String motivo = vista.txtMotivoAjuste.getText().trim();

            if (motivo.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el motivo del ajuste.");
                vista.txtMotivoAjuste.requestFocus();
                return;
            }

            if (vista.txtIdUsuario.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese el ID del usuario.");
                vista.txtIdUsuario.requestFocus();
                return;
            }

            String tipoMovimiento = vista.cboTipoMovimiento.getSelectedItem().toString();
            int cantidad = ((Number) vista.spCantidad.getValue()).intValue();
            int idLote = obtenerIdLote();
            int idUsuario = Integer.parseInt(vista.txtIdUsuario.getText().trim());

            boolean registrado = dao.registrarAjusteInventario(
                    tipoMovimiento,
                    cantidad,
                    motivo,
                    idLote,
                    idUsuario
            );

            if (registrado) {
                JOptionPane.showMessageDialog(vista, "Ajuste registrado correctamente.");
                listarAjustesTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo registrar el ajuste.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El ID de usuario debe ser un número válido.");
        }
    }

    private void limpiarCampos() {
        if (vista.cboLoteProducto.getItemCount() > 0) {
            vista.cboLoteProducto.setSelectedIndex(0);
        }

        if (vista.cboTipoMovimiento.getItemCount() > 0) {
            vista.cboTipoMovimiento.setSelectedIndex(0);
        }

        vista.spCantidad.setValue(1);
        vista.txtMotivoAjuste.setText("");
        vista.txtIdUsuario.setText("");
        vista.txtMotivoAjuste.requestFocus();
    }
    
}
