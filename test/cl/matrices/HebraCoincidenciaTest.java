package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class HebraCoincidenciaTest {

  @Test
  public void encuentra4UnosEnMatriz2x2() {
    int dimension = 2;
    Matriz matriz = new Matriz(dimension);
    int valor = 1;
    TestUtils.llenarMatrizConValor(matriz, valor);
    int cantidaMatrices = 1;
    Matriz[] matrices = new Matriz[cantidaMatrices];
    matrices[0] = matriz;
    Hebra hebra = new HebraCoincidencia(matrices, valor);
    int filaInicio = 1;
    int filaTermino = dimension;
    int columnaInicio = 1;
    int columnaTermino = dimension;
    ZonaMatriz zonaMatriz = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino);
    hebra.asignarAreaOperacion(zonaMatriz);
    HebraCoincidencia hebraCoincidencia = (HebraCoincidencia) hebra;
    hebraCoincidencia.buscarValor();
    int resultadoEsperado = 4;
    int resultadoBusqueda = hebraCoincidencia.getResultado();
    Assert.assertEquals(resultadoEsperado, resultadoBusqueda);
  }

  @Test
  public void encuentra25UnosEnMatriz5x5() {
    int dimension = 5;
    Matriz matriz = new Matriz(dimension);
    int valor = 1;
    TestUtils.llenarMatrizConValor(matriz, valor);
    int cantidaMatrices = 1;
    Matriz[] matrices = new Matriz[cantidaMatrices];
    matrices[0] = matriz;
    Hebra hebra = new HebraCoincidencia(matrices, valor);
    int filaInicio = 1;
    int filaTermino = dimension;
    int columnaInicio = 1;
    int columnaTermino = dimension;
    ZonaMatriz zonaMatriz = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino);
    hebra.asignarAreaOperacion(zonaMatriz);
    HebraCoincidencia hebraCoincidencia = (HebraCoincidencia) hebra;
    hebraCoincidencia.buscarValor();
    int resultadoEsperado = 25;
    int resultadoBusqueda = hebraCoincidencia.getResultado();
    Assert.assertEquals(resultadoEsperado, resultadoBusqueda);
  }

  @Test
  public void encuentra8UnosEnDosMatrices2x2() {
    int dimension = 2;
    Matriz matriz = new Matriz(dimension);
    int valor = 1;
    TestUtils.llenarMatrizConValor(matriz, valor);
    int cantidaMatrices = 2;
    Matriz[] matrices = new Matriz[cantidaMatrices];
    matrices[0] = matriz;
    matrices[1] = matriz;
    Hebra hebra = new HebraCoincidencia(matrices, valor);
    int filaInicio = 1;
    int filaTermino = dimension;
    int columnaInicio = 1;
    int columnaTermino = dimension;
    ZonaMatriz zonaMatriz = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino);
    hebra.asignarAreaOperacion(zonaMatriz);
    HebraCoincidencia hebraCoincidencia = (HebraCoincidencia) hebra;
    hebraCoincidencia.buscarValor();
    int resultadoEsperado = 8;
    int resultadoBusqueda = hebraCoincidencia.getResultado();
    Assert.assertEquals(resultadoEsperado, resultadoBusqueda);
  }

  @Test
  public void encuentra2UnosEnPrimeraFilaDeMatriz2x2() {
    int dimension = 2;
    Matriz matriz = new Matriz(dimension);
    int valor = 1;
    TestUtils.llenarMatrizConValor(matriz, valor);
    int cantidaMatrices = 1;
    Matriz[] matrices = new Matriz[cantidaMatrices];
    matrices[0] = matriz;
    Hebra hebra = new HebraCoincidencia(matrices, valor);
    int filaInicio = 1;
    int filaTermino = 1;
    int columnaInicio = 1;
    int columnaTermino = dimension;
    ZonaMatriz zonaMatriz = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino);
    hebra.asignarAreaOperacion(zonaMatriz);
    HebraCoincidencia hebraCoincidencia = (HebraCoincidencia) hebra;
    hebraCoincidencia.buscarValor();
    int resultadoEsperado = 2;
    int resultadoBusqueda = hebraCoincidencia.getResultado();
    Assert.assertEquals(resultadoEsperado, resultadoBusqueda);
  }

  @Test
  public void encuentra4UnosEnMatriz2x2SinZonaMatriz() {
    int dimension = 2;
    Matriz matriz = new Matriz(dimension);
    int valor = 1;
    TestUtils.llenarMatrizConValor(matriz, valor);
    int cantidaMatrices = 1;
    Matriz[] matrices = new Matriz[cantidaMatrices];
    matrices[0] = matriz;
    Hebra hebra = new HebraCoincidencia(matrices, valor);
    HebraCoincidencia hebraCoincidencia = (HebraCoincidencia) hebra;
    hebraCoincidencia.buscarValor();
    int resultadoEsperado = 4;
    int resultadoBusqueda = hebraCoincidencia.getResultado();
    Assert.assertEquals(resultadoEsperado, resultadoBusqueda);
  }

}