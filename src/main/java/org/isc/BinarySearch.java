package org.isc;
import java.util.Scanner;

public class BinarySearch {
    //Método que implementa la búsqueda binaria
    public static int binarySearch(int[] arr, int target) {
        int left = 0; // Inicio del rango de búsqueda
        int right = arr.length - 1; // Fin del rango de búsqueda

        // Control de flujo: ciclo while que ejecuta la búsqueda mientras haya elementos en el rango
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calcula el punto medio

            // Control de flujo: primera decisión
            // Si el elemento del medio es igual al objetivo
            if (arr[mid] == target) {
                return mid; // Retorna el índice del elemento encontrado, termina el flujo
            }

            // Control de flujo: segunda decisión
            // Si el elemento del medio es menor que el objetivo
            else if (arr[mid] < target) {
                left = mid + 1; // Modifica el rango de búsqueda para buscar a la derecha
            }

            // Control de flujo: tercera decisión
            // Si el elemento del medio es mayor que el objetivo
            else {
                right = mid - 1; // Modifica el rango de búsqueda para buscar a la izquierda
            }
        }

        // Si el ciclo termina y no encuentra el elemento, retorna -1
        return -1; // El elemento no fue encontrado, flujo final
    }

    //Metodo principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el tamaño del arreglo
        System.out.print("Introduce el tamaño del arreglo: ");
        int size = scanner.nextInt();

        // Crear y llenar el arreglo
        int[] arr = new int[size];
        System.out.println("Introduce los elementos del arreglo en orden ascendente:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt(); // Se llena el arreglo
        }

        // Solicitar el número a buscar
        System.out.print("Introduce el número a buscar: ");
        int target = scanner.nextInt();

        // Llamar al método binarySearch y mostrar el resultado
        int result = binarySearch(arr, target);

        // Control de flujo: decisión que interpreta el resultado de la búsqueda
        if (result != -1) {
            System.out.println("Elemento encontrado en el índice: " + result);
        } else {
            System.out.println("Elemento no encontrado.");
        }

        scanner.close(); // Cerrar el recurso Scanner
    }
}
