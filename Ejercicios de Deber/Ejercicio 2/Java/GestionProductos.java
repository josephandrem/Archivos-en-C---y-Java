import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GestionProductos {
    public static void main(String[] args) {
        // Ajusta la ruta si el archivo está en una subcarpeta
        File archivo = new File("productos.txt");
        
        double totalGeneral = 0;
        String productoCaro = "";
        double precioMaximo = -1;

        try (Scanner sc = new Scanner(archivo)) {
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-15s %-10s %-10s %-10s%n", "PRODUCTO", "PRECIO", "CANT.", "SUBTOTAL");
            System.out.println("-------------------------------------------------------");

            while (sc.hasNext()) {
                String nombre = sc.next();
                double precio = sc.nextDouble();
                int cantidad = sc.nextInt();

                double subtotal = precio * cantidad;
                totalGeneral += subtotal;

                // Lógica para encontrar el producto más caro
                if (precio > precioMaximo) {
                    precioMaximo = precio;
                    productoCaro = nombre;
                }

                System.out.printf("%-15s %-10.2f %-10d %-10.2f%n", nombre, precio, cantidad, subtotal);
            }

            System.out.println("-------------------------------------------------------");
            System.out.printf("TOTAL GENERAL: %.2f%n", totalGeneral);
            System.out.println("PRODUCTO MAYOR (PRECIO): " + productoCaro);

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo 'productos.txt'.");
        }
    }
}