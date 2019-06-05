package cl.matrices;

import java.util.Random;

public class Matriz {

  private int[][] arreglo;

	public Matriz(int dimension) {
    arreglo = new int[dimension][dimension];
	}

	public void llenarAlAzar() {
    Random random = new Random();
    for (int row = 0; row < arreglo.length; row++) {
      for (int col = 0; col < arreglo.length; col++) {
        int valor = random.nextInt(10) + 1;
        arreglo[row][col] = valor;
      }
    }
  }

	public void llenarContinuo() {
    int valor = 1;
    for (int row = 0; row < arreglo.length; row++) {
      for (int col = 0; col < arreglo.length; col++) {
        arreglo[row][col] = valor;
        valor++;
      }
    }
  }

  public int obtenerValor(int rowPos, int colPos) {
    int colIndex = colPos - 1;
    int rowIndex = rowPos - 1;
		return arreglo[rowIndex][colIndex];
  }

  @Override
  public String toString() {
    String result = null;
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < arreglo.length; row++) {
      sb.append("|");
      for (int col = 0; col < arreglo.length; col++) {
        int valor = arreglo[row][col];
        sb.append(valor < 10 ? " " + valor: valor);
        if (col < arreglo.length - 1) {
          sb.append(" ");
        }
      }
      sb.append("|\n");
    }
    result = sb.toString();
    return result;
  }

  public int[] buscar(int valorAEncontrar) {
    return null;
  }
}