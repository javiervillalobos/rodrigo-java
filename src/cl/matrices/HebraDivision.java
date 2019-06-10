package cl.matrices;

public class HebraDivision extends Hebra {

  private int[][] numerosPrimos;

  public HebraDivision(Matriz[] matrices, int[][] numerosPrimos) {
    setMatrices(matrices);
    this.numerosPrimos = numerosPrimos;
  }

  public HebraDivision() {
  }

  public void aplicar() {
    int cantidadMatrices = obtenerCantidadMatrices();

    for (int indiceMatriz = 0; indiceMatriz < cantidadMatrices; indiceMatriz++) {
      Matriz matriz = matrices[indiceMatriz];
      if (zonaMatriz == null) {
        zonaMatriz = new ZonaMatriz(1, 1, matriz.getDimension(), matriz.getDimension());
      }

      if (!zonaMatriz.considerarMatriz(indiceMatriz)) {
        continue;
      }

      int[] primos = numerosPrimos[indiceMatriz];
      if (primos != null) {
        for (int fila = zonaMatriz.getFilaInicio(); fila <= zonaMatriz.getFilaTermino(); fila++) {
          for (int columna = zonaMatriz.getColumnaInicio(); columna <= zonaMatriz.getColumnaTermino(); columna++) {
            for (int indicePrimo = 0; indicePrimo < primos.length; indicePrimo++) {
              int primo = primos[indicePrimo];
              int valorMatriz = matriz.obtenerValor(fila, columna);
              if (valorMatriz == primo) {
                int division = valorMatriz / primo;
                matriz.agregarValor(fila, columna, division);
              }
            }
          }
        }
      }
    }
  }

  public void asignarNumerosPrimos(int[][] numerosPrimos) {
    this.numerosPrimos = numerosPrimos;
  }

  @Override
  public void run() {
    aplicar();
    usada = true;
  }

}