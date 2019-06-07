package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class MatrizTest {

  @Test
  public void setAnArrayNxNByDimension() {
    int expectedLenght = 2;
    int dimension = 2;
    int[][] matriz = new int[dimension][dimension];
    Assert.assertEquals(expectedLenght, matriz.length);
  }

  @Test
  public void llenarMatriz2x2()  {
    Matriz matriz = new Matriz(2);
    matriz.llenarAlAzar();
    int expectedMinimum = 1;
    int valor = matriz.obtenerValor(1,1);
    Assert.assertTrue("El valor obtenido no es mayor o igual a " + expectedMinimum + " / valor obtenido: " + valor, valor >= expectedMinimum);
  } 


  @Test
  public void encuentraElValor10En25() {
    int valorAEncontrar = 10;
    int[] expectedPos = {2,5};
    Matriz matriz = new Matriz(5);
    matriz.llenarContinuo();
    int[] posicion = matriz.buscar(valorAEncontrar);
    Assert.assertEquals(expectedPos[0], posicion[0]);
    Assert.assertEquals(expectedPos[1], posicion[1]);
  }
}