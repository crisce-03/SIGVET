/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ProveedorDAO {

    Conexion con = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean registrar(Proveedor proveedor) {
        String sql = "INSERT INTO PROVEEDORES (nombre_empresa,telefono) VALUES(?,?);";

        Connection conexion = con.conectar();

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getTelefono());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar cuenta: " + e.getMessage());
            return false;
        }
    }

    
    public boolean existeProveedor(String nombre) {
        
        String sql = "SELECT id_proveedor FROM PROVEEDORES WHERE nombre_empresa = ?";

        try (Connection conexion = con.conectar(); 
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            System.out.println("Error al verificar existencia de proveedor: " + e.toString());
            return false;
        }
    }
    
    public ArrayList<Proveedor> listar(){
        ArrayList<Proveedor> proveedores=new ArrayList<>();
        String sql="SELECT * FROM PROVEEDORES ORDER BY estado";
        Connection conexion = con.conectar();
        
        try{
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Proveedor proveedor =new Proveedor();
                proveedor.setId(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre_empresa"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getString("estado"));
                
                proveedores.add(proveedor);
            }
        }catch(SQLException e){
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }
        
        return  proveedores;
    }
    
    public boolean eliminar(int id){
        String sql="DELETE FROM PROVEEDORES WHERE id_proveedor=?";
        
        Connection conexion = con.conectar();
        
        try{
            ps=conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas=ps.executeUpdate();
         
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
            
        }catch(SQLException e){
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
        }
        return false;
    }
    
    public boolean actualizar(Proveedor p){
        String sql="UPDATE PROVEEDORES SET nombre_empresa=?,telefono=?,estado=? WHERE id_proveedor=?";
        
        Connection conexion = con.conectar();
        
        try{
            ps=conexion.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2,p.getTelefono());
            ps.setString(3,p.getEstado());
            ps.setInt(4,p.getId());
            int filasAfectadas=ps.executeUpdate();
         
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
            
        }catch(SQLException e){
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
        }
        return false;
    }

}
