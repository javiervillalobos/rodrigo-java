package cl.matrices;

public class HebraCoincidenciaExacta extends Hebra {

  private int[][] coincidencias = null;

  public HebraCoincidenciaExacta(Matriz[] matrices) {
    setMatrices(matrices);
  }

  public HebraCoincidenciaExacta() {
  }

  public int[][] getResultado() {
    return coincidencias;
  }

  public void buscar() {
    Matriz matriz1 = matrices[0];
    Matriz matriz2 = matrices[1];
    if (zonaMatriz == null) {
      zonaMatriz = new ZonaMatriz(1, 1, matriz1.getDimension(), matriz1.getDimension());
    }

    coincidencias = new int[matriz1.getDimension()][matriz1.getDimension()];
    for (int fila = zonaMatriz.getFilaInicio(); fila <= zonaMatriz.getFilaTermino(); fila++) {
      for (int columna = zonaMatriz.getColumnaInicio(); columna <= zonaMatriz.getColumnaTermino(); columna++) {
        int valorMatriz1 = matriz1.obtenerValor(fila, columna);
        int valorMatriz2 = matriz2.obtenerValor(fila, columna);
        if (valorMatriz1 == valorMatriz2) {
          coincidencias[fila - 1][columna - 1] = valorMatriz1;
        }
      }
    }
  }

  @Override
  public void run() {
    buscar();
    usada = true;
  }

}