package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import Datos.CategoriaDAO;

public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    // Constructor para crear una categoría nueva (sin ID)
    public Categoria(String nombre, String descripcion) {
        setNombre(nombre);
        this.descripcion = (descripcion != null) ? descripcion.trim() : "";
    }

    // Constructor para cargar desde la BD (con ID)
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        setNombre(nombre);
        this.descripcion = (descripcion != null) ? descripcion.trim() : "";
    }

    // Getters y Setters con validación
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = (descripcion != null) ? descripcion.trim() : "";
    }

    // Método del Diagrama UML conectados a la capa Datos
    
    public void registrar() throws SQLException {
        new CategoriaDAO().insertar(this);
    }

    public void editar() throws SQLException {
        if (this.idCategoria <= 0) {
            throw new IllegalArgumentException("ID de categoría inválido para editar.");
        }
        new CategoriaDAO().actualizar(this);
    }

    public static ArrayList<Categoria> listarTodas() throws SQLException {
        return new CategoriaDAO().listar();
    }

    public String mostrar() {
        return idCategoria + " - " + nombre + " (" + descripcion + ")";
    }

    
    @Override
    public String toString() {
        return nombre;
    }
}