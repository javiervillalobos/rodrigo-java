package cl.matrices;

public class HebraCoincidencia extends Hebra {

  private int coincidencias = 0;
  private int valorABuscar = 0;

  public HebraCoincidencia() {
  }

  public HebraCoincidencia(Matriz[] matrices, int valorABuscar) {
    setMatrices(matrices);
    this.valorABuscar = valorABuscar;
  }

  public int getResultado() {
    return coincidencias;
  }

  public void buscarValor() {
    coincidencias = 0;
    int cantidadMatrices = obtenerCantidadMatrices();
    for (int indiceMatriz = 0; indiceMatriz < cantidadMatrices; indiceMatriz++) {
      Matriz matriz = matrices[indiceMatriz];
      if (zonaMatriz == null) {
        zonaMatriz = new ZonaMatriz(1, 1, matriz.getDimension(), matriz.getDimension());
      }

      if (!zonaMatriz.considerarMatriz(indiceMatriz)) {
        continue;
      }

      for (int fila = zonaMatriz.getFilaInicio(); fila <= zonaMatriz.getFilaTermino(); fila++) {
        for (int columna = zonaMatriz.getColumnaInicio(); columna <= zonaMatriz.getColumnaTermino(); columna++) {
          int valorMatriz = matriz.obtenerValor(fila, columna);
          if (valorMatriz == valorABuscar) {
            coincidencias++;
          }
        }
      }
    }
  }

  public void setValorABuscar(int valorABuscar) {
    this.valorABuscar = valorABuscar;
  }

  @Override
  public void run() {
    buscarValor();
    usada = true;
  }

}