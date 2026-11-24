package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_supermercado";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Método temporal solo para probar que Eclipse conecta con XAMPP
    public static void main(String[] args) {
        try (Connection con = conectar()) {
            System.out.println("¡Conexión exitosa a bd_supermercado!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}