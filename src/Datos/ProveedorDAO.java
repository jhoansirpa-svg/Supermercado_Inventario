package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Logica.Proveedor;

public class ProveedorDAO {

    public void insertar(Proveedor prov) throws SQLException {
        String sql = "INSERT INTO proveedor (nit, razon_social, telefono, rubro) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, prov.getNit());
            ps.setString(2, prov.getRazonSocial());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getRubro());
            ps.executeUpdate();
        }
    }

    public void actualizar(Proveedor prov) throws SQLException {
        String sql = "UPDATE proveedor SET nit = ?, razon_social = ?, telefono = ?, rubro = ? WHERE id_proveedor = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, prov.getNit());
            ps.setString(2, prov.getRazonSocial());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getRubro());
            ps.setInt(5, prov.getIdProveedor());
            ps.executeUpdate();
        }
    }

    public ArrayList<Proveedor> listar() throws SQLException {
        ArrayList<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT id_proveedor, nit, razon_social, telefono, rubro FROM proveedor ORDER BY razon_social";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nit"),
                    rs.getString("razon_social"),
                    rs.getString("telefono"),
                    rs.getString("rubro")
                ));
            }
        }
        return lista;
    }
}