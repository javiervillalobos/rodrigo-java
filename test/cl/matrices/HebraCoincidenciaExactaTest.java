package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class HebraCoincidenciaExactaTest {

  @Test
  public void obtiene4CoincidenciasExactasEnMatrix2x2() {
    int dimension = 2;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz1, 2);
    TestUtils.llenarMatrizConValor(matriz2, 2);
    Matriz[] matrices = {matriz1, matriz2};
    int[][] resultadoEsperado = new int[2][2];
    resultadoEsperado[0][0] = 2;
    resultadoEsperado[0][1] = 2;
    resultadoEsperado[1][0] = 2;
    resultadoEsperado[1][1] = 2;

    HebraCoincidenciaExacta hebraCoincidenciaExacta = new HebraCoincidenciaExacta(matrices);
    hebraCoincidenciaExacta.buscar();
    int[][] resultado = hebraCoincidenciaExacta.getResultado();
    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }

  @Test
  public void obtiene2CoincidenciasExactasEnMatrix2x2() {
    int dimension = 2;
    Matriz matriz1 = new Matriz(dimension);
    Matriz matriz2 = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz1, 2);
    TestUtils.llenarMatrizConValor(matriz2, 2);
    matriz1.agregarValor(1, 1, 1);
    matriz2.agregarValor(1, 1, 4);
    matriz1.agregarValor(1, 2, 3);
    matriz2.agregarValor(1, 2, 3);
    matriz1.agregarValor(2, 2, 5);
    matriz2.agregarValor(2, 2, 9);
    Matriz[] matrices = {matriz1, matriz2};
    int[][] resultadoEsperado = new int[2][2];
    resultadoEsperado[0][0] = 0;
    resultadoEsperado[0][1] = 3;
    resultadoEsperado[1][0] = 2;
    resultadoEsperado[1][1] = 0;

    HebraCoincidenciaExacta hebraCoincidenciaExacta = new HebraCoincidenciaExacta(matrices);
    hebraCoincidenciaExacta.buscar();
    int[][] resultado = hebraCoincidenciaExacta.getResultado();
    Assert.assertArrayEquals(resultadoEsperado, resultado);
  }
}