package Presentacion;

import java.sql.SQLException;
import Logica.Categoria;
import Logica.Proveedor;

public class Inicio {

    public static void main(String[] args) {
        try {
            // Ya están guardados en MySQL; coméntalos para solo listar
            // Categoria c = new Categoria("Abarrotes", "Arroz, fideos, aceite");
            // c.registrar();
            // Proveedor p = new Proveedor("10203040", "Distribuidora La Paz", "77712345", "Alimentos");
            // p.registrar();

            System.out.println("=== CATEGORÍAS ===");
            for (Categoria cat : Categoria.listarTodas()) {
                System.out.println(cat.mostrar());
            }

            System.out.println("=== PROVEEDORES ===");
            for (Proveedor prov : Proveedor.listarTodos()) {
                System.out.println(prov.mostrar());
            }
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}