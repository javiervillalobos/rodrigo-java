package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class HebraDivisionTest {

  @Test
  public void transformaValores2EnMatriz2x2AValores1() {
    int dimension = 2;

    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, 2);

    Matriz matrizEsperada = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matrizEsperada, 1);

    String resultadoEsperado = matrizEsperada.mostrar();

    Matriz[] matrices = {matriz};
    int[][] numerosPrimos = new int[1][1];
    numerosPrimos[0][0] = 2;
    HebraDivision hebraDivision = new HebraDivision(matrices, numerosPrimos);
    hebraDivision.aplicar();

    String resultado = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultado);
  }

  @Test
  public void transformaValores123EnMatriz5x5AValores1() {
    int dimension = 5;

    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz);

    Matriz matrizEsperada = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matrizEsperada);
    matrizEsperada.agregarValor(1, 2, 1);
    matrizEsperada.agregarValor(1, 3, 1);

    String resultadoEsperado = matrizEsperada.mostrar();

    Matriz[] matrices = {matriz};
    int[][] numerosPrimos = new int[1][3];
    numerosPrimos[0][0] = 1;
    numerosPrimos[0][1] = 2;
    numerosPrimos[0][2] = 3;
    HebraDivision hebraDivision = new HebraDivision(matrices, numerosPrimos);
    hebraDivision.aplicar();

    String resultado = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultado);
  }

  @Test
  public void transformaValores123EnMatrices5x5AValores1() {
    int dimension = 5;

    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz1);
    TestUtils.llenarMatrizConValoresIncrementales(matriz2);

    Matriz matrizEsperada = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matrizEsperada);
    matrizEsperada.agregarValor(1, 2, 1);
    matrizEsperada.agregarValor(1, 3, 1);

    String resultadoEsperado = matrizEsperada.mostrar();

    Matriz[] matrices = {matriz1, matriz2};
    int[][] numerosPrimos = new int[2][3];
    numerosPrimos[0][0] = 1;
    numerosPrimos[0][1] = 2;
    numerosPrimos[0][2] = 3;
    numerosPrimos[1][0] = 1;
    numerosPrimos[1][1] = 2;
    numerosPrimos[1][2] = 3;
    HebraDivision hebraDivision = new HebraDivision(matrices, numerosPrimos);
    hebraDivision.aplicar();

    String resultado1 = matriz1.mostrar();
    String resultado2 = matriz2.mostrar();
    Assert.assertEquals(resultadoEsperado, resultado1);
    Assert.assertEquals(resultadoEsperado, resultado2);
  }

  @Test
  public void noTransformaMatrices5x5AValores1() {
    int dimension = 5;

    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz1, 4);
    TestUtils.llenarMatrizConValor(matriz2, 4);

    Matriz matrizEsperada = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matrizEsperada, 4);

    String resultadoEsperado = matrizEsperada.mostrar();

    Matriz[] matrices = {matriz1, matriz2};
    int[][] numerosPrimos = new int[2][];
    numerosPrimos[0] = null;
    numerosPrimos[1] = null;
    HebraDivision hebraDivision = new HebraDivision(matrices, numerosPrimos);
    hebraDivision.aplicar();

    String resultado1 = matriz1.mostrar();
    String resultado2 = matriz2.mostrar();
    Assert.assertEquals(resultadoEsperado, resultado1);
    Assert.assertEquals(resultadoEsperado, resultado2);
  }

  @Test
  public void transformaValoresA1Matriz5x5Zona2x2() {
    int dimension = 5;

    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, 2);
    ZonaMatriz zonaMatriz = new ZonaMatriz(1, 1, 2, 2);

    Matriz matrizEsperada = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matrizEsperada, 2);
    matrizEsperada.agregarValor(1, 1, 1);
    matrizEsperada.agregarValor(1, 2, 1);
    matrizEsperada.agregarValor(2, 1, 1);
    matrizEsperada.agregarValor(2, 2, 1);

    String resultadoEsperado = matrizEsperada.mostrar();

    Matriz[] matrices = {matriz};
    int[][] numerosPrimos = new int[1][1];
    numerosPrimos[0][0] = 2;
    HebraDivision hebraDivision = new HebraDivision(matrices, numerosPrimos);
    hebraDivision.asignarAreaOperacion(zonaMatriz);
    hebraDivision.aplicar();

    String resultado = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultado);
  }
}
