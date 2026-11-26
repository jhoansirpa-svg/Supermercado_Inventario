package Logica;

import java.sql.SQLException;
import java.util.ArrayList;
import Datos.ProveedorDAO;

public class Proveedor {
    private int idProveedor;
    private String nit;
    private String razonSocial;
    private String telefono;
    private String rubro;

    // Constructor para nuevo proveedor
    
    public Proveedor(String nit, String razonSocial, String telefono, String rubro) {
        setNit(nit);
        setRazonSocial(razonSocial);
        this.telefono = (telefono != null) ? telefono.trim() : "";
        this.rubro = (rubro != null) ? rubro.trim() : "";
    }

    // Constructor para cargar desde la BD
    
    public Proveedor(int idProveedor, String nit, String razonSocial, String telefono, String rubro) {
        this.idProveedor = idProveedor;
        setNit(nit);
        setRazonSocial(razonSocial);
        this.telefono = (telefono != null) ? telefono.trim() : "";
        this.rubro = (rubro != null) ? rubro.trim() : "";
    }

    // Getters y Setters con validación
    
    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNit() { return nit; }
    public void setNit(String nit) {
        if (nit == null || nit.trim().isEmpty()) {
            throw new IllegalArgumentException("El NIT del proveedor es obligatorio.");
        }
        this.nit = nit.trim();
    }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) {
        if (razonSocial == null || razonSocial.trim().isEmpty()) {
            throw new IllegalArgumentException("La razón social es obligatoria.");
        }
        this.razonSocial = razonSocial.trim();
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) {
        this.telefono = (telefono != null) ? telefono.trim() : "";
    }

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) {
        this.rubro = (rubro != null) ? rubro.trim() : "";
    }

    // Método del Diagrama UML
    
    public void registrar() throws SQLException {
        new ProveedorDAO().insertar(this);
    }

    public void editar() throws SQLException {
        if (this.idProveedor <= 0) {
            throw new IllegalArgumentException("ID de proveedor inválido para editar.");
        }
        new ProveedorDAO().actualizar(this);
    }

    public static ArrayList<Proveedor> listarTodos() throws SQLException {
        return new ProveedorDAO().listar();
    }

    public String mostrar() {
        return nit + " | " + razonSocial + " | Tel: " + telefono + " | Rubro: " + rubro;
    }

    @Override
    public String toString() {
        return razonSocial;
    }
}