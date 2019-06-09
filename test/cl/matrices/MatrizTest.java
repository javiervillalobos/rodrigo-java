package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class MatrizTest {

  @Test
  public void muestraMatriz2x2ConUnosCorrectamente() {
    int dimension = 2;
    int valorParaMatriz = 1;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, valorParaMatriz);

    String resultadoEsperado = "|1 1|\n|1 1|";
    String resultadoMostrar = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultadoMostrar);
  }

  @Test
  public void muestraMatriz5x5ConUnosCorrectamente() {
    int dimension = 5;
    int valorParaMatriz = 1;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, valorParaMatriz);

    String resultadoEsperado = "|1 1 1 1 1|\n|1 1 1 1 1|\n|1 1 1 1 1|\n|1 1 1 1 1|\n|1 1 1 1 1|";
    String resultadoMostrar = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultadoMostrar);
  }

  @Test
  public void muestraMatriz5x5ConValoresIncrementalesCorrectamente() {
    int dimension = 5;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz);

    String resultadoEsperado = "|1 2 3 4 5|\n|6 7 8 9 10|\n|11 12 13 14 15|\n|16 17 18 19 20|\n|21 22 23 24 25|";
    String resultadoMostrar = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultadoMostrar);
  }

  @Test
  public void sePuedeAgregarValor5EnFila2Columna2DeMatrix5x5Correctamente() {
    int dimension = 5;
    int valor = 1;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValor(matriz, valor);
    int fila = 2;
    int columna = 2;
    int nuevoValor = 5;
    matriz.agregarValor(fila, columna, nuevoValor);

    String resultadoEsperado = "|1 1 1 1 1|\n|1 5 1 1 1|\n|1 1 1 1 1|\n|1 1 1 1 1|\n|1 1 1 1 1|";
    String resultadoMostrar = matriz.mostrar();
    Assert.assertEquals(resultadoEsperado, resultadoMostrar);
  }

  @Test
  public void seObtieneValor10DeFila2Columna5EnMatriz5x5() {
    int dimension = 5;
    Matriz matriz = new Matriz(dimension);
    TestUtils.llenarMatrizConValoresIncrementales(matriz);
    int fila = 2;
    int columna = 5;    
    int resultadoEsperado = 10;

    int resultadoMatriz = matriz.obtenerValor(fila, columna);

    Assert.assertEquals(resultadoEsperado, resultadoMatriz);
  }

  @Test
  public void obtieneNombreMatriz() {
    String nombreEsperado = "A";
    int dimension = 2;
    Matriz matriz = new Matriz("A", dimension);
    String nombreMatriz = matriz.getNombre();
    Assert.assertEquals(nombreEsperado, nombreMatriz);
  }
}