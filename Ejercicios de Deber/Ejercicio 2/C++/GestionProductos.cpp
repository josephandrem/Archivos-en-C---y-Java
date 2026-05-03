#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    // Abrimos el archivo
    ifstream archivo("productos.txt");
    
    // Verificamos si se pudo abrir
    if (!archivo.is_open()) {
        cout << "Error: No se pudo abrir el archivo productos.txt" << endl;
        return 1;
    }

    string nombre, productoCaro;
    double precio, totalGeneral = 0, precioMaximo = -1;
    int cantidad;

    // Encabezados simples
    cout << "PRODUCTO  PRECIO  CANT.  SUBTOTAL" << endl;
    cout << "------------------------------------" << endl;

    // Lectura palabra por palabra: nombre (string), precio (double), cantidad (int)
    while (archivo >> nombre >> precio >> cantidad) {
        double subtotal = precio * cantidad;
        totalGeneral += subtotal;

        // Lógica para el producto mayor
        if (precio > precioMaximo) {
            precioMaximo = precio;
            productoCaro = nombre;
        }

        // Salida básica usando espacios o tabulaciones (\t)
        cout << nombre << "  " << precio << "  " << cantidad << "  " << subtotal << endl;
    }

    cout << "------------------------------------" << endl;
    cout << "TOTAL GENERAL: " << totalGeneral << endl;
    cout << "PRODUCTO MAS CARO: " << productoCaro << " (" << precioMaximo << ")" << endl;

    archivo.close();
    return 0;
}