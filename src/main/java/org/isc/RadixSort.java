package org.isc;

import java.math.BigInteger;
import java.util.Arrays;

public class RadixSort {

    // Función principal de Radix Sort
    public static void radixSort(BigInteger[] A) {
        // Determinamos el número máximo de dígitos
        int maxDigits = getMaxDigits(A);

        // Iteramos a través de cada dígito, desde el dígito menos significativo (LSD) hasta el más significativo
        for (int i = 1; i <= maxDigits; i++) {
            countingSort(A, i);  // Aplicamos Counting Sort basado en el dígito en la posición i
        }
    }

    // Función de Counting Sort que ordena el array A según el dígito en la posición d (EMPIEZA EN 1)
    public static void countingSort(BigInteger[] A, int d) {
        int n = A.length;  // Guardamos el tamaño del array A

        // array de salida donde almacenaremos los números ordenados temporalmente
        BigInteger[] output = new BigInteger[n];
        // array de conteo, de tamaño 10 porque hay 10 posibles dígitos (0-9)
        int[] count = new int[10];

        // Inicializamos el array de conteo a 0 para cada dígito
        Arrays.fill(count, 0);

        // Primera pasada: contamos cuántas veces aparece cada dígito en la posición d
        for (int i = 0; i < n; i++) {
            // Obtenemos el dígito en la posición d del número A[i]
            int digit = getDigit(A[i], d);

            // Incrementamos el contador de ese dígito
            count[digit]++;
        }

        // Modificamos el array count para que contenga las posiciones correctas de los dígitos en el array de salida
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Segunda pasada: construimos el array de salida ordenado por el dígito actual
        for (int i = n - 1; i >= 0; i--) {  // Iteramos desde el final para mantener la estabilidad del algoritmo
            int digit = getDigit(A[i], d);
            output[count[digit] - 1] = A[i];
            count[digit]--;
        }

        // Copiamos el array de salida al array original A
        System.arraycopy(output, 0, A, 0, n);
    }

    // Función para obtener el dígito en la posición 'digitPlace' de un BigInteger
    public static int getDigit(BigInteger number, int d) {
        // Convertimos el BigInteger a String para obtener el dígito
        String str = number.toString();
        if (d > str.length()) {
            return 0; // Si no hay un dígito en la posición d, retornamos 0
        }
        return Character.getNumericValue(str.charAt(str.length() - d)); // Retorna el dígito en la posición d
    }

    // Función para obtener el número máximo de dígitos en el array
    public static int getMaxDigits(BigInteger[] A) {
        int max = 0;
        for (BigInteger bigInteger : A) {
            max = Math.max(max, bigInteger.toString().length());
        }
        return max;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        BigInteger[] A = {
                new BigInteger("17000000000000"),
                new BigInteger("45"),
                new BigInteger("75"),
                new BigInteger("90"),
                new BigInteger("802"),
                new BigInteger("24"),
                new BigInteger("2"),
                new BigInteger("66")
        };

        System.out.println("Array Desordenado: " + Arrays.toString(A));
        radixSort(A);
        System.out.println("Array Ordenado: " + Arrays.toString(A));
    }
}


