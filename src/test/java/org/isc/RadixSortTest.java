package org.isc;
import java.util.Random;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadixSortTest {

    @Test
    public void testRadixSort004_NormalArray() {
        BigInteger[] input = {
                BigInteger.valueOf(170),
                BigInteger.valueOf(45),
                BigInteger.valueOf(75),
                BigInteger.valueOf(90),
                BigInteger.valueOf(802),
                BigInteger.valueOf(24),
                BigInteger.valueOf(2),
                BigInteger.valueOf(66)
        };
        BigInteger[] expected = {
                BigInteger.valueOf(2),
                BigInteger.valueOf(24),
                BigInteger.valueOf(45),
                BigInteger.valueOf(66),
                BigInteger.valueOf(75),
                BigInteger.valueOf(90),
                BigInteger.valueOf(170),
                BigInteger.valueOf(802)
        };

        RadixSort.radixSort(input); //
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort001_ValidArray() {
        // Caso de prueba 1: Array con números aleatorios
        BigInteger[] input = {
                BigInteger.valueOf(1000),
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(3),
                BigInteger.valueOf(2),
                BigInteger.valueOf(66)
        };
        BigInteger[] expected = {
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(3),
                BigInteger.valueOf(66),
                BigInteger.valueOf(1000)
        };

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort006_SingleElementArray() {
        // Caso de prueba 2: Array con un solo elemento
        BigInteger[] input = {BigInteger.valueOf(42)};
        BigInteger[] expected = {BigInteger.valueOf(42)};

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort005_EmptyArray() {
        // Caso de prueba 3: Array vacío
        BigInteger[] input = {};
        BigInteger[] expected = {};

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort002_ArrayWith_Duplicates() {
        // Caso de prueba 4: Array con elementos duplicados
        BigInteger[] input = {
                BigInteger.valueOf(5),
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(3),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1)
        };
        BigInteger[] expected = {
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(3),
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(5)
        };

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort011_LargeNumbers_Digits_6() {
        BigInteger[] input = {
                BigInteger.valueOf(10000),
                BigInteger.valueOf(100000),
                BigInteger.valueOf(100),
                BigInteger.valueOf(1000),
                BigInteger.valueOf(10)
        };
        BigInteger[] expected = {
                BigInteger.valueOf(10),
                BigInteger.valueOf(100),
                BigInteger.valueOf(1000),
                BigInteger.valueOf(10000),
                BigInteger.valueOf(100000)
        };

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort007_LargeNumbers_With_100Digits() {
        // Array de BigInteger que representan números de 100 dígitos
        BigInteger[] input = {
                new BigInteger("43729847109283746512983745091827346510982374650192837465019283746501298374650918237465091823746509823745091827346509182734"),
                new BigInteger("98374560192837465109283745019283746501298374560918237465091827346509182734509821734650918237465012983745091827346510982374"),
                new BigInteger("23478109283746512093874560129384756109283746509182734560192837465091827346509182734560918237456091827346501928374509182734"),
                new BigInteger("57382910492837465019283745091827346509128374650981273465091827346501928374650918237465091827346509182734509128374650128374"),
                new BigInteger("60923874509182734560192837465019827346509182734650918237465019827346509182734650918237465019283745091827346509182745091827")
        };

        // Orden esperado
        BigInteger[] expected = {
                new BigInteger("23478109283746512093874560129384756109283746509182734560192837465091827346509182734560918237456091827346501928374509182734"),
                new BigInteger("43729847109283746512983745091827346510982374650192837465019283746501298374650918237465091823746509823745091827346509182734"),
                new BigInteger("57382910492837465019283745091827346509128374650981273465091827346501928374650918237465091827346509182734509128374650128374"),
                new BigInteger("60923874509182734560192837465019827346509182734650918237465019827346509182734650918237465019283745091827346509182745091827"),
                new BigInteger("98374560192837465109283745019283746501298374560918237465091827346509182734509821734650918237465012983745091827346510982374")
        };

        RadixSort.radixSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort009_1000_random_bigIntegers() {
        // Generar un arreglo de 1000 BigIntegers aleatorios
        int size = 1000;
        BigInteger[] input = new BigInteger[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Generar números aleatorios grandes como BigInteger
            input[i] = new BigInteger(100, random); // 100 bits de aleatoriedad
        }

        // Hacer una copia del arreglo original para ordenarlo con Arrays.sort
        BigInteger[] expected = input.clone();

        // Ordenar el arreglo esperado usando Arrays.sort
        java.util.Arrays.sort(expected);

        // Llamar al algoritmo Radix Sort
        RadixSort.radixSort(input);

        // Comprobar que el resultado es el esperado
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRadixSort008_Threads() {
        // Arreglos predefinidos
        BigInteger[][] arraysToSort = {
                {BigInteger.valueOf(170), BigInteger.valueOf(45), BigInteger.valueOf(75)},
                {BigInteger.valueOf(90), BigInteger.valueOf(802), BigInteger.valueOf(24)},
                {BigInteger.valueOf(2), BigInteger.valueOf(66), BigInteger.valueOf(150)},
                {BigInteger.valueOf(1000), BigInteger.valueOf(500), BigInteger.valueOf(250)}
        };

        // Ejecutar el ordenamiento en un solo hilo
        for (BigInteger[] array : arraysToSort) {
            RadixSort.radixSort(array);

        }
    }

    @Test
    public void testRadixSort010_Sort1000Numbers_with_5digits() {
        // Generar un arreglo de 1000 BigIntegers aleatorios de 5 dígitos
        int size = 1000;
        BigInteger[] input = new BigInteger[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Generar números aleatorios de 5 dígitos
            int randomNumber = 10000 + random.nextInt(90000); // Rango de 10000 a 99999
            input[i] = BigInteger.valueOf(randomNumber);
        }

        // Llamar al algoritmo Radix Sort
        RadixSort.radixSort(input);

    }



    @Test
    public void testGetDigit() {
        // Caso de prueba para getDigit: Comprobamos si el dígito en una posición es correcto
        assertEquals(3, RadixSort.getDigit(BigInteger.valueOf(12345), 3)); // El tercer dígito de 12345 es 3
        assertEquals(1, RadixSort.getDigit(BigInteger.valueOf(12345), 5)); // El quinto dígito de 12345 es 1
        assertEquals(0, RadixSort.getDigit(BigInteger.valueOf(12345), 6)); // No hay sexto dígito, así que es 0
    }
}
