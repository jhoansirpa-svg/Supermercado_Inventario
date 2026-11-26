package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Logica.Categoria;

public class CategoriaDAO {

    public void insertar(Categoria cat) throws SQLException {
        String sql = "INSERT INTO categoria (nombre, descripcion) VALUES (?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cat.getNombre());
            ps.setString(2, cat.getDescripcion());
            ps.executeUpdate();
        }
    }

    public void actualizar(Categoria cat) throws SQLException {
        String sql = "UPDATE categoria SET nombre = ?, descripcion = ? WHERE id_categoria = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cat.getNombre());
            ps.setString(2, cat.getDescripcion());
            ps.setInt(3, cat.getIdCategoria());
            ps.executeUpdate();
        }
    }

    public ArrayList<Categoria> listar() throws SQLException {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id_categoria, nombre, descripcion FROM categoria ORDER BY nombre";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                ));
            }
        }
        return lista;
    }
}