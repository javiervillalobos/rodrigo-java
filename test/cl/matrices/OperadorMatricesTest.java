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
}