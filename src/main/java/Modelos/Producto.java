/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Usuario
 */

public class Producto {
    private int idProducto;
    private String codigoBarras;
    private String nombre;
    private String descripcionTecnica;
    private double porcentajeIvaDetalle;//Combo box
    private String imagenUrl;
    private String estado;
    private int idCategoria;

    public Producto() {
    }

    public Producto(int idProducto, String codigoBarras, String nombre, String descripcionTecnica,
                    double porcentajeIvaDetalle, String imagenUrl, String estado, int idCategoria) {
        this.idProducto = idProducto;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.descripcionTecnica = descripcionTecnica;
        this.porcentajeIvaDetalle = porcentajeIvaDetalle;
        this.imagenUrl = imagenUrl;
        this.estado = estado;
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionTecnica() {
        return descripcionTecnica;
    }

    public void setDescripcionTecnica(String descripcionTecnica) {
        this.descripcionTecnica = descripcionTecnica;
    }

    public double  getPorcentajeIvaDetalle() {
        return porcentajeIvaDetalle;
    }

    public void setPorcentajeIvaDetalle(double porcentajeIvaDetalle) {
        this.porcentajeIvaDetalle = porcentajeIvaDetalle;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
