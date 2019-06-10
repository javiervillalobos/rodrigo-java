package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class HebraPrimoTest {

  @Test
  public void calculaNumerosPrimos() {
    int cantidadDeNumeros = 98;
    int[] numerosPropuestos = new int[cantidadDeNumeros];
    for (int indice = 2; indice <= cantidadDeNumeros; indice++) {
      numerosPropuestos[indice - 2] = indice;
    }

    int[] numerosPrimosEsperados = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
        83, 89, 97 };
    int[] numerosResultantes = new int[numerosPrimosEsperados.length];

    Matriz[] matrices = { new Matriz(2) };

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    int indicePrimo = 0;
    for (int indice = 2; indice <= cantidadDeNumeros; indice++) {
      int numero = numerosPropuestos[indice - 2];
      boolean esPrimo = hebraPrimo.esPrimo(numero);
      if (esPrimo) {
        numerosResultantes[indicePrimo] = numero;
        indicePrimo++;
      }
    }

    Assert.assertArrayEquals(numerosPrimosEsperados, numerosResultantes);

  }

  @Test
  public void encuentraNumerosPrimos2y3EnMatriz2x2() {
    int dimension = 2;
    Matriz matriz = new Matriz(dimension);
    matriz.agregarValor(1, 1, 1);
    matriz.agregarValor(1, 2, 2);
    matriz.agregarValor(2, 1, 3);
    matriz.agregarValor(2, 2, 1);
    Matriz[] matrices = { matriz };

    int[][] resultadoEsperado = new int[1][3];
    resultadoEsperado[0][0] = 1;
    resultadoEsperado[0][1] = 2;
    resultadoEsperado[0][2] = 3;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void encuentraNumerosPrimosEnMatriz5x5() {
    int dimension = 5;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz);
    Matriz[] matrices = { matriz };

    int[][] resultadoEsperado = new int[1][3];
    resultadoEsperado[0][0] = 1;
    resultadoEsperado[0][1] = 2;
    resultadoEsperado[0][2] = 3;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void encuentraNumeroPrimo1EnMatriz5x5() {
    int dimension = 5;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, 4);
    matriz.agregarValor(1, 1, 1);
    Matriz[] matrices = { matriz };

    int[][] resultadoEsperado = new int[1][1];
    resultadoEsperado[0][0] = 1;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void encuentraNumerosPrimosEnMatrices5x5() {
    int dimension = 5;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz1);
    TestUtils.llenarMatrizConValoresIncrementales(matriz2);
    Matriz[] matrices = { matriz1, matriz2 };

    int[][] resultadoEsperado = new int[2][3];
    resultadoEsperado[0][0] = 1;
    resultadoEsperado[0][1] = 2;
    resultadoEsperado[0][2] = 3;
    resultadoEsperado[1][0] = 1;
    resultadoEsperado[1][1] = 2;
    resultadoEsperado[1][2] = 3;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void encuentraNumerosPrimos2y3EnLaSegundaMatriz5x5() {
    int dimension = 5;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz1, 4);
    TestUtils.llenarMatrizConValor(matriz2, 4);
    matriz2.agregarValor(1, 1, 2);
    matriz2.agregarValor(dimension, dimension, 3);
    Matriz[] matrices = { matriz1, matriz2 };

    int[][] resultadoEsperado = new int[2][2];
    resultadoEsperado[0] = null;
    resultadoEsperado[1][0] = 2;
    resultadoEsperado[1][1] = 3;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void noEncuentraNumerosPrimosEnMatrices5x5() {
    int dimension = 5;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz1, 4);
    TestUtils.llenarMatrizConValor(matriz2, 4);
    Matriz[] matrices = { matriz1, matriz2 };

    int[][] resultadoEsperado = new int[2][];
    resultadoEsperado[0] = null;
    resultadoEsperado[1] = null;

    HebraPrimo hebraPrimo = new HebraPrimo(matrices);
    hebraPrimo.buscar();
    int[][] resultado = hebraPrimo.obtenerNumerosPrimos();

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }
}