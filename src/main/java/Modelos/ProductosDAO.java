/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Conexion.Conexion;
import Modelos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class ProductosDAO {
     Conexion cn = new Conexion();

          public boolean guardarProductoBasico(String codigoBarras, String nombre, int idCategoria) {
                     String sql = "INSERT INTO PRODUCTOS "
                    + "(codigo_barras, nombre, descripcion_tecnica, porcentaje_iva_default, imagen_url, estado, id_categoria) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";

          try {
                     Connection con = cn.conectar();
                     PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, codigoBarras);
                    ps.setString(2, nombre);
                    ps.setString(3, "");
                    ps.setDouble(4, 13.0);
                    ps.setString(5, "");
                    ps.setString(6, "Activo");
                    ps.setInt(7, idCategoria);

                    int resultado = ps.executeUpdate();

                    ps.close();
                    con.close();

                      return resultado > 0;
 
           } catch (SQLException e) {
                     System.out.println("Error al guardar producto básico: " + e.getMessage());
                    return false;
                     }
          }
     
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> lista = new ArrayList<>();

        String sql = "SELECT id_producto, codigo_barras, nombre, descripcion_tecnica, "
                + "porcentaje_iva_detalle, imagen_url, estado, id_categoria "
                + "FROM PRODUCTOS ORDER BY id_producto DESC";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setCodigoBarras(rs.getString("codigo_barras"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcionTecnica(rs.getString("descripcion_tecnica"));
                producto.setPorcentajeIvaDetalle(rs.getDouble("porcentaje_iva_default"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                producto.setEstado(rs.getString("estado"));
                producto.setIdCategoria(rs.getInt("id_categoria"));

                lista.add(producto);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    public boolean guardarProducto(Producto producto) {
        String sql = "INSERT INTO PRODUCTOS "
                + "(codigo_barras, nombre, descripcion_tecnica, porcentaje_iva_default, imagen_url, estado, id_categoria) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getCodigoBarras());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcionTecnica());
            ps.setDouble(4, producto.getPorcentajeIvaDetalle());
            ps.setString(5, producto.getImagenUrl());
            ps.setString(6, producto.getEstado());
            ps.setInt(7, producto.getIdCategoria());

            int resultado = ps.executeUpdate();

            ps.close();
            con.close();

            return resultado > 0;

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE PRODUCTOS SET codigo_barras=?, nombre=?, descripcion_tecnica=?, "
                + "porcentaje_iva_default=?, imagen_url=?, estado=?, id_categoria=? "
                + "WHERE id_producto=?";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, producto.getCodigoBarras());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcionTecnica());
            ps.setDouble(4, producto.getPorcentajeIvaDetalle());
            ps.setString(5, producto.getImagenUrl());
            ps.setString(6, producto.getEstado());
            ps.setInt(7, producto.getIdCategoria());
            ps.setInt(8, producto.getIdProducto());

            int resultado = ps.executeUpdate();

            ps.close();
            con.close();

            return resultado > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "UPDATE PRODUCTOS SET estado='Inactivo' WHERE id_producto=?";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idProducto);

            int resultado = ps.executeUpdate();

            ps.close();
            con.close();

            return resultado > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Producto> buscarProductos(String texto) {
        ArrayList<Producto> lista = new ArrayList<>();

        String sql = "SELECT id_producto, codigo_barras, nombre, descripcion_tecnica, "
                + "porcentaje_iva_default, imagen_url, estado, id_categoria "
                + "FROM PRODUCTOS "
                + "WHERE nombre LIKE ? OR codigo_barras LIKE ? OR descripcion_tecnica LIKE ? "
                + "ORDER BY id_producto DESC";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ps.setString(3, "%" + texto + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setCodigoBarras(rs.getString("codigo_barras"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcionTecnica(rs.getString("descripcion_tecnica"));
                producto.setPorcentajeIvaDetalle(rs.getDouble("porcentaje_iva_detalle"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                producto.setEstado(rs.getString("estado"));
                producto.setIdCategoria(rs.getInt("id_categoria"));

                lista.add(producto);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar productos: " + e.getMessage());
        }

        return lista;
    }

    public ArrayList<String> listarCategoriasCombo() {
        ArrayList<String> lista = new ArrayList<>();

        String sql = "SELECT id_categoria, nombre FROM CATEGORIAS WHERE estado='Activo' ORDER BY nombre";

        try {
            Connection con = cn.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String categoria = rs.getInt("id_categoria") + " - " + rs.getString("nombre");
                lista.add(categoria);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al listar categorías: " + e.getMessage());
        }

        return lista;
    }
    
    public ArrayList<String> listarLotesProductosCombo() {
    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT l.id_lote, p.nombre, l.numero_lote, l.precio_venta "
            + "FROM LOTES l "
            + "INNER JOIN PRODUCTOS p ON p.id_producto = l.id_producto "
            + "WHERE l.estado='Activo' AND p.estado='Activo' "
            + "ORDER BY p.nombre";

    try {
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String item = rs.getInt("id_lote")
                    + " - "
                    + rs.getString("nombre")
                    + " | Lote: "
                    + rs.getString("numero_lote")
                    + " | Precio: $"
                    + rs.getDouble("precio_venta");

            lista.add(item);
        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error al listar lotes/productos: " + e.getMessage());
    }

    return lista;
}

public boolean registrarAjusteInventario(String tipoMovimiento, int cantidad, String motivoAjuste, int idLote, int idUsuario) {
    String sql = "INSERT INTO KARDEX "
            + "(tipo_movimiento, cantidad, fecha_hora, precio_compra, precio_venta, motivo_ajuste, id_lote, id_usuario, id_venta, id_compra) "
            + "SELECT ?, ?, NOW(), precio_compra, precio_venta, ?, id_lote, ?, NULL, NULL "
            + "FROM LOTES "
            + "WHERE id_lote = ?";

    try {
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, tipoMovimiento);
        ps.setInt(2, cantidad);
        ps.setString(3, motivoAjuste);
        ps.setInt(4, idUsuario);
        ps.setInt(5, idLote);

        int resultado = ps.executeUpdate();

        ps.close();
        con.close();

        return resultado > 0;

    } catch (SQLException e) {
        System.out.println("Error al registrar ajuste de inventario: " + e.getMessage());
        return false;
    }
}

public ArrayList<Object[]> listarAjustesInventario() {
    ArrayList<Object[]> lista = new ArrayList<>();

    String sql = "SELECT k.id_movimiento, k.tipo_movimiento, k.cantidad, k.fecha_hora, "
            + "k.precio_compra, k.precio_venta, k.motivo_ajuste, "
            + "p.nombre AS producto, l.numero_lote, k.id_usuario "
            + "FROM KARDEX k "
            + "INNER JOIN LOTES l ON l.id_lote = k.id_lote "
            + "INNER JOIN PRODUCTOS p ON p.id_producto = l.id_producto "
            + "WHERE k.tipo_movimiento IN ('AJUSTE_ENTRADA', 'AJUSTE_SALIDA') "
            + "ORDER BY k.id_movimiento DESC "
            + "LIMIT 50";

    try {
        Connection con = cn.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[]{
                rs.getInt("id_movimiento"),
                rs.getString("tipo_movimiento"),
                rs.getInt("cantidad"),
                rs.getString("fecha_hora"),
                rs.getDouble("precio_compra"),
                rs.getDouble("precio_venta"),
                rs.getString("motivo_ajuste"),
                rs.getString("producto"),
                rs.getString("numero_lote"),
                rs.getInt("id_usuario")
            };

            lista.add(fila);
        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {
        System.out.println("Error al listar ajustes de inventario: " + e.getMessage());
    }

    return lista;
}
    
}
