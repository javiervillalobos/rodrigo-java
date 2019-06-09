package cl.matrices;

public class TestUtils {

  public static void llenarMatrizConValor(Matriz matriz, int valor) {
    int dimension = matriz.getDimension();
    for (int fila = 1; fila <= dimension; fila++) {
      for (int columna = 1; columna <= dimension; columna++) {
        matriz.agregarValor(fila, columna, valor);
      }
    }
  }

  public static void llenarMatrizConValoresIncrementales(Matriz matriz) {
    int dimension = matriz.getDimension();
    int valor = 1;
    for (int fila = 1; fila <= dimension; fila++) {
      for (int columna = 1; columna <= dimension; columna++) {
        matriz.agregarValor(fila, columna, valor);
        valor++;
      }
    }
  }


}