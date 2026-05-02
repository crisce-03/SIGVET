/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Conexion {

    public static final String URL = "jdbc:mysql://root:qldGtynJdBTBChZqtqpWzmgqJfFxAOyL@switchback.proxy.rlwy.net:46593/SIGVET";
    private static final String USER = "root";
    private static final String PASSWORD = "qldGtynJdBTBChZqtqpWzmgqJfFxAOyL";

    public Connection conectar() {
        Connection conexion = null;

        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con usuario root y sin clave
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión a la base de datos de XAMPP exitosa!");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: Faltan las librerías del Driver JDBC.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: Verifica que el servicio de MySQL esté en ejecución. Detalle: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Conexion db = new Conexion();
        Connection conn = db.conectar();

        if (conn != null) {
            System.out.println("¡Todo listo! La conexión funciona perfectamente.");
        } else {
            System.out.println("Hubo un problema al conectar. Revisa que el servicio de MySQL esté corriendo.");
        }
    }
}
