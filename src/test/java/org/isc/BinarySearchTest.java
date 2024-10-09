package org.isc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    // Prueba para verificar que el elemento objetivo se encuentra en el medio del arreglo
    @Test
    public void testElementFoundAtMiddle() {
        int[] arr = {1, 2, 3, 4, 5}; // Arreglo de entrada
        int target = 3; // Elemento a buscar
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: aquí se verifica si el resultado es igual al índice esperado (2)
        // Si es igual, la prueba pasa, si no, falla.
        assertEquals(2, result); // Verifica si el índice devuelto es 2 (donde debería estar el 3)
    }

    // Prueba para verificar que el elemento objetivo se encuentra al inicio del arreglo
    @Test
    public void testElementFoundAtBeginning() {
        int[] arr = {1, 2, 3, 4, 5}; // Arreglo de entrada
        int target = 1; // Elemento a buscar
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es 0, ya que el elemento está al inicio
        assertEquals(0, result); // Verifica si el índice devuelto es 0 (el primer elemento)
    }

    // Prueba para verificar que el elemento objetivo se encuentra al final del arreglo
    @Test
    public void testElementFoundAtEnd() {
        int[] arr = {1, 2, 3, 4, 5}; // Arreglo de entrada
        int target = 5; // Elemento a buscar
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es 4, el índice del último elemento
        assertEquals(4, result); // Verifica si el índice devuelto es 4 (donde debería estar el 5)
    }

    // Prueba para verificar que el algoritmo retorne -1 cuando el elemento no está en el arreglo
    @Test
    public void testElementNotFound() {
        int[] arr = {1, 2, 3, 4, 5}; // Arreglo de entrada
        int target = 6; // Elemento a buscar, que no está en el arreglo
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es -1, indicando que el elemento no se encuentra en el arreglo
        assertEquals(-1, result); // Verifica si el valor devuelto es -1 (ya que el 6 no está presente)
    }

    // Prueba para verificar que el algoritmo funcione correctamente con un solo elemento en el arreglo, y que el elemento sea el objetivo
    @Test
    public void testSingleElementFound() {
        int[] arr = {10}; // Arreglo con un solo elemento
        int target = 10; // Elemento a buscar
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es 0, ya que es el único elemento del arreglo
        assertEquals(0, result); // Verifica si el valor devuelto es 0 (único índice posible)
    }

    // Prueba para verificar que el algoritmo retorne -1 cuando el arreglo tiene un solo elemento y no es el objetivo
    @Test
    public void testSingleElementNotFound() {
        int[] arr = {10}; // Arreglo con un solo elemento
        int target = 5; // Elemento a buscar, que no está en el arreglo
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es -1, indicando que el elemento no está en el arreglo
        assertEquals(-1, result); // Verifica si el valor devuelto es -1 (ya que el 5 no está presente)
    }

    // Prueba para verificar que el algoritmo retorne -1 cuando el arreglo está vacío
    @Test
    public void testEmptyArray() {
        int[] arr = {}; // Arreglo vacío
        int target = 3; // Elemento a buscar, que no puede estar en un arreglo vacío
        int result = BinarySearch.binarySearch(arr, target); // Ejecuta el método de búsqueda binaria

        // Control de flujo: se verifica si el resultado es -1, ya que no hay elementos en el arreglo
        assertEquals(-1, result); // Verifica si el valor devuelto es -1 (el arreglo está vacío)
    }
}
