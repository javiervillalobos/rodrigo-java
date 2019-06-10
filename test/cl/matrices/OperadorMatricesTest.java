package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class OperadorMatricesTest {

  @Test
  public void encuentra4unosEnMatrix5x5() {
    int dimension = 5;
    Matriz[] matrices = {new Matriz(dimension), new Matriz(dimension)};
    int valor = 1;
    TestUtils.llenarMatrizConValor(matrices[0], valor);
    TestUtils.llenarMatrizConValor(matrices[1], valor);
    OperadorMatrices operador = new OperadorMatrices();
    int valorABuscar = 1;
    int[] coincidenciasEsperadas = {25, 25};
    int[] coincidenciasResultantes = operador.buscarCoincidencias(valorABuscar, matrices);
    Assert.assertArrayEquals(coincidenciasEsperadas, coincidenciasResultantes);
  }

  @Test
  public void transformaNumerosPrimosEnMatrix5x5() {
    int dimension = 5;
    Matriz[] matrices = {new Matriz(dimension), new Matriz(dimension)};
    int valor = 2;
    TestUtils.llenarMatrizConValor(matrices[0], valor);
    TestUtils.llenarMatrizConValor(matrices[1], valor);
    OperadorMatrices operador = new OperadorMatrices();

    operador.operaNumerosPrimos(matrices);

    int valorABuscar = 1;
    int[] coincidenciasEsperadas = {25, 25};
    int[] coincidenciasResultantes = operador.buscarCoincidencias(valorABuscar, matrices);
    Assert.assertArrayEquals(coincidenciasEsperadas, coincidenciasResultantes);
  }

  @Test
  public void transformaNumerosPrimosContinuosEnMatrix5x5() {
    int dimension = 5;
    Matriz[] matrices = {new Matriz(dimension), new Matriz(dimension)};
    TestUtils.llenarMatrizConValoresIncrementales(matrices[0]);
    TestUtils.llenarMatrizConValoresIncrementales(matrices[1]);
    OperadorMatrices operador = new OperadorMatrices();

    Matriz matrizEsperada1 = new Matriz(dimension);
    Matriz matrizEsperada2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matrizEsperada1);
    TestUtils.llenarMatrizConValoresIncrementales(matrizEsperada2);

    matrizEsperada1.agregarValor(1, 1, 1);
    matrizEsperada1.agregarValor(1, 2, 1);
    matrizEsperada1.agregarValor(1, 3, 1);

    matrizEsperada2.agregarValor(1, 1, 1);
    matrizEsperada2.agregarValor(1, 2, 1);
    matrizEsperada2.agregarValor(1, 3, 1);

    operador.operaNumerosPrimos(matrices);

    int valorABuscar = 1;
    int[] coincidenciasEsperadas = {3, 3};
    int[] coincidenciasResultantes = operador.buscarCoincidencias(valorABuscar, matrices);
    Assert.assertArrayEquals(coincidenciasEsperadas, coincidenciasResultantes);
  }

  @Test
  public void obtieneCoincidenciasExactasEnMatrix2x2() {
    int dimension = 2;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz1);
    TestUtils.llenarMatrizConValoresIncrementales(matriz2);
    Matriz[] matrices = {matriz1, matriz2};
    int[][] resultadoEsperado = new int[2][2];
    int valor = 1; 
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        resultadoEsperado[i][j] = valor;
        valor++;
      }
    }

    OperadorMatrices operadorMatrices = new OperadorMatrices();
    int[][] resultado = operadorMatrices.buscarCoincidenciasExactas(matrices);

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }  

  @Test
  public void obtieneCoincidenciasExactasEnMatrix5x5() {
    int dimension = 5;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz1);
    TestUtils.llenarMatrizConValoresIncrementales(matriz2);
    Matriz[] matrices = {matriz1, matriz2};
    int[][] resultadoEsperado = new int[5][5];
    int valor = 1; 
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
        resultadoEsperado[i][j] = valor;
        valor++;
      }
    }

    OperadorMatrices operadorMatrices = new OperadorMatrices();
    int[][] resultado = operadorMatrices.buscarCoincidenciasExactas(matrices);

    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }  
}